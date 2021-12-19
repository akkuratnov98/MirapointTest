package Main.Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitElementLocated(By elementBy){
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    public void click(By elementBy){
        waitElementLocated(elementBy);
        driver.findElement(elementBy).click();
    }

    public void sendKey(By elementBy, String str){
        waitElementLocated(elementBy);
        driver.findElement(elementBy).sendKeys(str);
    }

    public String getTextElement(By elementBy){
        waitElementLocated(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public String getElementAttribute(By elementBy, String attribute){
        waitElementLocated(elementBy);
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    public String getTextAlert(){
        Alert alert =  wait.until(alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
