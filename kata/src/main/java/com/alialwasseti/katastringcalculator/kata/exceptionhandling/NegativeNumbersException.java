package com.alialwasseti.katastringcalculator.kata.exceptionhandling;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class NegativeNumbersException extends ValidatorException {
    private static final String EXCEPTION_NAME = "NegativeNumbersNotSupportedException";
    private List<Integer> negativeNumbers;

    public static String getExceptionName() {
        return EXCEPTION_NAME;
    }

    @Override
    public String getMessage() {
        return EXCEPTION_NAME + negativeNumbers.toString();
    }

}


