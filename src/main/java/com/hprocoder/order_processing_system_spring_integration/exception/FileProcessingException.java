package com.hprocoder.order_processing_system_spring_integration.exception;

public class FileProcessingException extends RuntimeException {
  public FileProcessingException(String message) {
    super(message);
  }

  public FileProcessingException(String message, Throwable cause) {
    super(message, cause);
  }
}
