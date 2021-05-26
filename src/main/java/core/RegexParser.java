package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {
    public static String getFuelPriceFromText(String text) {
        String fuelPrice = "";
        Pattern pattern = Pattern.compile("(?<=руб./л. = )(\\d*)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            fuelPrice = matcher.group(0);
        }
        return fuelPrice;
    }
}
