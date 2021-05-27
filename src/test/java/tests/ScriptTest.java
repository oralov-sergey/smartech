package tests;

import core.SuperClass;
import org.junit.Test;

public class ScriptTest extends SuperClass {

    public static final String EXPECTED_SITE = "https://www.avtodispetcher.ru/distance/";
    public static final String EXPECTED_DISTANCE_BEFORE_CHANGES = "897";
    public static final String EXPECTED_TOTAL_PRICE_BEFORE_CHANGES = "3726";
    public static final String EXPECTED_DISTANCE_AFTER_CHANGES = "966";
    public static final String EXPECTED_TOTAL_PRICE_AFTER_CHANGES = "4002";
    public static final String THE_DISTANCES_ARE_NOT_THE_SAME = "The distances are not the same";
    public static final String DISTANCE_MESSAGE = THE_DISTANCES_ARE_NOT_THE_SAME;
    public static final String COST_MESSAGE = "The cost is not the same";
    public static final String URL_MESSAGE = "The Urls are not the same";


    @Test
    public void script(){

        yandexSearchFieldPage.getYandex();
        yandexSearchFieldPage.writeTextAndClick();
        yandexResultsPage.goToTheWebsite();
        yandexResultsPage.switchToAvtodispetcher();
        comparison.equalsTwoStrings(EXPECTED_SITE,actionsOnThePage.getUrl(), URL_MESSAGE);
        avtodispetcherRequestPage.fillInTheInputFields();
        avtodispetcherRequestPage.calculateTheWay();
        comparison.equalsTwoStrings(EXPECTED_DISTANCE_BEFORE_CHANGES,actionsOnThePage.getText(avtodispetcherCalculationPage.DISTANCE_XPATH), DISTANCE_MESSAGE);
        comparison.equalsTwoStrings(EXPECTED_TOTAL_PRICE_BEFORE_CHANGES,regexParser.getFuelPriceFromText(avtodispetcherCalculationPage.getDataFromForm()), COST_MESSAGE);
        avtodispetcherCalculationPage.changeDirection();
        comparison.equalsTwoStrings(EXPECTED_DISTANCE_AFTER_CHANGES,actionsOnThePage.getText(avtodispetcherCalculationPage.DISTANCE_XPATH),DISTANCE_MESSAGE);
        comparison.equalsTwoStrings(EXPECTED_TOTAL_PRICE_AFTER_CHANGES,regexParser.getFuelPriceFromText(avtodispetcherCalculationPage.getDataFromForm()),COST_MESSAGE);



    }




    }



