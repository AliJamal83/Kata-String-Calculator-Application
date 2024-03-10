package com.alialwasseti.katastringcalculator.kata;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumberValidatorTest {
    private NumberValidator numberValidator;

    @Before
    public void setUp() {
        initializeNumberValidator();
    }

    @Test
    public void shouldNotRemoveNumber() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4);
        List<Integer> expected = numberValidator.validateNumbers(actual);

        assertEquals(actual, expected);
    }

    @Test
    public void shouldRemoveNumberTowAndNumberFour() {
        numberValidator = new NumberValidator(Arrays.asList(
                number -> !number.equals(2),
                number -> !number.equals(4)
        ));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> expected = Arrays.asList(1, 3);
        List<Integer> actual = numberValidator.validateNumbers(numbers);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllNumbers() {
        numberValidator = new NumberValidator(List.of(number -> false));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> expectedResult = List.of();
        List<Integer> actual = numberValidator.validateNumbers(numbers);
        assertEquals(expectedResult, actual);
    }

    private void initializeNumberValidator() {
        numberValidator = new NumberValidator(
                List.of(number -> true));
    }
}
