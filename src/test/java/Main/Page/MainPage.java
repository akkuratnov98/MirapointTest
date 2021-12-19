package Main.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    By fullName = By.xpath("//div[@class='avatar-full-name']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getFullNameText(String attribute){
        return getElementAttribute(fullName, attribute);
    }
}
