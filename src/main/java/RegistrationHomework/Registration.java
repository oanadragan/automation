package RegistrationHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Registration {
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
        dp.add(new String[] { "oana", "password23","password23","Oana","Dragan","oana@gmail.com", "", "", "","","",""} );
        dp.add(new String[] { "", "password23","password23","Oana","Dragan","oana@gmail.com", "Username is required!", "", "","","",""} );
        dp.add(new String[] { "", "","password23","Oana","Dragan","oana@gmail.com", "Username is required!", "Password is required!", "Passwords do not match!","","",""});
        dp.add(new String[] {  "", "","","O","Dragan","oana@gmail.com", "Username is required!", "Password is required!", "","Minimum of 2 characters is required!","",""});
        dp.add(new String[] {  "", "","","O","D","", "Username is required!", "Password is required!", "","Minimum of 2 characters is required!","Minimum of 2 characters is required!","Email is required!"});
        dp.add(new String[] { "oana", "password23","password22","Oana","Dragan","oana@gmail.com", "", "", "Passwords do not match!","","",""} );
        return dp.iterator();
    }

    @Test(dataProvider = "registrationTest")
    public void loginTest(String username, String password, String confirmPassword, String firstName, String lastName,
                          String email, String userError, String passError, String confPassError, String firstNameError,
            String lastNameError,String emailError) {
        driver.get("http://86.121.249.151:4999/auth.html#/registration");


        WebElement usernameInput = driver.findElement(By.id("input-username"));
        WebElement passwordInput = driver.findElement(By.id("input-password"));

        WebElement usernameError = driver.findElement(By.cssSelector("#registration-form > div:nth-child(2) > div > div > div.text-left.invalid-feedback"));
        WebElement passwordError = driver.findElement(By.cssSelector("#registration-form > div:nth-child(3) > div > div > div.text-left.invalid-feedback"));

        WebElement confirmPassInput = driver.findElement(By.id("input-password-confirm"));
        WebElement passwordConfirmError = driver.findElement(By.cssSelector("#registration-form > div:nth-child(4) > div > div > div.text-left.invalid-feedback"));

        WebElement radio1Mr = driver.findElement(By.cssSelector("#registration-form > div:nth-child(6) > div > div:nth-child(1) > input"));
        WebElement radio2Ms = driver.findElement(By.cssSelector("#registration-form > div:nth-child(6) > div > div:nth-child(2) > input"));



        WebElement firstNameInput = driver.findElement(By.id("input-first-name"));
        WebElement firstNameErrorMsg = driver.findElement(By.cssSelector("#registration-form > div:nth-child(7) > div > div > div.text-left.invalid-feedback"));


        WebElement lastNameInput = driver.findElement(By.id("input-last-name"));
        WebElement lastNameErrorMsg = driver.findElement(By.cssSelector("#registration-form > div:nth-child(8) > div > div > div.text-left.invalid-feedback"));

        WebElement emailInput = driver.findElement(By.id("input-email"));
        WebElement emailErrorText = driver.findElement(By.cssSelector("#registration-form > div:nth-child(9) > div > div > div.text-left.invalid-feedback"));


        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPassInput.clear();
        confirmPassInput.sendKeys(confirmPassword);
        radio1Mr.click();
        radio2Ms.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        emailInput.clear();
        emailInput.sendKeys(email);


        WebElement dateOfBirth = driver.findElement(By.cssSelector("#input-dob"));
        dateOfBirth.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement calendar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#registration-form > div:nth-child(10) > div > div > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__current-month")));
        calendar.getText();

        String monthYear = "March 2022";
        String day = "12";
        String date = "03/12/2022";

        // dateOfBirth.sendKeys(date);
        while (true) {
            String text = driver.findElement(By.cssSelector("#registration-form > div:nth-child(10) > div > div > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__current-month")).getText();

            if (text.equals(monthYear)) {
                break;
            } else {
                driver.findElement(By.cssSelector("#registration-form > div:nth-child(10) > div > div > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > button.react-datepicker__navigation.react-datepicker__navigation--previous")).click();
            }
        }

        List<WebElement> allDates = driver.findElements(By.className("react-datepicker__day"));

        for (WebElement ele : allDates) {
            String dt = ele.getText();
            if (dt.equals(day)) {
                ele.click();
                break;
            }
        }

        Select dropdown = new Select(driver.findElement(By.id("input-nationality")));
        String nationality = "Afghan";
        dropdown.selectByValue(nationality);
        List<WebElement> allElements = dropdown.getAllSelectedOptions();

        Assert.assertEquals(usernameError.getText(), userError);
        Assert.assertEquals(passwordError.getText(), passError);
        Assert.assertEquals(passwordConfirmError.getText(), confPassError);
        Assert.assertEquals(firstNameErrorMsg.getText(),firstNameError);
        Assert.assertEquals(lastNameErrorMsg.getText(), lastNameError);
        Assert.assertEquals(emailErrorText.getText(), emailError);
        Assert.assertEquals(dateOfBirth.getAttribute("Value"), date);
        Assert.assertEquals(allElements.get(0).getText(), nationality);

        WebElement termsAndConditions = driver.findElement(By.id("terms"));
        boolean checked = termsAndConditions.isSelected();

        WebElement submitButton = driver.findElement(By.cssSelector("#registration-form > div:nth-child(13) > div.text-left.col-lg > button"));
        submitButton.submit();
        WebElement termsAndConditionsError = driver.findElement(By.cssSelector("#registration-form > div:nth-child(12) > div.text-left.col-lg > div > div"));
        Assert.assertEquals(termsAndConditionsError.getText(), "You need to accept our T&C!");

        if (!checked) {
            termsAndConditions.click();
        }
        submitButton.submit();

    }

    @AfterTest
        public void afterTest(){

            driver.quit();
          }
    }

