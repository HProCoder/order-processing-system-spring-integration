package com.hprocoder.order_processing_system_spring_integration.integration;

import com.hprocoder.order_processing_system_spring_integration.model.Order;
import com.hprocoder.order_processing_system_spring_integration.model.OrderType;
import org.springframework.integration.core.GenericTransformer;

public class CsvToOrderTransformer implements GenericTransformer<String, Order> {

  @Override
  public Order transform(String csvLine) {
    String [] fields = csvLine.split(",");
    return Order.builder()
        .orderId(Long.parseLong(fields[0]))
        .customerName(fields[1])
        .product(fields[2])
        .quantity(Integer.parseInt(fields[3]))
        .type(OrderType.fromValue(fields[4]))
        .build();
  }
}
