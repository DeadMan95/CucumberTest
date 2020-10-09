package tests;

import org.junit.Assert;
import pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.SearchResultsPage;
import webdriver.WebDriverSettings;

public class TestCucumber extends WebDriverSettings {

    private String searchString = "google";
    private String title = searchString + " - Поиск в Google";

    @Test
    public void test() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        homePage.open();
        homePage.search(searchString);
        Assert.assertTrue(searchResultsPage.checkTitle(title));
    }

}
