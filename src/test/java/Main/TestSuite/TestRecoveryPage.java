package Main.TestSuite;


import Main.Page.LogInPage;
import Main.Page.PasswordRecoveryPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;

public class TestRecoveryPage {

    public ChromeDriver driver;

    LogInPage logInPage;
    PasswordRecoveryPage passwordRecoveryPage;

    @BeforeTest
    public void SwitchToRecoveryPage() {
        try {
            System.setProperty("webdriver.chrome.driver", String.valueOf(Paths.get("src/main/resources/tools/chromedriver.exe")));
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
            logInPage = PageFactory.initElements(driver, LogInPage.class);
            passwordRecoveryPage = PageFactory.initElements(driver, PasswordRecoveryPage.class);
            logInPage.switchToRecoveryPage();
        } catch (Exception e) {
            System.out.println("Не удалось открыть страницу сайта");
        }
    }

    @Parameters({"invalidEmail"})
    @Test(testName = "Ввод неправильного Email для востановления пароля", priority = 1)
    public void inputEmail(String invalidEmail) {
        passwordRecoveryPage.inputLogin(invalidEmail);
        passwordRecoveryPage.clickEnter();
        Assert.assertEquals(passwordRecoveryPage.waitDivFailed(), "Пользователь с таким именем не найден.");
    }

    @Parameters({"invalidLogin"})
    @Test(testName = "Ввод неправильного логина для востановления пароля", priority = 1)
    public void inputInvalidLogin(String invalidLogin) {
        passwordRecoveryPage.inputLogin(invalidLogin);
        passwordRecoveryPage.clickEnter();
        Assert.assertEquals(passwordRecoveryPage.waitDivFailed(), "Пользователь с таким именем не найден.");
    }

    @Test(testName = "Возврат на стриницу Авторизации", priority = 2)
    public void switchToLogInPage() {
        passwordRecoveryPage.backLoginPage();
        Assert.assertEquals(logInPage.getInfoTitleText(), "Вход в систему");
        logInPage.switchToRecoveryPage();
    }

    @Test(testName = "Переход на страницу авторизации через Logo компании", priority = 2)
    public void goToLogInPage() {
        passwordRecoveryPage.reloadLogInPageWithLogo();
        Assert.assertEquals(logInPage.getInfoTitleText(), "Вход в систему");
        logInPage.switchToRecoveryPage();
    }

    @Parameters({"login"})
    @Test(testName = "Ввод правильного логина для востановления пароля", priority = 3)
    public void inputCorrectLogin(String login) {
        passwordRecoveryPage.inputLogin(login);
        passwordRecoveryPage.clickEnter();
        Assert.assertEquals(passwordRecoveryPage.waitDivSuccess(), "На ваш электронный адрес отправлена инструкция по восстановлению пароля.");
    }



    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}

