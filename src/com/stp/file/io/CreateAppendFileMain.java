package com.stp.file.io;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * @author sathaphorn.stp
 * @since 21-09-2018, 01:32
 */
public class CreateAppendFileMain {

  public static void main(String[] args) {
    Charset charset2 = Charset.forName("TIS-620"); // Encoding: ANSI
    Charset charset = Charset.forName("UTF-8"); // Encoding: UTF-8
    File file = new File("resource/example.txt");

    String line = "Hello World!!!";

    if (file.isFile()) {
      // Append
      try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset, WRITE, APPEND)) {
        // Write
        writer.newLine();
        writer.write(line, 0, line.length());

      } catch (IOException x) {
        System.err.format("IOException Writer: %s%n", x);
      }

    } else {
      // New File
      try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset, CREATE, WRITE)) {
        writer.write(line, 0, line.length());
      } catch (IOException x) {
        System.err.format("IOException Writer: %s%n", x);
      }
    }
  }
}
