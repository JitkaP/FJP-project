package main;

import main.compiler.Compiler;
import main.compiler.entity.Instruction;

import java.io.*;
import java.util.List;

/**
 * Main class of the FJP project
 */
public class MainClass {

    private static String inputFile = "io_files/input.txt";
    private static String outputFile = "io_files/output.txt";

    /**
     * Entry point of the program
     * @param args arguments of the command line
     */
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("malo");
            System.exit(1);
        }

        inputFile = args[0];
        outputFile = args[1];

        String inputStream = readFromFile(inputFile);

        List<Instruction> instructions = Compiler.getInstance().run(inputStream);

        if (instructions != null) {
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
                System.out.print(instructions.get(i)); // todo: jen pro test! pak smazat!
            }

            out.close();

        } catch(FileNotFoundException | UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }
}
