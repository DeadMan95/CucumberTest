package pages;

import webdriver.WebDriverSettings;

public class Page extends WebDriverSettings {

    public boolean checkTitle(String title) {
        return driver.getTitle().equals(title);
    }

}
