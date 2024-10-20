package com.hprocoder.order_processing_system_spring_integration.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class CsvReaderUtil {

  public static String[] readCsvFile(MultipartFile file) throws IOException {
    List<String> lines = new ArrayList<>(); // List to store all lines

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) { // Read all lines
        lines.add(line); // Add each line to the list
      }
    } catch (IOException e) {
      throw new IOException("Error reading CSV file: " + e.getMessage(), e);
    }

    // Convert the list to an array and return
    return lines.toArray(new String[0]);}
  }