package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

public class MyFirstTestFW extends BaseTest {

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "bvtdata")
    public void LoginTest(String username, String password) throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath(loc.getProperty("signin_button"))).click();
        Thread.sleep(4000);
        driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
        Thread.sleep(4000);
        driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(loc.getProperty("pwd_button"))).sendKeys(password);
        Thread.sleep(4000);
        driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();


    }

//    @DataProvider(name ="testdata")
//    public Object[][] tData()
//    {
//        return new Object[][]{
//                {"rcvtutorials@gmail.com","testautomation@123"},
//                {"rcvtutorials@gmail.com","testautomation4@123"},
//                {"rcvtutorials@gmail.com","testautomation3@123"},
//                {"rcvtutorials@gmail.com","testautomation123@123"}
//
//        };
//    }
}
