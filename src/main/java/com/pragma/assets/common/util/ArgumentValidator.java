package com.pragma.assets.common.util;

import com.pragma.assets.common.exception.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentValidator {

    private ArgumentValidator() {
    }

    public static void requireNotNull(Object value, String message) {
        if (value == null) {
            System.out.println("a"+value);
            throw new MandatoryValueException(message);
        }
    }

    public static void requireLength(String value, int length, String message) {
        if (value.length() < length) {
            throw new ValueLengthException(message);
        }
    }

    public static <T> void requireNotEmpty(List<T> list, String message) {
        if (list.isEmpty()) {
            throw new MandatoryValueException(message);
        }
    }

    public static void requirePositive(Double value, String message) {
        if (value <= 0) {
            throw new InvalidValueException(message);
        }
    }

    public static void requireEqual(Double value, Double expectedValue, String message) {
        if (!value.equals(expectedValue)) {
            throw new InvalidValueException(message);
        }
    }

    public static void requireMinimumLength(Object value, int minLength, String message) {
        if (value.toString().length() < minLength) {
            throw new ValueLengthException(message);
        }
    }

    public static void requireLess(LocalDateTime initialDate, LocalDateTime finalDate, String message) {
        if (initialDate.toLocalDate().isAfter(finalDate.toLocalDate())) {
            throw new InvalidValueException(message);
        }
    }

    public static void requireLess(Long initialNumber, Long finalNumber, String message) {
        if (initialNumber > finalNumber) {
            throw new InvalidValueException(message);
        }
    }

    public static void requireRegexMatch(String emailAddress, String regex, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);

        if (!matcher.matches()) {
            throw new InvalidValueException(message);
        }
    }

    public static <E extends Enum<E>> E requireValid(String value, Class<E> enumToRetrieve, String message) throws InvalidValueException {
        E obtainedEnum = null;
        if (value != null) {
            Optional<E> optionalResult = Arrays.stream(enumToRetrieve.getEnumConstants())
                    .filter(result -> result.toString().equals(value)).findFirst();

            if (optionalResult.isPresent()) {
                obtainedEnum = optionalResult.get();
            } else {
                throw new InvalidValueException(message);
            }
        }
        return obtainedEnum;
    }

    public static void requireNumeric(String value, String message) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidValueException(message);
        }
    }

    public static void allowedStates(List<String> availableValues, String value, String message) {
        if (!availableValues.contains(value)) {
            throw new InvalidValueException(message);
        }
    }

}
