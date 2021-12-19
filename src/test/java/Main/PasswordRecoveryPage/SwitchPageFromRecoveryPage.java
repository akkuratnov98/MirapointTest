package Main.PasswordRecoveryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwitchPageFromRecoveryPage {

    public void comebackToLogInPage(ChromeDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mira-page-forgot-password-link']")))
                .click();
    }

    public void goToLogInPageFromLogo(WebDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='Logo/Login']")))
                .click();

    }
}
