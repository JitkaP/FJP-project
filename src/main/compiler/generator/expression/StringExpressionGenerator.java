package main.compiler.generator.expression;

import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.ArrayCharValue;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.CharValue;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

/**
 * Generator for string expressions.
 */
public class StringExpressionGenerator extends Generator {

    public StringExpression stringExpression;

    public StringExpressionGenerator(StringExpression stringExpression) {
        this.stringExpression = stringExpression;
    }

    /**
     * Method for processing and generating instructions of ???
     */
    public void generate() {
        int tokenPointer = this.stringExpression.getTokenPointer();
        int pointerInsideToken = this.stringExpression.getPointerInsideToken();

        if (tokenPointer >= this.stringExpression.getValues().size()) return;
        Object token = this.stringExpression.getValues().get(tokenPointer);

        if (token instanceof CharValue) {
            char c = ((CharValue) token).getChar();
            addInstruction(EInstruction.LIT, 0, c);
        } else if (token instanceof ArrayCharValue) {
            char[] array = ((ArrayCharValue) token).getArray();
            if (pointerInsideToken < array.length) {
                char c = array[pointerInsideToken];
                addInstruction(EInstruction.LIT, 0, c);

                if (pointerInsideToken < array.length - 1) {
                    pointerInsideToken++;
                    this.stringExpression.setPointerInsideToken(pointerInsideToken);
                } else {
                    pointerInsideToken = 0;
                    this.stringExpression.setPointerInsideToken(pointerInsideToken);
                    tokenPointer++;
                    this.stringExpression.setTokenPointer(tokenPointer);
                }
            }
        } else if (token instanceof IdentValue) {
            String name = ((IdentValue) token).getName();
            int address = getAddress(name);
            int level = getLevel(name);

            int length = getLength(name);

            if (pointerInsideToken < length) {
                addInstruction(EInstruction.LOD, level, address + pointerInsideToken);

                if (pointerInsideToken < length - 1) {
                    pointerInsideToken++;
                    this.stringExpression.setPointerInsideToken(pointerInsideToken);
                } else {
                    pointerInsideToken = 0;
                    this.stringExpression.setPointerInsideToken(pointerInsideToken);
                    tokenPointer++;
                    this.stringExpression.setTokenPointer(tokenPointer);
                }
            }
        }
    }

}
