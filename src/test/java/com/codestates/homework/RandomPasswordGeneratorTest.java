package com.codestates.homework;

import com.codestates.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    static String randomPassword;

    @BeforeAll
    public static void createRandomPassword(){
        randomPassword = RandomPasswordGenerator.generate(1,2,3,4);
    }

    @Test
    @DisplayName("실습2-1: 생성된 패스워드의 길이가 입력한 파라미터 숫자의 합과 일치")
    public void sameLength(){
        int expected = 10;
        int actual = randomPassword.length();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습2-2: 대문자 개수 일치")
    public void sameNumberOfUpperCaseLetters(){
        int expected = 1;
        int actual = 0;

        for(char o : randomPassword.toCharArray()){
            if(o>=65&&o<=90) actual++;
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습2-3: 소문자 개수 일치")
    public void sameNumberOfLowerCaseLetters(){
        int expected = 2;
        int actual = 0;

        for(char o : randomPassword.toCharArray()){
            if(o>=97&&o<=122) actual++;
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습2-4: 숫자 개수 일치")
    public void sameNumberOfNumeric(){
        int expected = 3;
        int actual = 0;

        for(char o : randomPassword.toCharArray()){
            if(o>=48&&o<=57) actual++;
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습2-5: 특수문자 개수 일치")
    public void sameNumberOfSpecialChars(){
        int expected = 4;
        int actual = 0;

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(randomPassword);
        while (matcher.find()) {
            actual++;
        }

        assertEquals(expected, actual);
    }
}
