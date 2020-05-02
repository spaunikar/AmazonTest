package Tests;

import BaseUtility.MobileBaseUtility;
import BaseUtility.ReadFromExcel;
import Pages.LoginPage;
import Pages.SearchResult;
import genralized_utillity.Log4j.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class EbayApplication extends MobileBaseUtility {

    private String itemValue = null;
    private String username = "abc@gmail.com";
    private String password = "password";

    @BeforeMethod
    public void setup() throws IOException {

        //Create an object of ReadFromExcel class

        ReadFromExcel objExcelFile = new ReadFromExcel();

        //Prepare the path of excel file

        String filePath = System.getProperty("user.dir") + "/src/test/resources/app";

        //Call read file method of the class to read data

        itemValue = objExcelFile.readExcel(filePath, "Amazon_data.xlsx", "itemSheet");

    }


    @Test
    public void verifyEbayApplicationItemPurchase() throws InterruptedException {

        Log.startTestCase("verifyEbayApplicationItemPurchase");

        LoginPage login = new LoginPage(driver);
        login.gotoLoginPage().click();
        login.enterUser().click();
        login.enterUser().sendKeys(username);
        login.clickContinue().click();
        login.enterPassword().click();
        login.enterPassword().sendKeys(password);
        login.loginToAmazon().click();

        SearchResult searchResult = new SearchResult(driver);
        Boolean condition = searchResult.searchElement().isDisplayed();
        Assert.assertTrue(condition);
        searchResult.searchElement().click();
        searchResult.searchElement().sendKeys(itemValue);
        searchResult.pickItem().click();
        Boolean buyCondition = searchResult.checkBuyingOption().isDisplayed();
        Assert.assertTrue(buyCondition);
        searchResult.checkBuyingOption().click();

        Log.endTestCase();

    }


    @AfterMethod
    public void teardown() {

        driver.closeApp();
    }
}
