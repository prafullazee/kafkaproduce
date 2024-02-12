package com.serverwarrior.kafkaProducer.services.impl;

import com.serverwarrior.kafkaProducer.models.Customer;
import com.serverwarrior.kafkaProducer.services.KafkaMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class KafkaMessagePublisherImpl implements KafkaMessagePublisher {
  @Autowired
  private KafkaTemplate<String, Object> template;

  @Override
  public void sendMessageToTopic(String message) {

    CompletableFuture<SendResult<String, Object>> future = template.send("test-topic", message);

    future.whenComplete((result, ex)-> {
      if (Objects.nonNull(ex)) {
        log.error("Error while sending message: " + ex.getMessage());
      }

      if (Objects.nonNull(result.getRecordMetadata())) {
        RecordMetadata metaData = result.getRecordMetadata();
        if (Objects.nonNull(metaData.topic())) {
          log.info("Message offset is: " + metaData.topic());
        }
        if (metaData.hasOffset()) {
          log.info("Message offset is: " + metaData.offset());
        }
      }
    });
  }

  @Override
  public void sendBulkMessageToTopic(String message) {
    CompletableFuture<SendResult<String, Object>> future = template.send("bulk-message-topic", message);

    future.whenComplete((result, ex)-> {
      if (Objects.nonNull(ex)) {
        log.error("Error while sending message: " + ex.getMessage());
      }

      if (Objects.nonNull(result.getRecordMetadata())) {
        RecordMetadata metaData = result.getRecordMetadata();
        if (Objects.nonNull(metaData.topic())) {
          log.info("Message offset is: " + metaData.topic());
        }
        if (metaData.hasOffset()) {
          log.info("Message offset is: " + metaData.offset());
        }
      }
    });
  }

  @Override
  public void sendMessageToTopic(Customer customer) {
    CompletableFuture<SendResult<String, Object>> future = template.send("customer-message-topic", customer);

    future.whenComplete((result, ex)-> {
      if (Objects.nonNull(ex)) {
        log.error("Error while sending message: " + ex.getMessage());
      }

      if (Objects.nonNull(result.getRecordMetadata())) {
        RecordMetadata metaData = result.getRecordMetadata();
        if (Objects.nonNull(metaData.topic())) {
          log.info("Message offset is: " + metaData.topic());
        }
        if (metaData.hasOffset()) {
          log.info("Message offset is: " + metaData.offset());
        }
      }
    });
  }

  @Override
  public void sendMessageToPartition(String message) {
    CompletableFuture<SendResult<String, Object>> future = template.send("message-to-partition", 2, null, message);

    future.whenComplete((result, ex)-> {
      if (Objects.nonNull(ex)) {
        log.error("Error while sending message: " + ex.getMessage());
      }

      if (Objects.nonNull(result.getRecordMetadata())) {
        RecordMetadata metaData = result.getRecordMetadata();
        if (Objects.nonNull(metaData.topic())) {
          log.info("Message offset is: " + metaData.topic());
        }
        if (metaData.hasOffset()) {
          log.info("Message offset is: " + metaData.offset());
        }
      }
    });
  }
}
