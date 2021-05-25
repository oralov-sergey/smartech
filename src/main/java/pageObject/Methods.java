package pageObject;

import core.SuperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Methods extends SuperClass {

    public void getBrowser(String url){
        driver.get(url);
    }

    public void waitElementAndClick(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
    public void waitElementAndClickByText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text))).click();
    }


    public void waitElementAndSendKeys(String xpath, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(text); // реализовать иначе
    }

    public void equalsTwoString(String expected, String actual) {
        assertEquals("Error object not equals", expected, actual);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getText(String xpath){
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public void switchToWindowPopUp(int numberOfWindow) {

        Set<String> abc = driver.getWindowHandles();
        List<String> windowStrings = new ArrayList<>(abc);
        driver.switchTo().window(windowStrings.get(numberOfWindow));
    }

    public void wait30Seconds(){
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
