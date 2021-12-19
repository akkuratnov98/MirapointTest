package Main.LoginPage;

import Main.OpenChrome;
import Main.PasswordRecoveryPage.SwitchPageFromRecoveryPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;


public class TestLogInPage extends OpenChrome {


    private DataInputLoginPage dataInputLoginPage = new DataInputLoginPage();

    @BeforeTest
    public void aVoid() {

        dataInputLoginPage.setDriver(driver);
    }

    @Test(testName = "Переход на страницу востановления пароля", priority = 2)
    public void SwitchToRecoveryPage(){

        SwitchPageFromLoginPage switchPageFromLoginPage = new SwitchPageFromLoginPage();

        switchPageFromLoginPage.switchToRecoveryPage(driver);

        Assert.assertEquals(new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("info-title")))
                .getText(), "Восстановление пароля");

        SwitchPageFromRecoveryPage fromRecoveryPage = new SwitchPageFromRecoveryPage();

        fromRecoveryPage.switchToLogInPage(driver);
    }

    @Parameters({"invalidLogin", "password"})
    @Test(testName = "Неверный Ввод Логина пользователя для авторизации", priority = 1)
    public void invalidLoginTest(String login, String password){
        dataInputLoginPage.inputLogin(login);

        dataInputLoginPage.inputPassword(password);

        dataInputLoginPage.enterLoginPage();

        Assert.assertEquals("Неверные данные для авторизации", dataInputLoginPage.getTextAlert());

    }

    @Parameters({"password"})
    @Test(testName = "Ввод пустого Логина пользователя для авторизации", priority = 1)
    public void emptyLoginTest(String password){

        String emptyLogin = "";
        dataInputLoginPage.inputLogin(emptyLogin);

        dataInputLoginPage.inputPassword(password);

        dataInputLoginPage.enterLoginPage();

        Assert.assertEquals("Неверные данные для авторизации.", dataInputLoginPage.getTextAlert());

    }

    //@Parameters({"login"})
    @Test(testName = "Ввод пустого пароля пользователя для авторизации", priority = 1)
    //public void emptyPasswordTest(String login){
    public void emptyPasswordTest(){

        String emptyPassword = "";
        dataInputLoginPage.inputLogin("login");

        dataInputLoginPage.inputPassword(emptyPassword);

        dataInputLoginPage.enterLoginPage();

        Assert.assertEquals("Неверные данные для авторизации.", dataInputLoginPage.getTextAlert()); //При пустых полях появляется точка

    }


    @Parameters({"login", "invalidPassword"})
    @Test(testName = "Неверный Ввод Логина пользователя для авторизации", priority = 1)
    public void invalidPasswordTest(String login, String password){
        dataInputLoginPage.inputLogin(login);

        dataInputLoginPage.inputPassword(password);

        dataInputLoginPage.enterLoginPage();

        Assert.assertEquals("Неверные данные для авторизации", dataInputLoginPage.getTextAlert()); //При пустых полях появляется точка

    }

//    @Parameters({"login", "password"})
//    @Test(testName = "Неверный Ввод Логина пользователя")
//    public void correctLoginTest(String login, String password){

    @Test(testName = "Ввод Верного Логина пользователя для авторизации", priority = 3)
    public void correctLoginTest(){

        dataInputLoginPage.inputLogin("fominaelena");

        dataInputLoginPage.inputPassword("1P73BP4Z");

        dataInputLoginPage.enterLoginPage();

        //Assert.assertEquals("Неверные данные для авторизации", dataInputLoginPage.getTextAlert());

    }

    @Test(testName = "Кнопка показа пароля", priority = 1)
    public void showPassword(){
        WebElement elementPassword = driver.findElement(By.name("password"));
        WebElement elementShowPassword = driver.findElement(By.id("show_password"));

        Assert.assertEquals("password", elementPassword.getAttribute("type"));
        elementShowPassword.click();
        Assert.assertEquals("text", elementPassword.getAttribute("type"));
        elementShowPassword.click();
        Assert.assertEquals("password", elementPassword.getAttribute("type"));
    }


    @Test(testName = "Проверка максимальной длины input login", priority = 1)
    public void testMaxLengthLogin(){
        StringBuilder lengthLogin = new StringBuilder();
        lengthLogin.append("0123456789".repeat(16));
        dataInputLoginPage.inputLogin(lengthLogin.toString());

        Assert.assertEquals(150, driver.findElement(By.name("user")).getAttribute("value").length());
    }


}



