package com.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProducer {
	private final static Logger logger =  LoggerFactory.getLogger(SimpleProducer.class);
    private final static String TOPIC_NAME = "test2.kafka";
    private final static String BOOTSTRAP_SERVERS = "54.65.28.158:9092";

    public static void main(String[] args) {

        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);

  //      String messageKey = "예리씨 화장실 가시네용";
        String messageValue = "예리씨 지금 뭐하세용?";

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC_NAME, messageValue);
        producer.send(record);
        logger.info("{}", record);
        producer.flush();
        producer.close();
    }
}
