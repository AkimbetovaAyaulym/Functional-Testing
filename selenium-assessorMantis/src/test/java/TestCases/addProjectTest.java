package TestCases;

import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestCases.PO.CreateNewProjectPO;
import TestCases.PO.LoginPagePO;
import TestCases.PO.ManagePagePO;
import TestCases.PO.ManageProjectsPO;
import TestCases.PO.ViewPagePO;

public class addProjectTest {

    private WebDriver driver;

    private Map<String, Object> vars;

    private JavascriptExecutor js;
    private LoginPagePO _LoginPagePO;
    private ViewPagePO _ViewPagePO;
    private ManagePagePO _ManagePagePO;
    private CreateNewProjectPO _CreateNewProjectPO;
    private ManageProjectsPO _ManageProjectsPO;

    
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        _LoginPagePO = new LoginPagePO(driver, js, vars);
        _ViewPagePO = new ViewPagePO(driver, js, vars);
        _ManagePagePO = new ManagePagePO(driver, js, vars);
        _CreateNewProjectPO = new CreateNewProjectPO(driver, js, vars);
        _ManageProjectsPO = new ManageProjectsPO(driver, js, vars);
       
        _LoginPagePO.enterUsername("administrator");
        _LoginPagePO.enterPassword("root");
        _LoginPagePO.clickToLoginBtn();
       
        _ViewPagePO.clickToManageLink();
        _ManagePagePO.clickToManageProjectsLink();
        _ManageProjectsPO.clickToCreateNewProjectBtn();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void addProject() {
        _CreateNewProjectPO.enterNewProjectDetails("Project001", "release", "Description", true, false);
        _ViewPagePO.clickToManageLink();
        _ManagePagePO.clickToManageProjectsLink_1();
        assertThat(_ManagePagePO.set_LINKTEXT_Project001_1(), is("Project001"));
        assertThat(_ManagePagePO.set_CSSSELECTOR_row_1tdnth_child2(), is("release"));
        assertThat(_ManagePagePO.set_CSSSELECTOR_row_1tdnth_child4(), is("public"));
        assertThat(_ManagePagePO.set_CSSSELECTOR_row_1tdnth_child5(), is("Description"));
        _ViewPagePO.clickToLogoutLink();
    }

    @Test
    public void addExistingProject() {
        _CreateNewProjectPO.enterNewProjectDetails("Project001", "release", "Description", true, true);
        assertThat(_CreateNewProjectPO.set_CSSSELECTOR_trnth_child2center_1(), is("A project with that name already exists. Please go back and enter a different name."));
        _ViewPagePO.clickToLogoutLink();
    }
}
