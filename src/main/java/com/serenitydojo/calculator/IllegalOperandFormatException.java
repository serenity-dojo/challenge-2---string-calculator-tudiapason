package com.serenitydojo.calculator;

public class IllegalOperandFormatException extends RuntimeException{

    public IllegalOperandFormatException(String message){
        super(message);
    }

}
