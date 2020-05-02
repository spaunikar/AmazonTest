package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {

    AppiumDriver driver;

    @FindBy(id = "rs_search_src_text")
    MobileElement searchBox;

    @FindBy(xpath = "//android.view.View[contains(@text,'Sceptre')][1]")
    MobileElement lastRecord;

    @FindBy(xpath = "//android.widget.Button[@text='See All Buying Options']")
    MobileElement seeAllBuyingOption;


    // constructor method
    public SearchResult(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement searchElement() {
        return searchBox;
    }

    public WebElement pickItem() {
        return lastRecord;
    }

    public WebElement checkBuyingOption() {
        return seeAllBuyingOption;
    }

}
