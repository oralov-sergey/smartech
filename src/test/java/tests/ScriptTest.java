package tests;

import core.SuperClass;
import org.junit.Test;

public class ScriptTest extends SuperClass {

    public static final String EXPECTED_SITE = "https://www.avtodispetcher.ru/distance/";
    public static final String EXPECTED_DISTANCE_BEFORE_CHANGES = "897";
    public static final String EXPECTED_TOTAL_PRICE_BEFORE_CHANGES = "3726";
    public static final String EXPECTED_DISTANCE_AFTER_CHANGES = "966";
    public static final String EXPECTED_TOTAL_PRICE_AFTER_CHANGES = "4002";


    @Test
    public void script(){


        yandexSearchFieldPage.getYandex();
        yandexSearchFieldPage.writeTextAndClick();
        yandexResultsPage.goToTheWebsite();
        yandexResultsPage.switchToAvtodispetcher();
        comparison.equalsCiteUrls(EXPECTED_SITE,actionsOnThePage.getUrl());
        avtodispetcherRequestPage.fillInTheInputFields();
        avtodispetcherRequestPage.calculateTheWay();
        comparison.equalsDistance(EXPECTED_DISTANCE_BEFORE_CHANGES,actionsOnThePage.getText(avtodispetcherCalculationPage.DISTANCE_XPATH));
        comparison.equalsCost(EXPECTED_TOTAL_PRICE_BEFORE_CHANGES,regexParser.getFuelPriceFromText(avtodispetcherCalculationPage.getDataFromForm()));
        avtodispetcherCalculationPage.changeDirection();
        comparison.equalsDistance(EXPECTED_DISTANCE_AFTER_CHANGES,actionsOnThePage.getText(avtodispetcherCalculationPage.DISTANCE_XPATH));
        comparison.equalsCost(EXPECTED_TOTAL_PRICE_AFTER_CHANGES,regexParser.getFuelPriceFromText(avtodispetcherCalculationPage.getDataFromForm()));



    }




    }



