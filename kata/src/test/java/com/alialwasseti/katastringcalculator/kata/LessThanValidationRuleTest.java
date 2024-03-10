package com.alialwasseti.katastringcalculator.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LessThanValidationRuleTest {

    private static final int TOP_VALUE = 100;
    private static final int LESS_THAN_TOP_VALUE = 15;
    private LessThanValidationRule rule;

    @Before
    public void setUp() {
        initializeRule();
    }

    @Test
    public void shouldValidateANumberLessThanTopValue() {
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    @Test
    public void shouldNotValidateANumberEqualsToTheTopValue() {
        assertFalse(rule.isValid(TOP_VALUE));
    }

    @Test
    public void shouldNotValidateANumberGratherThanTopValue() {
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    private void initializeRule() {
        rule = new LessThanValidationRule(TOP_VALUE);
    }
}
