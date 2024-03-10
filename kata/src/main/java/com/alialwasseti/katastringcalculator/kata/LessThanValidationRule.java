package com.alialwasseti.katastringcalculator.kata;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LessThanValidationRule implements ValidationRule{

    private final int value;

    @Override
    public boolean isValid(Integer number) {
        return number < value;
    }
}
