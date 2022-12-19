package ServiceNSW.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

@DefaultUrl("https://www.service.nsw.gov.au/")
public class HomePage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    By searchServiceField = By.xpath("//*[@id=\"homeautosuggestJLXw6HUDAvI\"]/input");
    By searchServiceButton = By.xpath("//*[@id=\"block-content\"]/article/section[1]/div/div[1]/header/div[2]/div/form/div[2]/button");

    public void wait(int wait) {
        try {
            sleep(wait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void inputService(String service) {
        driver.findElement(searchServiceField).sendKeys(service);
        wait(1000);
    }

    public void clickSearchServiceButton() {
        driver.findElement(searchServiceButton).click();
        wait(1000);
    }
}
