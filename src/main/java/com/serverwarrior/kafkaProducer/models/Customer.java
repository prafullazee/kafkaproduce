package com.serverwarrior.kafkaProducer.models;

import lombok.Data;

@Data
public class Customer {
  private String name;
  private String email;
  private Integer age;
  private String phone;
}
