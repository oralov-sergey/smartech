package pageObject;

import core.SuperClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AvtodispetcherRequestPage extends SuperClass {

    public static final String DIRECTION_FIELD_XPATH = "//input[contains(@name,'%s')]";
    public static final String TULA= "Тула";
    public static final String SAINT_PETERSBURG= "Санкт-Петербург";
    public static final String FUEL_CONSUMPTION_FIELD_XPATH = "(//input[@min='1'])[8]";
    public static final String FUEL_PRICE_FIELD_XPATH = "(//input[@min='1'])[9]";
    public static final String CALCULATE_Button_XPATH = "(//input[@type='submit'])[3]";





    @Step("Fill in the input fields")
    public void fillInTheInputFields(){
        actionsOnThePage.waitElementAndSendKeys(String.format(DIRECTION_FIELD_XPATH,"from"),TULA);
        actionsOnThePage.waitElementAndSendKeys(String.format(DIRECTION_FIELD_XPATH,"to"),SAINT_PETERSBURG);
        actionsOnThePage.waitElementAndSendKeys(FUEL_CONSUMPTION_FIELD_XPATH,"9");
        actionsOnThePage.waitElementAndSendKeys(FUEL_PRICE_FIELD_XPATH,"46");
    }

    @Step("Press calculate button")
    public void calculateTheWay(){
        actionsOnThePage.waitElementAndClick(CALCULATE_Button_XPATH);
    }





}
