package TestCases;

import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.is;
import TestCases.PO.LoginPagePO;
import TestCases.PO.ManagePagePO;
import TestCases.PO.ManageProjectsPO;
import TestCases.PO.ViewPagePO;

public class addCategoryTest {
 private WebDriver driver;

    private Map<String, Object> vars;

    private JavascriptExecutor js;
    private LoginPagePO _LoginPagePO;
    private ViewPagePO _ViewPagePO;
    private ManagePagePO _ManagePagePO;
    private ManageProjectsPO _ManageProjectsPO;

    
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        _LoginPagePO = new LoginPagePO(driver, js, vars);
        _ViewPagePO = new ViewPagePO(driver, js, vars);
        _ManagePagePO = new ManagePagePO(driver, js, vars);
        _ManageProjectsPO = new ManageProjectsPO(driver, js, vars);
        _LoginPagePO.enterUsername("administrator");
        _LoginPagePO.enterPassword("root");
        _LoginPagePO.clickToLoginBtn();
    }

    @After
    public void tearDown() {
        driver.close();
    }

     @Test
    public void addCategory() {
        _ViewPagePO.clickToManageLink();
        _ManagePagePO.clickToManageProjectsLink();
        _ManageProjectsPO.enterCategoryDetails("Category001");
        assertThat(_ManageProjectsPO.set_CSSSELECTOR_row_2tdnth_child1_1(), is("Category001"));
        _ViewPagePO.clickToLogoutLink();
    }

    @Test
    public void addExistingCategory() {
        _ViewPagePO.clickToManageLink();
        _ManagePagePO.clickToManageProjectsLink();
        _ManageProjectsPO.enterCategoryDetails_1("Category001");
        assertThat(_ManageProjectsPO.set_CSSSELECTOR_trnth_child2center_1(), is("A category with that name already exists."));
        _ViewPagePO.clickToLogoutLink();
    }
}
