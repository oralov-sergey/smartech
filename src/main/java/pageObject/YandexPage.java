package pageObject;

import core.SuperClass;
import io.qameta.allure.Step;

public class YandexPage extends Methods {

    public static final String URL = "https://yandex.ru/";
    public static final String SEARCH_BAR_XPATH = "//input[@aria-label='Запрос']";
    public static final String SEARCH_BUTTON = "//button[contains(.,'Найти')]";
    public static final String TEXT_FOR_SEARCHING = "расчет расстояний между городами"; // реализовать иначе
    public static final String REQUIRED_SITE = "avtodispetcher.ru";




    @Step("Get Yandex")
    public void getYandex(){
        getBrowser(URL);
    }

    @Step("Write the request")
    public void writeTextAndClick(){
        waitElementAndSendKeys(SEARCH_BAR_XPATH,TEXT_FOR_SEARCHING); // реализовать иначе
        waitElementAndClick(SEARCH_BUTTON);
    }

    @Step("Select the desired site")
    public void goToTheWebsite(){
        waitElementAndClickByText(REQUIRED_SITE);
    }

    @Step("Switch to site")
    public void switchToAvtodispetcher(){
        switchToWindowPopUp(1);
    }

    @Step("Compare expected URL and actual URL")
    public void compareSiteAdresses(){
        equalsTwoString("https://www."+REQUIRED_SITE+"/distance/",getUrl());
    }




}
