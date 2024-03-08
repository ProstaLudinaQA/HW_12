package Before;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class LogTest extends Ttest {
    @BeforeClass
    public void LoginTestCSS() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("LoginTestCSS");


    }

        @Test
        public void loginTest() {
            // Знаходження елементів за допомогою CSS-селекторів
            driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
            driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector("#login-button")).click();
    }

}

