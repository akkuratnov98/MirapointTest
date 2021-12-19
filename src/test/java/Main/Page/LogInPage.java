package Main.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage extends BasePage{

    By loginField = By.name("user");
    By passwordField = By.name("password");
    By elementShowPassword = By.id("show_password");
    By enterLogIn = By.id("button_submit_login_form");
    By logoLoginHREF = By.xpath("//img[@src='Logo/Login']");
    By infoTitle = By.xpath("//div[@class='info-title']/div");
    By recoveryPageHREF = By.xpath("//a[@class='mira-default-login-page-link']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void goToLogInPage(){
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    public void clickShowPassword(){
        click(elementShowPassword);
    }

    public String passwordFieldElementAttribute(String attribute){
        return getElementAttribute(passwordField, attribute);
    }

    public String loginFieldAttribute(String attribute){
        return getElementAttribute(loginField, attribute);
    }

    public void inputLogin(String login){
        sendKey(loginField, login);
    }

    public void inputPassword(String password){
        sendKey(passwordField, password);
    }

    public void enterLoginPage() {
        click(enterLogIn);
    }

    public void reloadLogInPageWithLogo(){
        click(logoLoginHREF);
    }

    public void switchToRecoveryPage() {
        click(recoveryPageHREF);
    }

    public String getInfoTitleText(){
        return getTextElement(infoTitle);
    }
}
