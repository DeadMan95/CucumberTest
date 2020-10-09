package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.SearchResultsPage;
import webdriver.WebDriverSettings;

public class CucumberSteps extends WebDriverSettings {

    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @Before
    public void start() {
        driverInit();
        homePage = PageFactory.initElements(driver, HomePage.class);
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
    }

    @After
    public void stop() { close(); }

    @Given("I go to home page")
    public void iGoToHomePage() {
        homePage.open();
    }

    @When("I type {string} and submit")
    public void iTypeAndSubmit(String searchString) {
        homePage.search(searchString);
    }

    @Then("I see page with {string} title")
    public void iSeePageWithTitle(String pageTitle) {
        Assert.assertTrue(searchResultsPage.checkTitle(pageTitle));
    }

}
