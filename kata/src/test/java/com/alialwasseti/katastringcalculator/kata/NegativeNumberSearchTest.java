package com.alialwasseti.katastringcalculator.kata;

import com.alialwasseti.katastringcalculator.kata.exceptionhandling.NegativeNumbersException;
import com.alialwasseti.katastringcalculator.kata.exceptionhandling.ValidatorException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class NegativeNumberSearchTest {

    private static final int POSITIVE_VALUE = 100;
    private static final int NEGATIVE_VALUE = -100;
    private static final int ZERO_VALUE = 0;
    private NegativeNumberSearcher searcher;

    @Before
    public void setup() {
        initializeRule();
    }

    @Test
    public void shouldValidatePositiveNumbers() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(POSITIVE_VALUE);
        searcher.validate(positiveNumbers);
    }

    @Test
    public void shouldValidateZeroValue() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(ZERO_VALUE);
        searcher.validate(positiveNumbers);
    }

    @Test(expected = NegativeNumbersException.class)
    public void shouldValidateNegativeValue() throws ValidatorException {
        List<Integer> negativeNumbers = generateIntegerList(NEGATIVE_VALUE);
        searcher.validate(negativeNumbers);
    }

    private List<Integer> generateIntegerList(int positiveValue) {
        List<Integer> positiveValues = new LinkedList<>();
        positiveValues.add(positiveValue);
        return positiveValues;
    }

    private void initializeRule() {
        searcher = new NegativeNumberSearcher();
    }

}
