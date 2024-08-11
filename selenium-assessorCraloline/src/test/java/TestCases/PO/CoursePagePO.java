package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CoursePagePO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public CoursePagePO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void clickToAddanEventLink() {
        By elem = By.linkText("Add an event");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void enterEventDetails(String key1, String key2) {
        By elem = By.id("title");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
        {
            elem = By.id("fday");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key2 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
    }

    public void click_CSSSELECTOR_fdayoptionnth_child31(String key3) {
        By elem = By.cssSelector("#fday > option:nth-child(31)");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
        {
            elem = By.id("fmonth");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key3 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
    }

    public void click_CSSSELECTOR_fmonthoptionnth_child5(String key4) {
        By elem = By.cssSelector("#fmonth > option:nth-child(5)");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
        {
            elem = By.id("fyear");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key4 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
    }

    public void click_CSSSELECTOR_fyearoptionnth_child2() {
        By elem = By.cssSelector("#fyear > option:nth-child(2)");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_ID_location(String key5) {
        By elem = By.id("location");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key5);
    }

    public void click_NAME_submitEvent() {
        By elem = By.name("submitEvent");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_CSSSELECTOR_claroDialogMsg() {
        By elem = By.cssSelector(".claroDialogMsg");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void clickToAgentaIcon(String key1, String key2, String key3, String key4, String key5) {
        By elem = By.cssSelector("#CLCAL > .clItemTool");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
        clickToAddanEventLink();
        enterEventDetails(key1, key2);
        click_CSSSELECTOR_fdayoptionnth_child31(key3);
        click_CSSSELECTOR_fmonthoptionnth_child5(key4);
        click_CSSSELECTOR_fyearoptionnth_child2();
        set_ID_location(key5);
        click_NAME_submitEvent();
        set_CSSSELECTOR_claroDialogMsg();
    }

    public String set_CSSSELECTOR_claroDialogMsg_1() {
        By elem = By.cssSelector(".claroDialogMsg");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public void clickToNewExerciseLink() {
        By elem = By.linkText("New exercise");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void enterExerciseDetail(String key1) {
        By elem = By.id("title");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
    }

    public void clickToExerciseIcon(String key1) {
        By elem = By.cssSelector("#CLQWZ > .clItemTool");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
        clickToNewExerciseLink();
        enterExerciseDetail(key1);
        By elem2 = By.xpath("//*[@id=\"courseRightContent\"]/form/div[2]/input");
        MyUtils.WaitForElementLoaded(driver, elem2);
        driver.findElement(elem2).click();
        set_CSSSELECTOR_claroDialogMsg();
    }

    public void makeExerciseVisible() {
        By elem = By.cssSelector("tr:nth-child(2) > td:nth-child(4) img");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickToExerciseIcon_1() {
        By elem = By.id("CLQWZ");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }
    
    public String getVisibilityIconAltTextForRow(int rowNum) {
        By elem = By.cssSelector("tr:nth-child(" + rowNum + ") > td:nth-child(4) > a > img");
        MyUtils.WaitForElementLoaded(driver, elem);
        WebElement visibilityIcon = driver.findElement(elem);
        return visibilityIcon.getAttribute("alt");
    }

    public void clickToModifyIcon(){
        By elem = By.xpath("//*[@id=\"courseRightContent\"]/table/tbody/tr[2]/td[2]/a/img");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }


    public String getQuestionTitleForRow(int row) {
        return driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/table/tbody/tr[" + row + "]/td[2]")).getText();
    }

    public String getAnswerTypeForRow(int row) {
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[4]/small")).getText();
    }

}
