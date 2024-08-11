package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class LoginPagePO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public LoginPagePO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
        driver.get("http://localhost:3000/mantisbt/login_page.php");
    }

    /*public void set_CSSSELECTOR_login_info_left() {
        By elem = By.cssSelector(".login-info-left");
        MyUtils.WaitForElementLoaded(driver, elem);
    }*/

    public void enterUsername(String username){
        By elem = By.name("username");
        driver.findElement(elem).sendKeys(username);
    }
    public void enterPassword(String password){
        By elem2 = By.name("password");
        driver.findElement(elem2).sendKeys(password);
    }
    public void clickToLoginBtn(){
        By elem3 = By.cssSelector(".button");
       
        driver.findElement(elem3).click();
    }

    public String set_CSSSELECTOR_login_info_left_1() {
        By elem = By.cssSelector(".login-info-left");
        return driver.findElement(elem).getText();
    }
}
