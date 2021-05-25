import core.SuperClass;
import org.junit.Test;

public class YandexTest extends SuperClass {

    @Test
    public void workingWithYandex(){

        yandexPage.getYandex();
        yandexPage.writeTextAndClick();
        yandexPage.goToTheWebsite();
        System.out.println("Ok");

    }

}
