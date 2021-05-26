package core;

import static org.junit.Assert.assertEquals;

public class Comparison extends SuperClass {

    public static void equalsDistance(String expected, String actual) {
        assertEquals("The distances are not the same", expected, actual);
    }
    public static void equalsCost(String expected, String actual) {
        assertEquals("The cost is not the same", expected, actual);
    }
    public static void equalsCiteUrls(String expected, String actual) {
        assertEquals("The Urls are not the same", expected, actual);
    }
}
