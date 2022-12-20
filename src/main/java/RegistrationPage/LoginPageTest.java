package RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginPageTest {

    WebDriver driver;
    String browser = "chrome";


    @BeforeTest
    public void beforeTest() {
        if (browser.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browser.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (browser.toLowerCase().equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @DataProvider(name = "registrationTest")
    public Iterator<Object[]> registrationDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"oana", "password23", "password23", "Oana", "Dragan", "", "", "Passwords do not match", "", ""});
        dp.add(new String[]{"", "password23", "password23", "Oana", "Dragan", "Please choose a username", "", "Passwords do not match", "", ""});
        dp.add(new String[]{"", "", "password23", "Oana", "Dragan", "Please choose a username", "Please choose a password", "Passwords do not match", "", ""});
        dp.add(new String[]{"", "", "", "O", "Dragan", "Please choose a username", "Please choose a password", "Passwords do not match", "Please choose a longer first name", ""});
        dp.add(new String[]{"", "", "", "O", "D", "Please choose a username", "Please choose a password", "Passwords do not match", "Please choose a longer first name", "Please choose a longer last name"});
        dp.add(new String[]{"oana", "password23", "password22", "Oana", "Dragan", "", "", "Passwords do not match", "", ""});
        return dp.iterator();
    }

    @Test(dataProvider = "registrationTest")
    public void loginTest(String username, String password, String confirmPassword, String firstName, String lastName, String userError, String passError, String confPassError, String firstNameError,
                          String lastNameError) {
        driver.navigate().to("http://86.121.249.151:4999/signup/");
        LoginPOMPage lp = new LoginPOMPage(driver);
        String email = "oana@test.com";
        String date = "12/02/2022";
        String nationality = "Albania";
        lp.login(username, password, confirmPassword, firstName,lastName, email, date, nationality);

        try {
            Assert.assertEquals(lp.getUsernameError(), userError);
            } catch (TimeoutException e) {
                System.out.println("Exceptional case");
            }
        try {
            Assert.assertEquals(lp.getPasswordError(), passError);
        } catch (TimeoutException e) {
            System.out.println("Exceptional case");
        }
        try {
            Assert.assertEquals(lp.getFirstNameErrorMsgCss(),firstNameError);
        } catch (TimeoutException e) {
            System.out.println("Exceptional case");
        }
        try {
            Assert.assertEquals(lp.getLastNameErrorMsgCss(), lastNameError);
        } catch (TimeoutException e) {
            System.out.println("Exceptional case");
        }


    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
