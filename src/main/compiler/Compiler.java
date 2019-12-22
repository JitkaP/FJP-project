package main.compiler;

import antlr.gen.LangLexer;
import antlr.gen.LangParser;
import main.compiler.entity.Block;
import main.compiler.entity.Instruction;
import main.compiler.entity.Procedure;
import main.compiler.entity.Program;
import main.compiler.visitor.ProgramVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

//Singleton
public class Compiler {

    private Compiler() {
        //empty constructor
    }

    private static final Compiler INSTANCE = new Compiler();

    public List<Instruction> run(String in) {
        CharStream convertedInput = CharStreams.fromString(in);

        LangLexer langLexer = new LangLexer(convertedInput);
        CommonTokenStream tokens = new CommonTokenStream(langLexer);
        LangParser langParser = new LangParser(tokens);

        langParser.setBuildParseTree(true);

        langParser.removeErrorListeners();
        langParser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree parseTree = langParser.program();
            Program program = new ProgramVisitor().visit(parseTree);

            // get all symbol tables
            List<Block> blocks = new ArrayList<>();
            blocks.add(program.getBlock());
            List<Procedure> procedures = program.getBlock().getProcedures();
            for (Procedure procedure: procedures) {
                blocks.add(procedure.getBlock());
            }

            // print all symbol tables
            for (Block block: blocks) {
                System.out.println("symbolTable = " + block.getSymbolTable().toString());
            }

            InstructionGenerator instructionGenerator = new InstructionGenerator(program);
            List<Instruction> instructions = instructionGenerator.generate();

            return instructions;

        } catch (ParseCancellationException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Compiler getInstance() {
        return INSTANCE;
    }
}