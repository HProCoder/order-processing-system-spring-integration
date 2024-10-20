package com.hprocoder.order_processing_system_spring_integration.integration;

import com.hprocoder.order_processing_system_spring_integration.model.Order;
import com.hprocoder.order_processing_system_spring_integration.model.OrderType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class OrderRouter extends AbstractMessageRouter {

  @Autowired
  MessageChannel billingChannel;

  @Autowired
  MessageChannel shippingChannel;

  @Autowired
  MessageChannel errorChannel;

  @Override
  protected List<MessageChannel> determineTargetChannels(Message<?> message) {
    Order order = (Order) message.getPayload();
    List<MessageChannel> channels = new ArrayList<>();

    if(OrderType.PURCHASE.equals(order.getType())){
      channels.add(billingChannel);
    }
    else
      if(OrderType.RENTAL.equals(order.getType())){
        channels.add(shippingChannel);
      }
      else{
        channels.add(errorChannel);
      }
    return channels;
  }

}
