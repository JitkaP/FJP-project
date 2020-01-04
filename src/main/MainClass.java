package main;

import main.compiler.Compiler;
import main.compiler.entity.Instruction;

import java.io.*;
import java.util.List;

/**
 * Main class of the FJP project
 */
public class MainClass {

    /**
     * Entry point of the program
     * @param args arguments of the command line
     */
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Not enough arguments. Usage: <input_file>");
            System.exit(1);
        }

        String inputFile = args[0];
        String inputStream = readFromFile(inputFile);

        List<Instruction> instructions = Compiler.getInstance().run(inputStream);
        if (instructions != null) {
            int dotIndex = inputFile.lastIndexOf(".");
            String extension = "";
            if (dotIndex != -1) {
                extension = inputFile.substring(dotIndex);
                inputFile = inputFile.substring(0, dotIndex);
            }

            String outputFile = inputFile + "_output" + extension;
            writeToFile(outputFile, instructions);
        }
    }

    /**
     * Load input from file
     * @param inputFile input file
     * @return loaded input represents by String class
     */
    private static String readFromFile(String inputFile) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return resultStringBuilder.toString();
    }

    /**
     * Save instructions to file
     * @param outputFile output file
     * @param instructions list of instructions
     */
    private static void writeToFile(String outputFile, List<Instruction> instructions) {
        try {
            PrintStream out = new PrintStream(new File(outputFile), "UTF-8");

            for (int i = 0; i < instructions.size(); i++) {
                out.print(instructions.get(i));
            }

            out.close();

        } catch(FileNotFoundException | UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }
}
