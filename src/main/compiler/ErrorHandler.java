package main.compiler;

import main.compiler.enums.EErrorType;

public class ErrorHandler {

    public static void throwError(EErrorType type) {
        System.err.println(type);
        System.exit(1);
    }

    public static void throwError(EErrorType type, String name) {
        System.err.print("ERROR: " + type);
        System.err.println(" Variable name = \"" + name + "\".");
        System.exit(1);
    }

}
