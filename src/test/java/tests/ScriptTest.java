package tests;

import core.SuperClass;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.fail;

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
    public static final String EXPECTED_MAP_CASE_1 = "expectedMapCase1";
    public static final String DIFF_MAPS_CASE_1 = "diffMapsCase1";
    public static final String EXPECTED_MAP_CASE_2 = "expectedMapCase2";
    public static final String DIFF_MAPS_CASE_2 = "diffMapsCase2";

    @Test
    public void script() {
        yandexSearchFieldPage.getYandex();
        yandexSearchFieldPage.writeTextAndClick();

        yandexResultsPage.goToTheWebsite();
        yandexResultsPage.switchToAvtodispetcher();

        comparison.equalsTwoStrings(EXPECTED_SITE, actionsOnThePage.getUrl(), URL_MESSAGE);

        avtodispetcherPage.fillInTheInputFields();
        avtodispetcherPage.calculateTheWay();

        comparison.equalsTwoStrings(EXPECTED_DISTANCE_BEFORE_CHANGES, actionsOnThePage.getText(avtodispetcherPage.DISTANCE_XPATH), DISTANCE_MESSAGE);
        comparison.equalsTwoStrings(EXPECTED_TOTAL_PRICE_BEFORE_CHANGES, regexParser.getFuelPriceFromText(avtodispetcherPage.getDataFromForm()), COST_MESSAGE);
        BufferedImage actualMapCase1 = avtodispetcherPage.takeScreenshot();
        comparison.compareTwoImages(EXPECTED_MAP_CASE_1, actualMapCase1, DIFF_MAPS_CASE_1);

        avtodispetcherPage.changeDirection();

        comparison.equalsTwoStrings(EXPECTED_DISTANCE_AFTER_CHANGES, actionsOnThePage.getText(avtodispetcherPage.DISTANCE_XPATH), DISTANCE_MESSAGE);
        comparison.equalsTwoStrings(EXPECTED_TOTAL_PRICE_AFTER_CHANGES, regexParser.getFuelPriceFromText(avtodispetcherPage.getDataFromForm()), COST_MESSAGE);
        BufferedImage actualMapCase2 = avtodispetcherPage.takeScreenshot();
        comparison.compareTwoImages(EXPECTED_MAP_CASE_2, actualMapCase2, DIFF_MAPS_CASE_2);
    }

    // This failed test was added to verify ability attach screenshot for failed cases.
    @Test
    public void script2() {
        yandexSearchFieldPage.getYandex();
        fail();
    }
}



