package pageObject;

import core.SuperClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.awt.image.BufferedImage;

public class AvtodispetcherPage extends SuperClass {

    public static final String VELIKY_NOVGOROD = "Великий Новгород";
    public static final String TULA = "Тула";
    public static final String SAINT_PETERSBURG = "Санкт-Петербург";
    public static final int TIME_OUT = 30;
    public static final String ALL_TEXT_FROM_RESULT_FORM = "//*[@id=\"summaryContainer\"]/form";
    public static final String DISTANCE_XPATH = "//span[@id='totalDistance']";
    public static final String CHANGE_DIRECTION_BUTTON_XPATH = "//span[contains(.,'Настроить маршрут')]";
    public static final String THROUGH_THE_CITY_FIELD_XPATH = "(//input[@type='text'])[5]";
    public static final String MAP_LOCATOR = "distanceCalculatorMap";
    public static final String DIRECTION_FIELD_XPATH = "//input[contains(@name,'%s')]";
    public static final String FUEL_CONSUMPTION_FIELD_XPATH = "(//input[@min='1'])[8]";
    public static final String FUEL_PRICE_FIELD_XPATH = "(//input[@min='1'])[9]";
    public static final String CALCULATE_BUTTON_XPATH = "(//input[@type='submit'])[3]";

    public String getDataFromForm() {
        return driver.findElement(By.xpath(ALL_TEXT_FROM_RESULT_FORM)).getText();
    }

    @Step("Change direction")
    public void changeDirection() {
        actionsOnThePage.waitElementAndClick(CHANGE_DIRECTION_BUTTON_XPATH);
        actionsOnThePage.waitElementAndSendKeys(THROUGH_THE_CITY_FIELD_XPATH, VELIKY_NOVGOROD);
        actionsOnThePage.staticWait(TIME_OUT);
        actionsOnThePage.scrollThePage(CHANGE_DIRECTION_BUTTON_XPATH);
        actionsOnThePage.waitElementAndClick(CALCULATE_BUTTON_XPATH);
    }

    @Step("Take screenshot")
    public BufferedImage takeScreenshot() {
        return actionsOnThePage.getScreenshotOfElement(By.id(MAP_LOCATOR)).getImage();
    }

    @Step("Fill in the input fields")
    public void fillInTheInputFields() {
        actionsOnThePage.waitElementAndSendKeys(String.format(DIRECTION_FIELD_XPATH, "from"), TULA);
        actionsOnThePage.waitElementAndSendKeys(String.format(DIRECTION_FIELD_XPATH, "to"), SAINT_PETERSBURG);
        actionsOnThePage.waitElementAndSendKeys(FUEL_CONSUMPTION_FIELD_XPATH, "9");
        actionsOnThePage.waitElementAndSendKeys(FUEL_PRICE_FIELD_XPATH, "46");
    }

    @Step("Press calculate button")
    public void calculateTheWay() {
        actionsOnThePage.scrollThePage(CALCULATE_BUTTON_XPATH);
        actionsOnThePage.waitElementAndClick(CALCULATE_BUTTON_XPATH);
    }
}
