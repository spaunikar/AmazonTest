package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    AppiumDriver driver;

    @FindBy(id = "sign_in_button")
    MobileElement gotoLogin;

    @FindBy(xpath = "//android.widget.EditText")
    MobileElement username;

    @FindBy(xpath = "//android.widget.Button[@text='Continue']")
    MobileElement continueButton;

    @FindBy(xpath = "//android.widget.EditText")
    MobileElement password;

    @FindBy(xpath = "//android.widget.Button[@text='Sign-In']")
    MobileElement signInButton;


    // constructor method
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement gotoLoginPage() {
        return gotoLogin;
    }

    public WebElement enterUser() {
        return username;
    }

    public WebElement clickContinue() {
        return continueButton;
    }

    public WebElement enterPassword() {
        return password;
    }

    public WebElement loginToAmazon() {
        return signInButton;
    }

}
