package com.stp.file.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author sathaphorn.stp
 * @since 22-09-2018, 15:27
 */
public class ZipFile {

  public static void main(String[] args) {
    List<String> files = new ArrayList<>();
    byte[] buffer = new byte[1024];

    String zipFile = "resource/example.zip";
    String pathSource = "resource";
    files.add("example-main.txt");
    files.add("example-temp.txt");

    try {
      FileOutputStream fos = new FileOutputStream(zipFile);
      ZipOutputStream zos = new ZipOutputStream(fos);

      System.out.println("Output to zip : " + zipFile);

      for (String file : files) {
        System.out.print("File Added : " + file);
        ZipEntry zipEntry = new ZipEntry(file);
        zos.putNextEntry(zipEntry);

        FileInputStream ins = new FileInputStream(pathSource + File.separator + file);

        int len;
        while ((len = ins.read(buffer)) > 0) {
          zos.write(buffer, 0, len);
        }

        ins.close();
      }

      zos.closeEntry();
      // remember close it
      zos.close();

      System.out.println("Done");
    } catch (IOException ex) {
      System.err.println("Error : " + ex.getMessage());
      ex.printStackTrace();
    }

  }

}
