package core;

import io.qameta.allure.Step;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Comparison extends SuperClass {

    @Step("Compare expected {expected} to actual {actual}")
    public static void equalsTwoStrings(String expected, String actual, String message) {
        assertEquals(message, expected, actual);
    }

    @Step("Compare expected image {expectedImageName} to actual image {actualImage}")
    public static void compareTwoImages(String expectedImageName, BufferedImage actualImage, String diffImageName) {
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new FileInputStream("src/main/resources/screenshots/" + expectedImageName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int diffNumber = new ImageDiffer().makeDiff(expectedImage, actualImage).getDiffSize();
        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage).withDiffSizeTrigger(50000);
         /*
             ".withDiffSizeTrigger(50000)" I used it because when I checked the test in a day, there was a test failure.
             It happened because of changing that map on the website itself.
         */
        File diffFile = new File("src/main/resources/screenshots/" + diffImageName + ".png");
        if (diff.hasDiff()) {
            try {
                ImageIO.write(diff.getMarkedImage(), "png", diffFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fail("Images not equal");
        }
    }
}