package CookiesHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookiesPage {

    WebDriver driver;

    private String cookieButton = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(2)"; //CSS
    private String setCookie = "set-cookie"; //ID
    private String deleteCookie = "delete-cookie"; //ID

    public CookiesPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    public void findCookies(){
        driver.findElement(By.cssSelector(cookieButton)).click();
        WebElement removeCookie = driver.findElement(By.id(deleteCookie));
        WebElement addCookie = driver.findElement(By.id(setCookie));

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Number of cookies : " + cookies.size());

        addCookie.click();
        System.out.println("Number of cookies added from browser : " + driver.manage().getCookies().size());

        removeCookie.click();

        System.out.println("Number of cookies after using the Remove the cookie button: " + driver.manage().getCookies().size());

        Cookie c1 = new Cookie("a", "123");
        driver.manage().addCookie(c1);
        Cookie c2 = driver.manage().getCookieNamed("a");
        System.out.println("Cookies added from code: " + c2 );

        driver.manage().deleteAllCookies();
        System.out.println("Number of cookies : " + driver.manage().getCookies().size());

    }

}
