package com.stp.file.io;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * @author sathaphorn.stp
 * @since 21-09-2018, 00:37
 */
public class UnbufferedMain {

  public static void main(String[] args) {
    Charset charset = Charset.forName("TIS-620"); // Encoding: ANSI
    Charset charset2 = Charset.forName("UTF-8"); // Encoding: UTF-8
    File file = new File("resource/source.txt");
    File file2 = new File("resource/target.txt");
    // Path path = Paths.get(file.getPath());

    if (file.isFile()) {
      // Read File
      try {
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        int character;

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file2), charset2)) {
          // Read
          while ((character = reader.read()) != -1) {
            writer.write((char) character);
            System.out.print((char) character);
          }
        }

        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    } else {
      // New File

    }
  }
}
