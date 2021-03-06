package main.compiler.generator;

import main.compiler.entity.Condition;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EConditionOperator;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EInstructionOpr;
import main.compiler.generator.expression.BoolExpressionGenerator;
import main.compiler.generator.expression.ExpressionGenerator;

/**
 * Generator for conditions.
 */
public class ConditionGenerator extends Generator {

    private Condition condition;
    private boolean boolContinue = false;

    public ConditionGenerator(Condition condition) {
        this.condition = condition;
    }

    public void generate() {
        generate(0);
    }

    /**
     * Method for processing and generating instructions of conditions.
     */
    public void generate(int index) {
        // bool_exp / 2x num exp / 2x exp

        if (this.condition.getBoolExpression() != null) {
            BoolExpression boolExpression = this.condition.getBoolExpression();
            new BoolExpressionGenerator(boolExpression).generate(index);
        } else if (this.condition.getLeftExpression() != null && this.condition.getRightExpression() != null) {
            Expression left = this.condition.getLeftExpression();
            ExpressionGenerator leftExpressionGen = new ExpressionGenerator(left);
            leftExpressionGen.generate(index);
            boolean boolLeft = leftExpressionGen.isBoolContinue();

            Expression right = this.condition.getRightExpression();
            ExpressionGenerator rightExpressionGen = new ExpressionGenerator(right);
            rightExpressionGen.generate(index);
            boolean boolRight = rightExpressionGen.isBoolContinue();

            this.boolContinue = boolLeft && boolRight;

            EConditionOperator op = this.condition.getOperator();
            switch (op) {
                case EQ:
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.EQUAL.getValue());
                    break;
                case NOT_EQ:
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.NOT_EQUAL.getValue());
                    break;
            }
        } else if (this.condition.getLeftNumberExpression() != null && this.condition.getRightNumberExpression() != null) {
            Expression leftNumberExpression = this.condition.getLeftNumberExpression();
            ExpressionGenerator leftExpressionGen = new ExpressionGenerator(leftNumberExpression);
            leftExpressionGen.generate(index);
            Value leftValue = leftExpressionGen.getValue();

            Expression rightNumberExpression = this.condition.getRightNumberExpression();
            ExpressionGenerator rightExpressionGen = new ExpressionGenerator(rightNumberExpression);
            rightExpressionGen.generate(index);
            Value rightValue = rightExpressionGen.getValue();

            int left = -1, right = -1;
            if (leftValue instanceof IntValue) {
                left = ((IntValue) leftValue).getInteger();
            } else if (leftValue instanceof IdentValue) {
                left = ((IntValue) leftValue.getValue()).getInteger();
            }

            if (rightValue instanceof IntValue) {
                right = ((IntValue) rightValue).getInteger();
            } else if (rightValue instanceof IdentValue) {
                right = ((IntValue) rightValue.getValue()).getInteger();
            }

            EConditionOperator op = this.condition.getOperator();
            switch (op) {
                case LESS:
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.LESS.getValue());
                    this.boolContinue = (left < right - 1);
                    break;
                case LESS_EQ:
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.LESS_EQUAL.getValue());
                    break;
                case GREATER:
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.GREATER.getValue());
                    break;
                case GREATER_EQ:
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.GREATER_EQUAL.getValue());
                    break;
            }
        }

    }

    public boolean isBoolContinue() {
        return boolContinue;
    }
}
