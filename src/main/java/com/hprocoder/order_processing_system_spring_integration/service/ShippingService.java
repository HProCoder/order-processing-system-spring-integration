package com.hprocoder.order_processing_system_spring_integration.service;

import com.hprocoder.order_processing_system_spring_integration.model.Order;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

  @ServiceActivator(inputChannel = "shippingChannel")
  public void organizeShipping(Order order){
    System.out.println("Organizing shipping for Order ID: " + order.getOrderId());
    System.out.println("Customer: " + order.getCustomerName());
    System.out.println("Product: " + order.getProduct());
    System.out.println("Quantity: " + order.getQuantity());
    System.out.println("Order Type: " + order.getType());

    // Business logic to organize shipping
    String shipment = "Shipment for order " + order.getOrderId() + " arranged.";

    // In a real scenario, this would involve coordinating with a logistics provider
    System.out.println(shipment);
  }
}
