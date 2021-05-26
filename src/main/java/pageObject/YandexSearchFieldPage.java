package pageObject;


import core.SuperClass;
import io.qameta.allure.Step;

public class YandexSearchFieldPage extends SuperClass {

    public static final String URL = "https://yandex.ru/";
    public static final String SEARCH_BAR_XPATH = "//input[@aria-label='Запрос']";
    public static final String SEARCH_BUTTON = "//button[contains(.,'Найти')]";
    public static final String TEXT_FOR_SEARCHING = "расчет расстояний между городами"; // реализовать иначе





    @Step("Get Yandex")
    public void getYandex(){
        actionsOnThePage.getBrowser(URL);
    }

    @Step("Write the request and choose")
    public void writeTextAndClick(){
        actionsOnThePage.waitElementAndSendKeys(SEARCH_BAR_XPATH,TEXT_FOR_SEARCHING);
        actionsOnThePage.waitElementAndClick(SEARCH_BUTTON);
    }





    /*@Step("Compare expected URL and actual URL")
    public void compareSiteAdresses(){
        comparison.equalsTwoString("https://www."+REQUIRED_SITE+"/distance/",actionsOnThePage.getUrl());
    }
        как теперь записать этот степ?
    */


}
