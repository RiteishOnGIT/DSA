package course.Apache_kafka_sample.kafka_tutorial_twitter;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

public class TwitterProducer {

	Logger logger = LoggerFactory.getLogger(TwitterProducer.class.getName());

	public TwitterProducer() {
	}

	public static void main(String[] args) {
		new TwitterProducer().run();
	}

	public void run() {
		BlockingDeque<String> msgQueue = new LinkedBlockingDeque<String>(100);
		Client client = createTwitterClient(msgQueue);
		client.connect();
		while (!client.isDone()) {
			String msg = null;
			try {
				msg = msgQueue.poll(5, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
				client.stop();
			}

			if (msg != null) {
				logger.info(msg);
			}

		}
		logger.info("End of the application");
	}

	public Client createTwitterClient(BlockingDeque<String> msgQueue) {

		String consumerKey = "CiNUWjuHW62rJKqPumEc8Z9ie";
		String consumerSecret = "rsCLfEykkbrYEcTgtifwaTzbG6o9uXmYUUiPOTtuCt0wwLirbn";
		String token = "1513125066015268869-mHjQ9QdtTJoTVuU4uSHtY7lYhOH7EL";
		String secret = "8bwQH2UaIxq6LPTxh7D5B1BfztkNCE2RnJEmZkDQw6tgj";

		/**
		 * Declare the host you want to connect to, the endpoint, and authentication
		 * (basic auth or oauth)
		 */

		Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
		StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
		// Optional: set up some followings and track terms
		List<Long> followings = Lists.newArrayList(1234L, 566788L);
		List<String> terms = Lists.newArrayList("twitter", "api");
		hosebirdEndpoint.followings(followings);
		hosebirdEndpoint.trackTerms(terms);

		// These secrets should be read from a config file
		Authentication hosebirdAuth = new OAuth1(consumerKey, consumerSecret, token, secret);

		ClientBuilder builder = new ClientBuilder().name("Hosebird-Client-01") // optional: mainly for the logs
				.hosts(hosebirdHosts).authentication(hosebirdAuth).endpoint(hosebirdEndpoint)
				.processor(new StringDelimitedProcessor(msgQueue)); // optional: use this if you want to process client
																	// events

		Client hosebirdClient = builder.build();
		// Attempts to establish a connection.
		return hosebirdClient;
	}

}
