package com.hprocoder.order_processing_system_spring_integration.config;

import com.hprocoder.order_processing_system_spring_integration.integration.CsvToOrderTransformer;
import com.hprocoder.order_processing_system_spring_integration.integration.OrderRouter;
import com.hprocoder.order_processing_system_spring_integration.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class IntegrationConfig {

  @Bean
  public MessageChannel orderInputChannel() {
    return  MessageChannels.direct().getObject();
  }
  @Bean
  public IntegrationFlow orderFlow(){
    return IntegrationFlow.from("orderInputChannel")
        .split()
        .transform(csvToOrderTransformer())
        .route(orderRouter())
        .get();
  }

  @Bean
  public GenericTransformer<String, Order> csvToOrderTransformer() {
   return new CsvToOrderTransformer();
  }

  @Bean
  public MessageChannel billingChannel(){
    return new DirectChannel();
  }

  @Bean
  public MessageChannel shippingChannel(){
    return new DirectChannel();
  }

  @Bean
  MessageChannel errorChannel(){
    return new DirectChannel();
  }

  @Bean
  public AbstractMessageRouter orderRouter(){
    return new OrderRouter();
  }

}
