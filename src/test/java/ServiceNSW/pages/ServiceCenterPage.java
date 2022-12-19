package ServiceNSW.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

@DefaultUrl("https://www.service.nsw.gov.au/service-centre")
public class ServiceCenterPage extends PageObject {

    @Managed
    WebDriver driver = getDriver();

    By searchLocationField = By.id("locatorTextSearch");
    By searchLocationButton = By.xpath("//*[@id=\"locator\"]/div/form/div/div/div[2]/div/button");
    By locationResult = By.xpath("//*[@id=\"locatorListView\"]/div/div[1]/div[1]/a");

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

    public void inputLocation(String loc) {
        driver.findElement(searchLocationField).sendKeys(loc);
        wait(1000);
    }

    public void clickSearchLocationButton() {
        driver.findElement(searchLocationButton).click();
        wait(1000);
    }

    public boolean getLocationResult() {
        return driver.findElement(locationResult).isDisplayed();
    }
}
