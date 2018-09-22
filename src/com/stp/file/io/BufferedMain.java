package com.stp.file.io;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * @author sathaphorn.stp
 * @since 21-09-2018, 00:36
 */
public class BufferedMain {

  public static void main(String[] args) {
    Charset charset = Charset.forName("TIS-620"); // Encoding: ANSI
    Charset charset2 = Charset.forName("UTF-8"); // Encoding: UTF-8
    File file = new File("resource/source.txt");
    File file2 = new File("resource/target.txt");
    // Path path = Paths.get(file.getPath());

    if (file.isFile()) {
      // Read File
      try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
        String line = null;
        try (BufferedWriter writer = Files.newBufferedWriter(file2.toPath(), charset2, CREATE, WRITE, APPEND)) {
          // Read
          boolean isNewLine = false;
          while ((line = reader.readLine()) != null) {

            // Enter Line: No Enter Line; Windows(CR LF), Mac(CR), Unix(LF)
            if (isNewLine) {
              writer.newLine();
              // writer.write(line + "\r\n");
            }

            // Write
            writer.write(line, 0, line.length());
            System.out.println(line);

            isNewLine = true;
          }

        } catch (IOException x) {
          System.err.format("IOException Writer: %s%n", x);
        }

      } catch (IOException x) {
        System.err.format("IOException Reader: %s%n", x);
      }

    } else {
      // New File
      String s = "";
      try (BufferedWriter writer = Files.newBufferedWriter(file2.toPath(), charset, CREATE)) {
        writer.write(s, 0, s.length());
      } catch (IOException x) {
        System.err.format("IOException Writer: %s%n", x);
      }
    }
  }
}
