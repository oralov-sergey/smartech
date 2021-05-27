package pageObject;

import core.SuperClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AvtodispetcherCalculationPage extends SuperClass {

    public static final String VELIKY_NOVGOROD= "Великий Новгород";
    public static final String CHANGE_DIRECTION_BUTTON_XPATH = "//span[contains(.,'Настроить маршрут')]";
    public static final String THROUGH_THE_CITY_FIELD_XPATH = "(//input[@type='text'])[5]";
    public static final String DISTANCE_XPATH = "//span[@id='totalDistance']";
    public static final String ALL_TEXT_FROM_RESULT_FORM = "//*[@id=\"summaryContainer\"]/form";
    public static final int TIME_OUT = 30;
    public static final String PIXELS = "500";


    public String getDataFromForm(){
        return driver.findElement(By.xpath(ALL_TEXT_FROM_RESULT_FORM)).getText();
    }

    @Step("Change direction")
    public void changeDirection(){
        actionsOnThePage.waitElementAndClick(CHANGE_DIRECTION_BUTTON_XPATH);
        actionsOnThePage.waitElementAndSendKeys(THROUGH_THE_CITY_FIELD_XPATH,VELIKY_NOVGOROD);
        actionsOnThePage.staticWait(TIME_OUT);
        actionsOnThePage.scrollThePage(PIXELS);
        actionsOnThePage.waitElementAndClick(avtodispetcherRequestPage.CALCULATE_Button_XPATH);
    }

}
