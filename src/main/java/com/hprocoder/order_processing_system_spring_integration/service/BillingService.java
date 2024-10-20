package com.hprocoder.order_processing_system_spring_integration.service;

import com.hprocoder.order_processing_system_spring_integration.model.Order;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

  @ServiceActivator(inputChannel = "billingChannel")
  public void generateInvoice(Order order){
    System.out.println("Generating invoice for Order ID: " + order.getOrderId());
    System.out.println("Customer: " + order.getCustomerName());
    System.out.println("Product: " + order.getProduct());
    System.out.println("Quantity: " + order.getQuantity());
    System.out.println("Order Type: " + order.getType());

    // Business logic to generate invoice
    String invoice = "Invoice for order " + order.getOrderId() + " generated.";

    // In a real scenario, you would save this invoice to a database or send it to the customer
    System.out.println(invoice);
  }
}
