package com.alialwasseti.katastringcalculator.kata;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class NumberValidator {

    private Collection<ValidationRule> rules;

    public List<Integer> validateNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (isValid(number)) {
                result.add(number);
            }
        }
        return result;
    }

    private boolean isValid(Integer sum) {
        return rules.stream()
                .allMatch(rule -> rule.isValid(sum));
    }
}
