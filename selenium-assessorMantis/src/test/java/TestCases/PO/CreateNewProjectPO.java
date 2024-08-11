package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CreateNewProjectPO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public CreateNewProjectPO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void set_NAME_name(String key1, String key2) {
        By elem = By.name("name");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
        {
            elem = By.name("status");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key2 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
    }

    public void set_NAME_description(String key3) {
        By elem = By.name("description");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key3);
    }

    public void clickToCreateProjectBtn() {
        By elem = By.cssSelector(".button");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void enterNewProjectDetails(String key1, String key2, String key3, boolean key4, boolean key5) {
        if (key1 != null)
            set_NAME_name(key1, key2);
        if (key3 != null)
            set_NAME_description(key3);
        if (key4 != false)
            clickToCreateProjectBtn();
        if (key5 != false)
            set_CSSSELECTOR_trnth_child2center();
    }

    public void set_CSSSELECTOR_trnth_child2center() {
        By elem = By.cssSelector("tr:nth-child(2) .center");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public String set_CSSSELECTOR_trnth_child2center_1() {
        By elem = By.cssSelector("tr:nth-child(2) .center");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
