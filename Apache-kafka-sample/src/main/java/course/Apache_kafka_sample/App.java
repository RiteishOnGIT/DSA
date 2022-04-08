package course.Apache_kafka_sample;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String bootStrapServerString = "127.0.0.1:9092";
    	Properties properties = new Properties();
    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServerString);
    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	
    	
    	KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
    	
    	ProducerRecord<String, String> record = new ProducerRecord<String, String>("fesffe", "hello_world");
    	
    	producer.send(record);
    	
    	producer.flush();
    	producer.close();
    }
}
