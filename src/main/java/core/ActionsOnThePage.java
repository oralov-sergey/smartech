package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionsOnThePage extends SuperClass {

    // могут все методы быть static?

    public static void getBrowser(String url){
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



    public static String getUrl(){
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

    public static void staticWait(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollThePage(String pixels) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, "+pixels+");");

    }

}
