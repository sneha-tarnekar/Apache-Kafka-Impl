package com.kafka.service;

import com.kafka.model.Customer;
import com.kafka.util.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    public String add(List<Customer> customers) {
        if(!customers.isEmpty()) {
            for (Customer customer: customers) {
                kafkaTemplate.send(KafkaConstants.TOPIC,customer);
                System.out.println("***** Message published to Kafka topic ");
            }
        }
        return "Customer added to kafka queue successfully";
    }

}
