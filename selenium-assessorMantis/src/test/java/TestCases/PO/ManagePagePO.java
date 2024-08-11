package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class ManagePagePO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public ManagePagePO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void clickToManageUsersLink() {
        By elem = By.linkText("Manage Users");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_LINKTEXT_username001() {
        By elem = By.linkText("username001");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void clickToManageUsersLink_1() {
        clickToManageUsersLink();
        set_LINKTEXT_username001();
    }

    public String set_LINKTEXT_username001_1() {
        By elem = By.linkText("username001");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public String set_CSSSELECTOR_row_1tdnth_child2() {
        By elem = By.cssSelector(".row-1 > td:nth-child(2)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public String set_CSSSELECTOR_row_1tdnth_child3() {
        By elem = By.cssSelector(".row-1 > td:nth-child(3)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public String set_CSSSELECTOR_row_1tdnth_child4() {
        By elem = By.cssSelector(".row-1 > td:nth-child(4)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public void clickToManageProjectsLink() {
        By elem = By.linkText("Manage Projects");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_LINKTEXT_Project001() {
        By elem = By.linkText("Project001");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void clickToManageProjectsLink_1() {
        clickToManageProjectsLink();
        set_LINKTEXT_Project001();
    }

    public String set_LINKTEXT_Project001_1() {
        By elem = By.linkText("Project001");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public String set_CSSSELECTOR_row_1tdnth_child5() {
        By elem = By.cssSelector(".row-1 > td:nth-child(5)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
