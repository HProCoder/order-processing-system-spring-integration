package com.hprocoder.order_processing_system_spring_integration.service;

import com.hprocoder.order_processing_system_spring_integration.config.IntegrationConfig;
import com.hprocoder.order_processing_system_spring_integration.exception.FileProcessingException;
import com.hprocoder.order_processing_system_spring_integration.util.CsvReaderUtil;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OrderProcessingService {

  @Autowired
  private IntegrationConfig integrationConfig; // The input channel for Spring Integration

  public void processFile(MultipartFile file) throws IOException {
    try {
      // Read the content of the CSV file
      String[] lines = CsvReaderUtil.readCsvFile(file);
      for (String line : lines) {
        // Send each line (each order) into the integration channel
        Message<String> message = MessageBuilder.withPayload(line).build();
        integrationConfig.orderInputChannel().send(message); // Send the line for processing via Spring Integration
      }
    } catch (IOException e) {
      throw new FileProcessingException("Failed to process the CSV file: " + file.getOriginalFilename(), e);
    }
  }
}
