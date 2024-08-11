package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class ManageProjectsPO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public ManageProjectsPO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void clickToCreateNewProjectBtn() {
        By elem = By.cssSelector(".form-title .button-small");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickToAddCategoryBtn(String key1) {
        By elem = By.cssSelector(".button");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_CSSSELECTOR_row_2tdnth_child1() {
        By elem = By.cssSelector(".row-2 > td:nth-child(1)");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void enterCategoryDetails(String key1) {
        By elem = By.name("name");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
        clickToAddCategoryBtn(key1);
        set_CSSSELECTOR_row_2tdnth_child1();
    }

    public String set_CSSSELECTOR_row_2tdnth_child1_1() {
        By elem = By.cssSelector(".row-2 > td:nth-child(1)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public void set_CSSSELECTOR_trnth_child2center() {
        By elem = By.cssSelector("tr:nth-child(2) .center");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void enterCategoryDetails_1(String key1) {
        By elem = By.name("name");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
        clickToAddCategoryBtn(key1);
        set_CSSSELECTOR_trnth_child2center();
    }

    public String set_CSSSELECTOR_trnth_child2center_1() {
        By elem = By.cssSelector("tr:nth-child(2) .center");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
