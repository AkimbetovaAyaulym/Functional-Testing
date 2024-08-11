package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class ReportIssuePO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public ReportIssuePO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void set_NAME_summary(String key1, String key2, String key3, String key4, String key5) {
        By elem = By.name("summary");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key5);
    }

    public void set_NAME_description(String key6) {
        By elem = By.name("description");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key6);
    }

    public void clickToSubmitReport() {
        By elem = By.cssSelector(".button");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void enterReportDetails(String key1, String key2, String key3, String key4, String key5, String key6) {
        {
            By elem = By.name("category_id");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key1 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
        {
            By elem = By.name("reproducibility");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key2 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
        {
            By elem = By.name("severity");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key3 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
        {
            By elem = By.name("priority");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key4 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
        set_NAME_summary(key1, key2, key3, key4, key5);
        set_NAME_description(key6);
        clickToSubmitReport();
    }
}
