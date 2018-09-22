package com.stp.prop;

/**
 * @author sathaphorn.stp
 * @since 22-09-2018, 15:11
 */
public class OSValidator {

  /*
   * Credit By mkyong(https://www.mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/)
   */

  private static String OS = System.getProperty("os.name").toLowerCase();

  public static void main(String[] args) {

    System.out.println(OS);

    if (isWindows()) {
      System.out.println("This is Windows");
    } else if (isMac()) {
      System.out.println("This is Mac");
    } else if (isUnix()) {
      System.out.println("This is Unix or Linux");
    } else if (isSolaris()) {
      System.out.println("This is Solaris");
    } else {
      System.out.println("Your OS is not support!!");
    }
  }

  private static boolean isWindows() {

    return (OS.contains("win"));

  }

  private static boolean isMac() {

    return (OS.contains("mac"));

  }

  private static boolean isUnix() {

    return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);

  }

  private static boolean isSolaris() {

    return (OS.contains("sunos"));

  }
}
