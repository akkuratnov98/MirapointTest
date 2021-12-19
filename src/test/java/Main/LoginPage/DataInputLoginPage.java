package Main.LoginPage;


import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class DataInputLoginPage {

   private ChromeDriver driver;

//   @Step("Ввод Логина")
    public void inputLogin(String login){
       new WebDriverWait(driver, Duration.ofSeconds(3))
               .until(ExpectedConditions.presenceOfElementLocated(By.name("user")))
               .sendKeys(login);
    }

   //@Step("Ввод Пароля")
    public void inputPassword(String password){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("password")))
                .sendKeys(password);
    }

    //@Step("Нажатие Войти на LoginPage")
    public void enterLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("button_submit_login_form")))
                .click();
    }

    //@Step("Получение теекст с Alert")
    public String getTextAlert(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Alert alert =  wait.until(alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;

    }

    public void setDriver(ChromeDriver driver) {
        this.driver = driver;
    }


}