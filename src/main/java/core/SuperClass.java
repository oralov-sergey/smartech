package core;

import io.qameta.allure.Attachment;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AvtodispetcherPage;
import pageObject.YandexResultsPage;
import pageObject.YandexSearchFieldPage;


public class SuperClass {
    private static final int TIME_OUT_IN_SECONDS = 10;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public YandexSearchFieldPage yandexSearchFieldPage;
    public YandexResultsPage yandexResultsPage;
    public AvtodispetcherPage avtodispetcherPage;
    public RegexParser regexParser;
    public ActionsOnThePage actionsOnThePage;
    public Comparison comparison;

    @Before
    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 900));
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        this.yandexSearchFieldPage = new YandexSearchFieldPage();
        this.yandexResultsPage = new YandexResultsPage();
        this.avtodispetcherPage = new AvtodispetcherPage();
        this.actionsOnThePage = new ActionsOnThePage();
        this.comparison = new Comparison();
    }

    @Rule
    public TestWatcher afterRule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

        @Override
        protected void finished(Description desc) {
            driver.quit();
        }
    };
}
