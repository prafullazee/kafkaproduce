package com.serverwarrior.kafkaProducer.services;

public interface KafkaMessagePublisher {
  void sendMessageToTopic(String message);

  void sendBulkMessageToTopic(String s);
}
