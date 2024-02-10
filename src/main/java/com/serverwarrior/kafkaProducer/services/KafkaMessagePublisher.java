package com.serverwarrior.kafkaProducer.services;

public interface KafkaMessagePublisher {
  public void sendMessageToTopic(String message);
}
