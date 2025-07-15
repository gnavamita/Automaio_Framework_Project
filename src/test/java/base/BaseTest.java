package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public  WebDriver driver;
    public  Properties prop = new Properties();
    public  Properties loc = new Properties();
    public  FileReader fr;
    public  FileReader fr1;

    @BeforeMethod
    public void setup() throws IOException {

        if (driver == null) {
            //System.out.println("The path is "+System.getProperty("user.dir"));
            FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
            FileReader fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\locators.properties");
            prop.load(fr);
            loc.load(fr1);
        }
        if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chromedriver")) {
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
        }


    }

    @AfterMethod
    public void teardown() {
        driver.close();
        System.out.println("teardown successful");

    }
}
