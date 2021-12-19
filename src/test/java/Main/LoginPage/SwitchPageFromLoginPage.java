package Main.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwitchPageFromLoginPage {

    public void switchToRecoveryPage(WebDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mira-default-login-page-link']")))
                .click();

    }

    public void reloadLogInPage(WebDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='Logo/Login']")))
                .click();

    }
}
