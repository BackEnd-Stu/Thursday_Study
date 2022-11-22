package com.example;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProducer2 {
	private final static Logger logger =  LoggerFactory.getLogger(SimpleProducer.class);
    private final static String TOPIC_NAME = "test2.kafka";
    private final static String BOOTSTRAP_SERVERS = "52.195.12.139:9092";

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);

        String messageKey = "테스트 키2";
        String messageValue = "테스트 값2";

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC_NAME, messageKey, messageValue);
        RecordMetadata md = producer.send(record).get();
        logger.info(md.toString());
        producer.flush();
        producer.close();
    }
}
