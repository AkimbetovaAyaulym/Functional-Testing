package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class ViewPagePO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public ViewPagePO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void clickToLogoutLink() {
        By elem = By.linkText("Logout");
        driver.findElement(elem).click();
    }

    public void clickToViewIssuesLink() {
        By elem = By.linkText("View Issues");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickToManageLink() {
        By elem = By.linkText("Manage");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickToReportIssueLink() {
        By elem = By.linkText("Report Issue");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_CSSSELECTOR_centernth_child6() {
        By elem = By.cssSelector(".center:nth-child(6)");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void clickToViewIssuesLink_1() {
        clickToViewIssuesLink();
        set_CSSSELECTOR_centernth_child6();
    }

    public String set_CSSSELECTOR_centernth_child6_1() {
        By elem = By.cssSelector(".center:nth-child(6)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public String set_CSSSELECTOR_centernth_child7bold() {
        By elem = By.cssSelector(".center:nth-child(7) > .bold");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public String set_CSSSELECTOR_leftnth_child10() {
        By elem = By.cssSelector(".left:nth-child(10)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
