package com.serverwarrior.kafkaProducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {
  @Bean
  public NewTopic createTopic() {
    return new NewTopic("customer-message-topic", 3, (short) 1);
  }


  @Bean
  public NewTopic createCustomerTopic() {
    return new NewTopic("customer-message-topic", 3, (short) 1);
  }

  @Bean
  public NewTopic createPartitionTopic() {
    return new NewTopic("message-to-partition", 5, (short) 1);
  }
}
