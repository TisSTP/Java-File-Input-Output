package com.stp;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class Main {

  public static void main(String[] args) {
    Charset charset = Charset.forName("UTF-8"); // Encoding: UTF-8
    File fileMain = new File("resource/example-main.txt");
    File fileTemp = new File("resource/example-temp.txt");

    if (fileTemp.isFile()) {
      // Create New File
      try (BufferedWriter writer = Files.newBufferedWriter(fileMain.toPath(), charset, CREATE, WRITE)) {
        // Write Header
        writer.write("- - - - - Header - - - - -");

        // Write Header 2
        writer.newLine();
        writer.write("- - - - - Head 2 - - - - -");

        // Read File Temp
        try (BufferedReader reader = Files.newBufferedReader(fileTemp.toPath(), charset)) {
          String line = "";
          while ((line = reader.readLine()) != null) {
            // Write Content
            writer.newLine();
            writer.write(line, 0, line.length());
          }
        } catch (IOException x) {
          System.err.format("IOException Reader: %s%n", x);
        }

        // Write Footer
        writer.newLine();
        writer.write("- - - - - Footer - - - - -");
      } catch (IOException x) {
        System.err.format("IOException Writer: %s%n", x);
      }

    } else {
      // Error: Find Not Found File example-temp.txt
      System.err.print("Error: Find Not Found File 'example-temp.txt'! ");
    }
  }

}
