package main.compiler;

import antlr.gen.LangLexer;
import antlr.gen.LangParser;
import main.compiler.entity.Program;
import main.compiler.visitor.ProgramVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.text.ParseException;

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

        langParser.removeErrorListeners();
        langParser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree parseTree = langParser.program();

            Program program = new ProgramVisitor().visit(parseTree);
        } catch (ParseCancellationException e) {
            System.err.println(e.getMessage());
        }

    }

    public static Compiler getInstance() {
        return INSTANCE;
    }
}