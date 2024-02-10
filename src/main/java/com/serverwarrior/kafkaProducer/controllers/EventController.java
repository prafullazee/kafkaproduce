package com.serverwarrior.kafkaProducer.controllers;

import com.serverwarrior.kafkaProducer.services.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce/events")
public class EventController
{
  @Autowired
  KafkaMessagePublisher kafkaMessagePublisher;

  @PostMapping("/publish")
  public ResponseEntity<?> publishMessage(@RequestBody String message) {
    kafkaMessagePublisher.sendMessageToTopic(message);
    return ResponseEntity.ok("Message published successfully.");
  }

  @PostMapping("/publish/bulk")
  public ResponseEntity<?> publishBulkMessages(@RequestBody String message) {
    for (int i=0; i<1000000; i++) {
      kafkaMessagePublisher.sendBulkMessageToTopic(message + i);
    }
    return ResponseEntity.ok("Message published successfully.");
  }
}
