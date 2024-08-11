package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class AssignIssuePO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public AssignIssuePO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void clickToOKBtn(String key1) {
        By elem = By.xpath("//*[@id=\"buglist\"]/tbody/tr[5]/td/span[1]/input[2]");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickToAssignIssuesBtn() {
        By elem = By.cssSelector(".button");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_CSSSELECTOR_centernth_child8() {
        By elem = By.cssSelector(".center:nth-child(8)");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void assignIssue(String key1) throws InterruptedException {
        {
            By elem = By.name("action");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            
            elem = By.xpath("//option[. = '" + key1 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
        clickToOKBtn(key1);
        clickToAssignIssuesBtn();
        set_CSSSELECTOR_centernth_child8();
    }

    public String set_CSSSELECTOR_centernth_child8_1() {
        By elem = By.cssSelector(".center:nth-child(8)");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
