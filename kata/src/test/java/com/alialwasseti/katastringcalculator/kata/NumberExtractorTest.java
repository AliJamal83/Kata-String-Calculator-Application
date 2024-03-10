package com.alialwasseti.katastringcalculator.kata;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumberExtractorTest {

    private static final String NO_NUMBERS = "poiu";
    private static final String NUMBERS_WITH_DIFFERENT_DELIMITERS = "\n|·1,2,3,jmnhbgv4%5&6";
    private NumberExtractor numberExtractor;

    @Before
    public void setUp() {
        initializeNumberExtractor();
    }

    @Test
    public void shouldReturnAnEmptyCollectionIfTheParamIsNull() {
        List<Integer> result = numberExtractor.extractNumbers(null);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void shouldReturnAnEmptyCollectionIfTheParamIsEmpty() {
        List<Integer> result = numberExtractor.extractNumbers("");
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void shouldReturnAnEmptyCollectionOfNumbersIfThereIsNoNumbersInsideTheString() {
        List<Integer> result = numberExtractor.extractNumbers(NO_NUMBERS);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void shouldReturnACollectionWithTheNumbersExtracted() {
        List<Integer> result = numberExtractor.extractNumbers(NUMBERS_WITH_DIFFERENT_DELIMITERS);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }

    private void initializeNumberExtractor() {
        numberExtractor = new NumberExtractor();
    }
}
