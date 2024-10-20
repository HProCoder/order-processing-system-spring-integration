package com.hprocoder.order_processing_system_spring_integration.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import com.hprocoder.order_processing_system_spring_integration.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderProcessingService orderProcessingService;

  @PostMapping("/upload")
  public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file) {
    if (file.isEmpty()) {
      return ResponseEntity.status(BAD_REQUEST).body("file is empty.");
    }

    try {
      orderProcessingService.processFile(file);
      return ResponseEntity.ok("The file was processed successfully.");
    } catch (Exception e) {
      return ResponseEntity.status(INTERNAL_SERVER_ERROR)
          .body("Error processing file : " + e.getMessage());
    }
  }
}
