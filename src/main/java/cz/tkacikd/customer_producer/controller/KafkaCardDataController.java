package cz.tkacikd.customer_producer.controller;

import cz.tkacikd.customer_producer.domain.CustomerCard;
import cz.tkacikd.customer_producer.producer.CardDataProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class KafkaCardDataController {

    private CardDataProducerService cardDataProducerService;

    @Autowired
    KafkaCardDataController(CardDataProducerService cardDataProducerService) {
        this.cardDataProducerService = cardDataProducerService;
    }

    @PostMapping("/carddata")
    public void produceMessage(@RequestBody CustomerCard customerCard) {
        cardDataProducerService.produce(customerCard);
    }
}
