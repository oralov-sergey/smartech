package pageObject;

import core.SuperClass;
import io.qameta.allure.Step;

public class YandexResultsPage extends SuperClass {

    public static final String REQUIRED_SITE = "avtodispetcher.ru";

    @Step("Select the desired site")
    public void goToTheWebsite() {
        actionsOnThePage.waitElementAndClickByText(REQUIRED_SITE);
    }

    @Step("Switch to site")
    public void switchToAvtodispetcher() {
        actionsOnThePage.switchToWindowPopUp(1);
    }
}
