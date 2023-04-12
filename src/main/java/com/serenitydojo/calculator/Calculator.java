package com.serenitydojo.calculator;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private List<String> authorisedOperator = Arrays.asList("+","-","*");

    public int evaluate(String expression) {
        int result, operand1, operand2;
        String operator;

        List<String> items = Arrays.stream(expression.split("\\s+"))
                .collect(Collectors.toList());

        result = getOperand(items.get(0));
        for (int i = 1; i < items.size(); i = i + 2) {
            operand1 = result;
            operator = getOperator(items.get(i));
            operand2 = getOperand(items.get(i + 1));
            result = getResult(operand1, operand2, operator);
        }
        return result;
    }

    private int getOperand(@NotNull String item) {
        try {
            if(item.isEmpty()){return 0;}

            return Integer.parseInt(item);
        }catch(NumberFormatException wrongOperand){
            throw new IllegalOperandFormatException("The operand " + item + " should be an int");
        }
    }

    private String getOperator(String item) {
        if (!authorisedOperator.contains(item)) {
            throw new IllegalMathsOperatorException("The operator " + item + " is not allowed");
        };

        return item;
    }

    private int getResult(int operand1, int operand2, String operator){
        int result;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            default:
                result = 0;
        }

        return result;
    }
}
