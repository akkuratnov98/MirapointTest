package Main.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage extends BasePage{

    By failedDiv = By.xpath("//div[@class='alert']");
    By successDiv = By.xpath("//div[@class='success']");
    By logoLoginHREF = By.xpath("//img[@src='Logo/Login']");
    By infoTitle = By.xpath("//div[@class='info-title']");
    By loginOrEmailField = By.xpath("//input[@name='loginOrEmail']");
    By enterLoginOrEmail = By.className("mira-page-forgot-password-button");
    By loginPageHREF = By.xpath("//a[@class='mira-page-forgot-password-link']");

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    public void inputLogin(String login){
        sendKey(loginOrEmailField, login);
    }

    public void clickEnter(){
        click(enterLoginOrEmail);
    }

    public String waitDivFailed(){
         return getTextElement(failedDiv);
    }

    public String waitDivSuccess(){
         return getTextElement(successDiv);
    }

    public void reloadLogInPageWithLogo(){
        click(logoLoginHREF);
    }

    public void backLoginPage(){
        click(loginPageHREF);
    }

    public String getInfoTitleText(){
        return getTextElement(infoTitle);
    }


}
