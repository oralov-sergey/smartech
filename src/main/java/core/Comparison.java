package core;

import io.qameta.allure.Step;

import static org.junit.Assert.assertEquals;

public class Comparison extends SuperClass {

    @Step("Compare expected {expected} to actual {actual}")
    public static void equalsTwoStrings(String expected, String actual, String message) {
        assertEquals(message, expected, actual);
    }

   }
