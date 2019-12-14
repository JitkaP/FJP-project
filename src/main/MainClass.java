package main;

import main.compiler.Compiler;

public class MainClass {

    private static String input = "const int tst := 2;";

    public static void main(String[] args) {
        Compiler.getInstance().run(input);
    }
}