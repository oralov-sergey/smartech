package pagePbject;

import core.SuperClass;

public class YandexPage extends SuperClass {

    public static final String URL = "https://yandex.ru/";
    public static final String SEARCH_BAR_XPATH = "//input[@aria-label='Запрос']";
    public static final String SEARCH_BUTTON = "//button[contains(.,'Найти')]";
    public static final String TEXT_FOR_SEARCHING = "расчет расстояний между городами";
    public static final String REQUIRED_SITE = "avtodispetcher.ru";



    public void getYandex(){
        getBrowser(URL);
    }

    public void writeTextAndClick(){
        waitElementAndSendKeys(SEARCH_BAR_XPATH,TEXT_FOR_SEARCHING);
        waitElementAndClick(SEARCH_BUTTON);

    }

    public void goToTheWebsite(){
        waitElementAndClickByText(REQUIRED_SITE);


    }

}
