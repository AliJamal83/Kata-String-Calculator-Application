package com.alialwasseti.katastringcalculator.kata;

import com.alialwasseti.katastringcalculator.kata.exceptionhandling.NegativeNumbersException;
import com.alialwasseti.katastringcalculator.kata.exceptionhandling.ValidatorException;

import java.util.LinkedList;
import java.util.List;

public class NegativeNumberSearcher implements ForbiddenNumberSearcher {

    @Override
    public void validate(final List<Integer> numbers) throws ValidatorException {
        List<Integer> negativeNumbers = getNegativeNumbers(numbers);
        if (negativeNumbers.size() > 0) {
            throw new NegativeNumbersException(negativeNumbers);
        }
    }

    private List<Integer> getNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = new LinkedList<Integer>();
        for (Integer num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            }
        }
        return negativeNumbers;
    }
}
