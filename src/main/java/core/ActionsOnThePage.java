package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionsOnThePage extends SuperClass {

    public static void getBrowser(String url) {
        driver.get(url);
    }

    public static void waitElementAndClick(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    public static void waitElementAndClickByText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text))).click();
    }

    public static void waitElementAndSendKeys(String xpath, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(text);
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }

    public static String getText(String xpath){
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public static void switchToWindowPopUp(int numberOfWindow) {

        Set<String> abc = driver.getWindowHandles();
        List<String> windowStrings = new ArrayList<>(abc);
        driver.switchTo().window(windowStrings.get(numberOfWindow));
    }

    public static void staticWait(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollThePage(String selector) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(selector));
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Can be used for creating screenshots for comparing*
    public static void saveBufferedImageAsFile(BufferedImage actualImage, String name) {
        File outputfile = new File("src/main/resources/screenshots/" + name + ".png");
        try {
            ImageIO.write(actualImage, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Screenshot getScreenshotOfElement(By locator) {
        WebElement myWebElement = driver.findElement(locator);
        return new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver, myWebElement);
    }
}
