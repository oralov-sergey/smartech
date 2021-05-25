package tests;

import core.SuperClass;
import org.junit.Test;

public class ScriptTest extends SuperClass {

    @Test
    public void script(){

        yandexPage.getYandex();
        yandexPage.writeTextAndClick();
        yandexPage.goToTheWebsite();
        yandexPage.switchToAvtodispetcher();
        yandexPage.compareSiteAdresses();
        avtodispetcherPage.fillInTheInputFields();
        avtodispetcherPage.calculateTheWay();
        avtodispetcherPage.checkResults();
        avtodispetcherPage.changeDirection();
        avtodispetcherPage.checkResultsAfterChanges();


    }

}
