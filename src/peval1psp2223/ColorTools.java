package peval1psp2223;

/**
 * @author Jose Ramon Gallego Velez
 * @version 1.0.
 * @info Class that we have to set colors to the console texts
 */

public class ColorTools {

    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static String blackTxt() {
        return ANSI_BLACK;
    }

    public static String blueTxt() {
        return ANSI_BLUE;
    }

    public static String cyanTxt() {
        return ANSI_CYAN;
    }

    public static String purpleTxt() {
        return ANSI_PURPLE;
    }

    public static String greenTxt() {
        return ANSI_GREEN;
    }

    public static String redTxt() {
        return ANSI_RED;
    }

    public static String defaultTxt() {
        return ANSI_RESET;
    }

    public static String whiteTxt() {
        return ANSI_WHITE;
    }

    public static String yellowTxt() {
        return ANSI_YELLOW;
    }
}

