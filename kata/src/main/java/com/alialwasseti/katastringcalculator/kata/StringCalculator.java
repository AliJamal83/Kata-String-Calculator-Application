package com.alialwasseti.katastringcalculator.kata;

import com.alialwasseti.katastringcalculator.kata.exceptionhandling.ValidatorException;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class StringCalculator {

    private static final int VALIDATION_TOP_NUMBER = 1000;


    private NumberExtractor numberExtractor;
    private ForbiddenNumberSearcher forbiddenNumberSearcher;
    private NumberValidator numberValidator;

    public StringCalculator() {
        initializeNumberExtractor();
        initializeNegativeNumberValidator();
        initializeNumbersValidator();
    }

    private void initializeNumbersValidator() {
        ValidationRule rule = new LessThanValidationRule(VALIDATION_TOP_NUMBER);
        Collection<ValidationRule> rules = new ArrayList<ValidationRule>();
        rules.add(rule);
        this.numberValidator = new NumberValidator(rules);

    }

    private void initializeNumberExtractor() {
        this.numberExtractor = new NumberExtractor();
    }

    private void initializeNegativeNumberValidator() {
        this.forbiddenNumberSearcher = new NegativeNumberSearcher();
    }

    public int add(final String numbers) throws ValidatorException {
        List<Integer> extractedNumbers = extractNumbers(numbers);
        checkNegativeNumbers(extractedNumbers);
        return sumOfValidNumbers(extractedNumbers);
    }

    private List<Integer> extractNumbers(final String numbers) {
        return numberExtractor.extractNumbers(numbers);
    }

    private int sumOfValidNumbers(List<Integer> numbersList) {
        return numbersList.stream().mapToInt(Integer::intValue).sum();
    }

    private void checkNegativeNumbers(final List<Integer> numbersList) throws ValidatorException {
        forbiddenNumberSearcher.validate(numbersList);
    }
}
