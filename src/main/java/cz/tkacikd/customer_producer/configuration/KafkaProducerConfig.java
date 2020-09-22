package cz.tkacikd.customer_producer.configuration;

import cz.tkacikd.customer_producer.domain.CustomerCard;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrap_server;

    @Value("${spring.kafka.producer.key-serializer}")
    private String key_serializer;

    @Value("${spring.kafka.producer.value-serializer}")
    private String value_serializer;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrap_server);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                key_serializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                value_serializer);
        return props;
    }

    @Bean
    public ProducerFactory<String, CustomerCard> producerFactory() {
        return new DefaultKafkaProducerFactory<String, CustomerCard>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, CustomerCard> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}

