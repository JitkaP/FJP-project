package main.compiler;

import antlr.gen.LangLexer;
import antlr.gen.LangParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

//Singleton
public class Compiler {

    private Compiler() {
        //empty constructor
    }

    private static final Compiler INSTANCE = new Compiler();

    public void run(String in) {
        CharStream convertedInput = CharStreams.fromString(in);

        LangLexer langLexer = new LangLexer(convertedInput);
        CommonTokenStream tokens = new CommonTokenStream(langLexer);

        LangParser langParser = new LangParser(tokens);

        langParser.setBuildParseTree(true);

        ParseTree parseTree = langParser.block();

    }

    public static Compiler getInstance() {
        return INSTANCE;
    }
}