package pageObject;

import core.SuperClass;
import io.qameta.allure.Step;

public class AvtodispetcherPage extends Methods {

    public static final String DIRECTION_FIELD_XPATH = "//input[contains(@name,'%s')]";
    public static final String FUEL_CONSUMPTION_FIELD_XPATH = "(//input[@min='1'])[8]";
    public static final String FUEL_PRICE_FIELD_XPATH = "(//input[@min='1'])[9]";
    public static final String THROUGH_THE_CITY_FIELD_XPATH = "(//input[@type='text'])[5]";
    public static final String CALCULATE_Button_XPATH = "(//input[@type='submit'])[3]";
    public static final String DISTANCE_XPATH = "//span[@id='totalDistance']";
    public static final String EXPECTED_DISTANCE_BEFORE_CHANGES = "897";
    public static final String EXPECTED_DISTANCE_AFTER_CHANGES = "966";
    public static final String CHANGE_DIRECTION_BUTTON_XPATH = "//span[contains(.,'Настроить маршрут')]";
  /*  public static final String TOTAL_PRICE_XPATH = "//*[@id=\"summaryContainer\"]/form/p/text()[4]";
    public static final String EXPECTED_TOTAL_PRICE_WITHOUT_CHANGES = "3726";
    public static final String EXPECTED_TOTAL_PRICE_AFTER_CHANGES = "4002";*/
    public static final String CITIES[] = {"Тула", "Санкт-Петербург", "Великий Новгород"};



    @Step("Fill in the input fields")
    public void fillInTheInputFields(){
        waitElementAndSendKeys(String.format(DIRECTION_FIELD_XPATH,"from"),CITIES[0]);
        waitElementAndSendKeys(String.format(DIRECTION_FIELD_XPATH,"to"),CITIES[1]);
        waitElementAndSendKeys(FUEL_CONSUMPTION_FIELD_XPATH,"9");
        waitElementAndSendKeys(FUEL_PRICE_FIELD_XPATH,"46");
    }

    @Step("Press calculate button")
    public void calculateTheWay(){
        waitElementAndClick(CALCULATE_Button_XPATH);
    }

    @Step("Check the result")
    public void checkResults(){
        equalsTwoString(EXPECTED_DISTANCE_BEFORE_CHANGES,getText(DISTANCE_XPATH));
        //equalsTwoString(EXPECTED_TOTAL_PRICE_BEFORE_CHANGES,getText(TOTAL_PRICE_XPATH));
    }

    @Step("Change direction")
    public void changeDirection(){
        waitElementAndClick(CHANGE_DIRECTION_BUTTON_XPATH);
        waitElementAndSendKeys(THROUGH_THE_CITY_FIELD_XPATH,CITIES[2]);
        wait30Seconds();
        waitElementAndClick(CALCULATE_Button_XPATH);
    }

    @Step("Check the results after changes")
    public void checkResultsAfterChanges(){
        equalsTwoString(EXPECTED_DISTANCE_AFTER_CHANGES,getText(DISTANCE_XPATH));
        //equalsTwoString(EXPECTED_TOTAL_PRICE_AFTER_CHANGES,getText(TOTAL_PRICE_XPATH));
    }


}
