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

    public ConditionGenerator(Condition condition) {
        this.condition = condition;
    }

    public void generate() {
        // bool_exp / 2x num exp / 2x exp

        if (this.condition.getBoolExpression() != null) {
            BoolExpression boolExpression = this.condition.getBoolExpression();
            new BoolExpressionGenerator(boolExpression).generate();
        } else if (this.condition.getLeftExpression() != null && this.condition.getRightExpression() != null) {
            Expression left = this.condition.getLeftExpression();
            new ExpressionGenerator(left).generate();
            Expression right = this.condition.getRightExpression();
            new ExpressionGenerator(right).generate();

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
            new ExpressionGenerator(left).generate();
            NumberExpression right = this.condition.getRightNumberExpression();
            new ExpressionGenerator(right).generate();

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

}
