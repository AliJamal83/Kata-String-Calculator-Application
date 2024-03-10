package com.alialwasseti.katastringcalculator.kata;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {

    private static final String ONE_DIGIT_OR_MORE_REG_EX = "-?\\d+";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(ONE_DIGIT_OR_MORE_REG_EX);

    public List<Integer> extractNumbers(final String stringToAnalyze) {
        List<Integer> numbers = new LinkedList<>();
        if (stringToAnalyze != null && !stringToAnalyze.isEmpty()) {
            Matcher matcher = NUMBER_PATTERN.matcher(stringToAnalyze);
            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                numbers.add(number);
            }
        }
        return numbers;
    }

}
