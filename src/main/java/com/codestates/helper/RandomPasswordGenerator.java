package com.codestates.helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RandomPasswordGenerator {
    public static String generate(int numberOfUpperCaseLetters, // 생성될 패스워드 문자열에서 알파벳 대문자의 개수
                                  int numberOfLowerCaseLetters, // 생성될 패스워드 문자열에서 알파벳 소문자의 개수
                                  int numberOfNumeric, // 생성될 패스워드 문자열에서 0 이상인 숫자의 개수
                                  int numberOfSpecialChars) { // 생성될 패스워드 문자열에서 특수문자의 개수
        String upperCaseLetters = RandomStringUtils.random(numberOfUpperCaseLetters, 65, 90, true, false);
        String lowerCaseLetters = RandomStringUtils.random(numberOfLowerCaseLetters, 97, 122, true, false);
        String numbers = RandomStringUtils.randomNumeric(numberOfNumeric);
        String specialChars = RandomStringUtils.random(numberOfSpecialChars, 33, 47, false, false);

        String combinedLetters = combineLetters(upperCaseLetters, lowerCaseLetters, numbers, specialChars);
        List<Character> shuffledLetters = shuffleLetters(combinedLetters);
        return shuffledLetters.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static List<Character> shuffleLetters(String combinedLetters) {
        List<Character> shuffledLetters = combinedLetters.chars().mapToObj(c -> (char) c).collect(toList());
        Collections.shuffle(shuffledLetters);
        return shuffledLetters;
    }

    private static String combineLetters(String upperCaseLetters, String lowerCaseLetters, String numbers, String specialChars) {
        return upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChars);
    }
}
