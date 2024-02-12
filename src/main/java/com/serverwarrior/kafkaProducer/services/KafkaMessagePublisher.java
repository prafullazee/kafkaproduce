package com.serverwarrior.kafkaProducer.services;

import com.serverwarrior.kafkaProducer.models.Customer;

public interface KafkaMessagePublisher {
  void sendMessageToTopic(String message);

  void sendBulkMessageToTopic(String message);

  void sendMessageToTopic(Customer customer);

  void sendMessageToPartition(String message);
}
