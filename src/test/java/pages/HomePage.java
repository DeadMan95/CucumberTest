package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    private static final String URL = "https://google.com";
    private static final String SEARCH_FIELD_XPATH = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input";

    @FindBy(xpath = SEARCH_FIELD_XPATH)
    public WebElement searchField;

    public void open() {
        driver.get(URL);
    }

    public void search(String string) {
        searchField.sendKeys(string);
        searchField.submit();
    }

}
