package Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Ttest {
    static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {
        if ( driver != null ) {
                       driver.quit();
        }
        System.out.println("afterTest");
    }
}

