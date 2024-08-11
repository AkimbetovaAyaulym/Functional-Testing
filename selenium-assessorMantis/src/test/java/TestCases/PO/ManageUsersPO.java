package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class ManageUsersPO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public ManageUsersPO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void clickToCreateNewAccountBtn() {
        By elem = By.xpath("/html/body/table[3]/tbody/tr[1]/td[1]/form/input[2]");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }
}
