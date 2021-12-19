package Main.PasswordRecoveryPage;


import Main.LoginPage.SwitchPageFromLoginPage;
import Main.OpenChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRecoveryPage extends OpenChrome {

    @BeforeTest
    public void SwitchToRecoveryPage() {
        SwitchPageFromLoginPage switchPageFromLoginPage = new SwitchPageFromLoginPage();
        switchPageFromLoginPage.switchToRecoveryPage(driver);


    }

    @Parameters({"invalidEmail"})
    @Test(testName = "Ввод неправильного Email для востановления пароля", priority = 1)
    public void inputEmail(String invalidEmail) {
        enterLoginOrEmail(invalidEmail);

        Assert.assertEquals(new WebDriverWait(driver, Duration.ofSeconds(7))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert']"))).getText(),
                "Пользователь с таким именем не найден.");

    }

    @Parameters({"invalidLogin"})
    @Test(testName = "Ввод неправильного логина для востановления пароля", priority = 1)
    public void inputInvalidLogin(String invalidLogin) {
        enterLoginOrEmail(invalidLogin);

        Assert.assertEquals(new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert']"))).getText(),
                "Пользователь с таким именем не найден.");

    }

    @Parameters({"login"})
    @Test(testName = "Ввод правильного логина для востановления пароля", priority = 3)
    public void inputCorrectLogin(String login) {
        enterLoginOrEmail(login);

        Assert.assertEquals(new WebDriverWait(driver, Duration.ofSeconds(7))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='success']"))).getText(),
                "На ваш электронный адрес отправлена инструкция по восстановлению пароля.");
    }

    @Test(testName = "Переход на стриницу Авторизации", priority = 2)
    public void switchToLogInPage() {

        SwitchPageFromRecoveryPage fromRecoveryPage = new SwitchPageFromRecoveryPage();

        fromRecoveryPage.switchToLogInPage(driver);

        Assert.assertEquals(new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='info-title']/div")))
                .getText(), "Вход в систему");

        SwitchPageFromLoginPage pageFromLoginPage = new SwitchPageFromLoginPage();

        pageFromLoginPage.switchToRecoveryPage(driver);
    }

    public void enterLoginOrEmail(String login){
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("loginOrEmail")))
                .sendKeys(login);

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("mira-page-forgot-password-button"))).click();
    }
}

