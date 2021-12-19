package Main;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;
import java.security.PublicKey;
import java.time.Duration;

public class OpenChrome {

    public ChromeDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        try {

            System.setProperty("webdriver.chrome.driver", String.valueOf(Paths.get("src/main/resources/tools/chromedriver.exe")));
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
            //Thread.sleep(2000);

        } catch (Exception e){
            System.out.println("Не удалось открыть страницу сайта");
        }
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}


