package ServiceNSW.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

@DefaultUrl("https://www.service.nsw.gov.au/search-results?")
public class SearchResultPage extends PageObject{
    @Managed
    WebDriver driver = getDriver();

    By findLocationButton = By.xpath("//*[@id=\"global-header\"]/div/header/div[2]/div/nav/ul/li[4]");
    public void wait(int wait) {
        try {
            sleep(wait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickFindLocationButton() {
        driver.findElement(findLocationButton).click();
        wait(1000);
    }
}
