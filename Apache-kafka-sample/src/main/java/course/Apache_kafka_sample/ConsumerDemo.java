package course.Apache_kafka_sample;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(ConsumerDemo.class.getName());
		String bootstrapServerString = "127.0.0.1:9092";
		String topic = "first_topic";
		String groupId = "first_group";
		
		Properties properties = new Properties();
		
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerString);
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		//Creating consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		
		
		//subscribeing consumer to the topic
		
		consumer.subscribe(Collections.singleton(topic));
		
		//Accessing data and polling for new data 
		
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1));
			
			for(ConsumerRecord<String, String> record: records) {
				logger.info("Key : "+record.key()+", Value: "+record.value());
				logger.info("Partiton: "+records.partitions()+", Offset: "+record.offset());
			}
			
		}
		 
	}
	
}
