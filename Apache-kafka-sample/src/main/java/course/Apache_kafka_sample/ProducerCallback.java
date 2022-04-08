package course.Apache_kafka_sample;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerCallback {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Logger logger = LoggerFactory.getLogger(ProducerCallback.class);
		
		//setting up properties
		String bootStrapServerString = "127.0.0.1:9092";
    	Properties properties = new Properties();
    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServerString);
    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	
    	
    	KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
    	
    	//Creating producer record
    	for(int i=1; i<=10; i++) {
    		
    		String topic = "first_topic";
    		String message = "Hello from java : "+ i;
    		String key = "ID_"+i;
    		
    		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, message);
        	
    		logger.info("KEY : "+key);
    		
        	//Sending Data asynchronously
        	producer.send(record, new Callback() {
    			
    			@Override
    			public void onCompletion(RecordMetadata metadata, Exception exception) {	
    				
    				if(exception == null) {
    					logger.info("Recived new metadata \n"+
    						"Topic: "+metadata.topic()+"\n"+
    						"partition: "+metadata.partition()+"\n"+
    						"offset: "+metadata.offset()+"\n"
    						);
    					//data send successfully
    				}
    				else {
    					logger.error(exception.toString());
    				}
    				
    			}
    		}).get();
    	}
    	
    	
    	producer.flush();
    	producer.close();
		
	}
}
