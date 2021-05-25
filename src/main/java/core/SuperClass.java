package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AvtodispetcherPage;
import pageObject.YandexPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SuperClass {
    private static final int TIME_OUT_IN_SECONDS = 10;
    public static WebDriver driver; // можно делать public?
    public static WebDriverWait wait; // можно делать public?
    public YandexPage yandexPage;
    public AvtodispetcherPage avtodispetcherPage;



    @Before
    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        this.yandexPage = new YandexPage();
        this.avtodispetcherPage = new AvtodispetcherPage();
    }


    @After
    public void quiteDriver() {
        driver.quit();
    }
}
