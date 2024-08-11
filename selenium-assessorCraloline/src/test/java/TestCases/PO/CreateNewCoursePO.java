package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CreateNewCoursePO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public CreateNewCoursePO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void set_ID_course_title(String key1) {
        By elem = By.id("course_title");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
    }

    public void set_ID_course_officialCode(String key2, String key3) {
        By elem = By.id("course_officialCode");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key2);
        {
            elem = By.id("mslist2");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key3 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
    }

    public void click_CSSSELECTOR_msremoveimg(String key4) {
        By elem = By.cssSelector(".msremove > img");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
        {
            elem = By.id("mslist2");
            MyUtils.WaitForElementLoaded(driver, elem);
            WebElement dropdown = driver.findElement(elem);
            elem = By.xpath("//option[. = '" + key4 + "']");
            MyUtils.WaitForElementLoaded(driver, elem);
            dropdown.findElement(elem).click();
        }
    }

    public void click_CSSSELECTOR_msremoveimg_1() {
        By elem = By.cssSelector(".msremove > img");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void click_ID_access_public() {
        By elem = By.id("access_public");
        driver.findElement(elem).click();
    }

    public void click_ID_registration_true() {
        By elem = By.id("registration_true");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickOKBtn() {
        By elem = By.xpath("//*[@id=\"courseSettings\"]/dl/dt/input");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void enterCourseDetails(String key1, String key2, String key3, String key4) {
        set_ID_course_title(key1);
        set_ID_course_officialCode(key2, key3);
        click_CSSSELECTOR_msremoveimg(key4);
        click_CSSSELECTOR_msremoveimg_1();
        click_ID_access_public();
        click_ID_registration_true();
        clickOKBtn();
    }

    public String set_CSSSELECTOR_claroDialogMsg() {
        By elem = By.xpath("//*[@id=\"claroBody\"]/div[2]/div");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }

    public void clickToContinue() {
        By elem = By.linkText("Continue");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }
}
