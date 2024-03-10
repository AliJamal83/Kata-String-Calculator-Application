package com.alialwasseti.katastringcalculator.kata;

import com.alialwasseti.katastringcalculator.kata.exceptionhandling.NegativeNumbersException;
import com.alialwasseti.katastringcalculator.kata.exceptionhandling.ValidatorException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private static final String EMPTY_SET_OF_NUMBERS = "";
    private static final String ONE_NUMBER_ONE_DIGIT_STRING = "1";
    private static final String ONE_NUMBER_STRING = "55";
    private static final String NUMBERS_STRING_SUM_TEN = "4,3,2,1";
    private static final String NUMBERS_STRING_SUM_SIX_SEPARATOR_NEW_LINE = "1\n2,3";
    private static final String NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS = "//;\n1;2p4";
    private static final String NUMBERS_STRING_WITH_NEGATIVE_VALUES = "//;\n1;2p-4";
    private static final String NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS_CONSECUTIVES = "[*][%]\\n1*2%4";

    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZero_whenArgumentIsEmpty() throws ValidatorException {
        int result = calculator.add(EMPTY_SET_OF_NUMBERS);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnSameValue_whenArgumentContainsOnlyOneNumberWithOneDigit() throws ValidatorException {
        int result = calculator.add(ONE_NUMBER_ONE_DIGIT_STRING);
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnSameValue_whenArgumentContainsOnlyNumberWithMoreThanOneDigit() throws ValidatorException {
        int result = calculator.add(ONE_NUMBER_STRING);
        assertEquals(55, result);
    }

    @Test
    public void shouldReturnTheSumOfAnUnknownAmountOfNumbers() throws ValidatorException {
        int result = calculator.add(NUMBERS_STRING_SUM_TEN);
        assertEquals(10, result);
    }

    @Test
    public void shouldReturnTheSumOfAnUnknownAmountOfNumbersSeparatedWithNewLineCharacters() throws ValidatorException {
        int result = calculator.add(NUMBERS_STRING_SUM_SIX_SEPARATOR_NEW_LINE);
        assertEquals(6, result);
    }

    @Test
    public void shouldReturnTheSumOfAnUnknownAmountOfNumbersSeparatedWithDifferentDelimiters() throws ValidatorException {
        int result = calculator.add(NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS);
        assertEquals(7, result);
    }

    @Test(expected = NegativeNumbersException.class)
    public void shouldThrowNegativeNumbersNotSupportedException() throws ValidatorException {
        calculator.add(NUMBERS_STRING_WITH_NEGATIVE_VALUES);
    }

    @Test
    public void shouldAllowDifferentDelimitersWithMoreThanOneCharAndMoreThanOneConsecutive() throws ValidatorException {
        int result = calculator.add(NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS_CONSECUTIVES);
        assertEquals(7, result);
    }
}
