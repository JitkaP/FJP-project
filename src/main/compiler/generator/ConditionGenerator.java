package main.compiler.generator;

import main.compiler.entity.Condition;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.enums.EConditionOperator;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EInstructionOpr;
import main.compiler.generator.expression.BoolExpressionGenerator;
import main.compiler.generator.expression.ExpressionGenerator;

public class ConditionGenerator extends Generator {

    private Condition condition;
    private boolean boolContinue = false;

    public ConditionGenerator(Condition condition) {
        this.condition = condition;
    }

    public void generate() {
        generate(0);
    }

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
            NumberExpression left = this.condition.getLeftNumberExpression();
            new ExpressionGenerator(left).generate(index);
            NumberExpression right = this.condition.getRightNumberExpression();
            new ExpressionGenerator(right).generate(index);

            EConditionOperator op = this.condition.getOperator();
            switch (op) {
                case LESS:
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.LESS.getValue());
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
