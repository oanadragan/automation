package RegistrationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPOMPage {
    WebDriver driver;


    private String usernameInputId = "username";
    private String passwordInputId = "password";
    private String usernameErrorCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > small.form-error";
    private String passwordErrorCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(3) > small.form-error";
    private String confirmPassInputId = "password2";
    private String passwordConfirmErrorCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(4) > small.form-error";
    private String firstNameInputId = "input-first-name";
    private String firstNameErrorMsgCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(7) > small.form-error";
    private String lastNameInputId = "input-last-name";
    private String lastNameErrorMsgCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(8) > small.form-error";
    private String emailInputId = "input-email";
    private String dateOfBirthId = "input-dob";
    private String termsAndConditionsId = "terms";
    private String termsAndConditionsErrorCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(12) > small";
    private String submitButtonCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(13) > button";
    private String inputNationalityId = "input-nationality";
    private String radio1MrCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(6) > div:nth-child(2)";
    private String radio2MsCss = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(6) > div:nth-child(3)";

    public LoginPOMPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void login(String username, String password, String confirmPassword, String firstName, String lastName, String email,
                      String date, String nationality) {

        WebElement usernameInput = driver.findElement(By.id(usernameInputId));
        usernameInput.clear();
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id(passwordInputId));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement confirmPassInput = driver.findElement(By.id(confirmPassInputId));
        confirmPassInput.clear();
        confirmPassInput.sendKeys(confirmPassword);

        WebElement radio1Mr = driver.findElement(By.cssSelector(radio1MrCss));

        WebElement radio2Ms = driver.findElement(By.cssSelector(radio2MsCss));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(radio1MrCss)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", radio1Mr);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(radio2MsCss)));
        executor.executeScript("arguments[0].click();", radio2Ms);

        WebElement firstNameInput = driver.findElement(By.id(firstNameInputId));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.id(lastNameInputId));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);


        WebElement emailInput = driver.findElement(By.id(emailInputId));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement dateOfBirth = driver.findElement(By.id("input-dob"));
        dateOfBirth.sendKeys(date);

        Select dropdown = new Select(driver.findElement(By.id(inputNationalityId)));
        dropdown.selectByValue(nationality);
        List<WebElement> allElements = dropdown.getAllSelectedOptions();
        Assert.assertEquals(allElements.get(0).getText(), nationality);

        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonCss));
        submitButton.submit();

        WebElement termsAndConditions = driver.findElement(By.id(termsAndConditionsId));
        WebElement termsAndConditionsError = driver.findElement(By.cssSelector(termsAndConditionsErrorCss));
        Assert.assertEquals(termsAndConditionsError.getText(), "You need to accept the terms and conditions");



        //  WebDriverWait waitErrorMsg = new WebDriverWait(driver, 5);
        boolean checked = termsAndConditions.isSelected();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(termsAndConditionsErrorCss)));

        if (!checked) {
            termsAndConditions.click();
        }
        submitButton.submit();
    }

    public String getUsernameError() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(usernameErrorCss)));
        return driver.findElement(By.cssSelector(usernameErrorCss)).getText();
    }

    public String getPasswordError() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(passwordErrorCss)));
        return driver.findElement(By.cssSelector(passwordErrorCss)).getText();
    }

    public String getPasswordConfirmError() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(passwordConfirmErrorCss)));
        return driver.findElement(By.cssSelector(passwordConfirmErrorCss)).getText();
    }

    public String getFirstNameErrorMsgCss() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(firstNameErrorMsgCss)));
        return driver.findElement(By.cssSelector(firstNameErrorMsgCss)).getText();
    }
    public String getLastNameErrorMsgCss() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(lastNameErrorMsgCss)));
        return driver.findElement(By.cssSelector(lastNameErrorMsgCss)).getText();
    }
}

