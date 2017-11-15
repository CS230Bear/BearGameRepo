
package com.redthirddivision.firestorm.utils;


public class Util {

    private static final String OS = System.getProperty("os.name").toUpperCase();

    public static String getOSName() {
        return OS;
    }

    /**
     * @return True if the player is on a Windows PC.
     * @since 1.0.0
     */
    public static boolean isWindows() {
        return OS.contains("WIN");
    }

    /**
     * @return True if the player is on a Mac.
     * @since 1.0.0
     */
    public static boolean isMac() {
        return OS.contains("MAC");
    }

    /**
     * @return True if the player is on a Unix machine.
     * @since 1.0.0
     */
    public static boolean isUnix() {
        return OS.contains("NIX") || OS.contains("NUX") || OS.contains("AIX");
    }

}
