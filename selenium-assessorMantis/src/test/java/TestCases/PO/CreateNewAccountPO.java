package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CreateNewAccountPO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public CreateNewAccountPO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void set_NAME_username(String key1) {
        By elem = By.name("username");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
    }

    public void set_NAME_realname(String key2) {
        By elem = By.name("realname");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key2);
    }

    public void set_NAME_email(String key3, String key4) {
        By elem = By.name("email");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key3);
        {
            elem = By.name("access_level");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key4 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
    }

    public void clickToCreateUserBtn() {
        By elem = By.cssSelector(".button");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void enterNewAccountDetails(String key1, String key2, String key3, String key4, boolean key5, boolean key6) {
        if (key1 != null)
            set_NAME_username(key1);
        if (key2 != null)
            set_NAME_realname(key2);
        if (key3 != null)
            set_NAME_email(key3, key4);
        if (key5 != false)
            clickToCreateUserBtn();
        if (key6 != false)
            set_CSSSELECTOR_trnth_child2center();
    }

    public void set_CSSSELECTOR_trnth_child2center() {
        By elem = By.cssSelector("tr:nth-child(2) .center");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void clickToCreateUserBtn_1() {
        clickToCreateUserBtn();
        set_CSSSELECTOR_trnth_child2center();
    }

    public String set_CSSSELECTOR_trnth_child2center_1() {
        By elem = By.cssSelector("tr:nth-child(2) .center");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
