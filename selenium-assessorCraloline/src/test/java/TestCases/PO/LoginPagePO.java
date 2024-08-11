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
    }

    public void set_ID_login(String key1) {
        By elem = By.id("login");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
    }

    public void set_ID_password(String key2) {
        By elem = By.id("password");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key2);
    }

    public void clickToEnterBtn() {
        By elem = By.cssSelector("button:nth-child(11)");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void loginTo(String key1, String key2) {
        set_ID_login(key1);
        set_ID_password(key2);
        clickToEnterBtn();
    }

    public void set_CSSSELECTOR_blockHeaderuserName() {
        By elem = By.cssSelector(".blockHeader > .userName");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void clickToEnterBtn_1() {
        clickToEnterBtn();
        set_CSSSELECTOR_blockHeaderuserName();
    }

    public String set_CSSSELECTOR_blockHeaderuserName_1() {
        By elem = By.cssSelector(".blockHeader > .userName");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
