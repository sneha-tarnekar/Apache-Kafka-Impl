package com.kafka.service;

import com.kafka.model.Customer;
import com.kafka.util.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {

    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
    public Customer listener(Customer c) {
        System.out.println("*** message recieved from Kafka topic : " + c);
        return c;
    }
}
