package Main.TestSuite;

import Main.Page.LogInPage;
import Main.Page.MainPage;
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

public class TestLogInPage {

    ChromeDriver driver;
    LogInPage logInPage;
    PasswordRecoveryPage passwordRecoveryPage;
    MainPage mainPage;

    @BeforeTest
    public void openLogIn() {
            System.setProperty("webdriver.chrome.driver", String.valueOf(Paths.get("src/main/resources/tools/chromedriver.exe")));
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
            mainPage = PageFactory.initElements(driver, MainPage.class);
            logInPage = PageFactory.initElements(driver, LogInPage.class);
            passwordRecoveryPage = PageFactory.initElements(driver, PasswordRecoveryPage.class);
    }


    @Test(testName = "Переход на страницу востановления пароля", priority = 2)
    public void switchToRecoveryPage(){
        logInPage.switchToRecoveryPage();
        Assert.assertEquals(passwordRecoveryPage.getInfoTitleText(), "Восстановление пароля");
        logInPage.goToLogInPage();
    }

    @Parameters({"invalidLogin", "password"})
    @Test(testName = "Неверный Ввод Логина пользователя для авторизации", priority = 1)
    public void invalidLoginTest(String login, String password){
        logInPage.inputLogin(login);
        logInPage.inputPassword(password);
        logInPage.enterLoginPage();
        Assert.assertEquals("Неверные данные для авторизации", logInPage.getTextAlert());
    }

    @Parameters({"password"})
    @Test(testName = "Ввод пустого Логина пользователя для авторизации", priority = 1)
    public void emptyLoginTest(String password){
        String emptyLogin = "";
        logInPage.inputLogin(emptyLogin);
        logInPage.inputPassword(password);
        logInPage.enterLoginPage();
        Assert.assertEquals("Неверные данные для авторизации.", logInPage.getTextAlert());
    }

    @Parameters({"login"})
    @Test(testName = "Ввод пустого пароля пользователя для авторизации", priority = 1)
    public void emptyPasswordTest(String login){
        String emptyPassword = "";
        logInPage.inputLogin(login);
        logInPage.inputPassword(emptyPassword);
        logInPage.enterLoginPage();
        Assert.assertEquals("Неверные данные для авторизации.", logInPage.getTextAlert()); //При пустых полях появляется точка
    }

    @Parameters({"login", "invalidPassword"})
    @Test(testName = "Неверный Ввод Логина пользователя для авторизации", priority = 1)
    public void invalidPasswordTest(String login, String password){
        logInPage.inputLogin(login);
        logInPage.inputPassword(password);
        logInPage.enterLoginPage();
        Assert.assertEquals("Неверные данные для авторизации", logInPage.getTextAlert()); //При пустых полях появляется точка

    }

    @Parameters({"login", "password"})
    @Test(testName = "Ввод Верного Логина пользователя для авторизации", priority = 3)
    public void correctLoginTest(String login, String password){
        logInPage.inputLogin(login);
        logInPage.inputPassword(password);
        logInPage.enterLoginPage();
        Assert.assertEquals("Фомина Елена Сергеевна", mainPage.getFullNameText("title"));

    }

    @Test(testName = "Кнопка показа пароля", priority = 1)
    public void showPassword(){
        Assert.assertEquals("password", logInPage.getPasswordFieldType());
        logInPage.clickShowPassword();
        Assert.assertEquals("text", logInPage.getPasswordFieldType());
        logInPage.clickShowPassword();
        Assert.assertEquals("password", logInPage.getPasswordFieldType());
    }

    @Test(testName = "Проверка максимальной длины input login", priority = 1)
    public void testMaxLengthLogin(){
        StringBuilder lengthLogin = new StringBuilder();
        lengthLogin.append("0123456789".repeat(16));
        logInPage.inputLogin(lengthLogin.toString());
        Assert.assertEquals(150, logInPage.getLoginFieldValue().length());
    }

    @Test(testName = "Обновить стриацу загрузки нажав на Лого компании", priority = 2)
    public void reloadLogInPage(){
        logInPage.reloadLogInPageWithLogo();
        Assert.assertEquals("Вход в систему", logInPage.getInfoTitleText());
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}



