package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.SearchResultsPage;
import webdriver.WebDriverSettings;

public class ТестОгурца extends WebDriverSettings {

    HomePage homePage;
    SearchResultsPage searchResultsPage;

    //@Before
    public void start() {
        driverInit();
        homePage = PageFactory.initElements(driver, HomePage.class);
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
    }

    //@After
    public void stop() {
        close();
    }

    @Допустим("я перехожу на главную страницу")
    public void яПерехожуНаГлавнуюСтраницу() {
        homePage.open();
    }

    @Если("я ввожу {string} в поиск и нажимаю Enter")
    public void яВвожуВПоискИНажимаюEnter(String текст) {
        homePage.search(текст);
    }

    @То("я перехожу на страницу {string}")
    public void яПерехожуНаСтраницу(String заголовок) {
        Assert.assertTrue(searchResultsPage.checkTitle(заголовок));
    }

}
