package main;

import main.compiler.Compiler;

import java.io.*;

public class MainClass {

    private static String inputFile = "io_files/input.txt";

    public static void main(String[] args) {

        String inputStream = readFromFile(inputFile);

        Compiler.getInstance().run(inputStream);
    }

    private static String readFromFile(String inputFile) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultStringBuilder.toString();
    }
}