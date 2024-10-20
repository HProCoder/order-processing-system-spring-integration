package com.hprocoder.order_processing_system_spring_integration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

  private Long orderId;
  private String customerName;
  private String product;
  private int quantity;
  private OrderType type;
}
