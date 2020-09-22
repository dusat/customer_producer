package cz.tkacikd.customer_producer.producer;

import cz.tkacikd.customer_producer.domain.CustomerCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CardDataProducerService {

    private KafkaTemplate<String, CustomerCard> kafkaTemplate;

    @Autowired
    CardDataProducerService(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(CustomerCard customerCard) {
        kafkaTemplate.send("csttopic", customerCard);
    }
}
