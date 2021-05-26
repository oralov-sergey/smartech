package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AvtodispetcherCalculationPage;
import pageObject.AvtodispetcherRequestPage;
import pageObject.YandexResultsPage;
import pageObject.YandexSearchFieldPage;


public class SuperClass {
    private static final int TIME_OUT_IN_SECONDS = 10;
    protected static WebDriver driver; // можно сделать статичным?
    protected static WebDriverWait wait; // можно сделать статичным?
    public YandexSearchFieldPage yandexSearchFieldPage;
    public YandexResultsPage yandexResultsPage;
    public AvtodispetcherRequestPage avtodispetcherRequestPage;
    public AvtodispetcherCalculationPage avtodispetcherCalculationPage;
    public RegexParser regexParser;
    public ActionsOnThePage actionsOnThePage;
    public Comparison comparison;




    @Before
    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        this.yandexSearchFieldPage = new YandexSearchFieldPage();
        this.yandexResultsPage = new YandexResultsPage();
        this.avtodispetcherRequestPage = new AvtodispetcherRequestPage();
        this.avtodispetcherCalculationPage = new AvtodispetcherCalculationPage();
        this.actionsOnThePage = new ActionsOnThePage();
        this.comparison = new Comparison();


    }



    @After
    public void quiteDriver() {
        driver.quit();
    }
}
