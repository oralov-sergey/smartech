package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagePbject.YandexPage;

public class SuperClass {
    private static final int TIME_OUT_IN_SECONDS = 10;
    private static WebDriver driver;
    private static WebDriverWait wait;
    public YandexPage yandexPage;


    @Before
    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        this.yandexPage = new YandexPage();

    }

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(text);
    }


    @After
    public void quiteDriver() {
        driver.quit();
    }
}
