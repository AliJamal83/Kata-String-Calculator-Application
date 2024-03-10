package com.alialwasseti.katastringcalculator.kata;

import com.alialwasseti.katastringcalculator.kata.exceptionhandling.ValidatorException;

import java.util.List;

interface ForbiddenNumberSearcher {
    void validate(List<Integer> numbers) throws ValidatorException;
}
