package com.hprocoder.order_processing_system_spring_integration.model;

public enum OrderType {
  PURCHASE,
  RENTAL,
  NO;

   public static OrderType fromValue(String value){
    for (OrderType orderType : OrderType.values()){
      if(orderType.name().equalsIgnoreCase(value)){
        return orderType;
      }
    }
    throw new IllegalArgumentException("Invalid OrderType : "+ value);
  }
}
