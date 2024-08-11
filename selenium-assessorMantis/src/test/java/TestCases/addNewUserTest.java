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
import TestCases.PO.CreateNewAccountPO;
import TestCases.PO.LoginPagePO;
import TestCases.PO.ManagePagePO;
import TestCases.PO.ManageUsersPO;
import TestCases.PO.ViewPagePO;

public class addNewUserTest {

    private WebDriver driver;

    private Map<String, Object> vars;

    private JavascriptExecutor js;
    private LoginPagePO _LoginPagePO;
    private ViewPagePO _ViewPagePO;
    private ManagePagePO _ManagePagePO;
    private ManageUsersPO _ManageUsersPO;
    private CreateNewAccountPO _CreateNewAccountPO;
    
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        _LoginPagePO = new LoginPagePO(driver, js, vars);
        _ViewPagePO = new ViewPagePO(driver, js, vars);
        _ManagePagePO = new ManagePagePO(driver, js, vars);
        _ManageUsersPO = new ManageUsersPO(driver, js, vars);
        _CreateNewAccountPO = new CreateNewAccountPO(driver, js, vars);
       
        _LoginPagePO.enterUsername("administrator");
        _LoginPagePO.enterPassword("root");
        _LoginPagePO.clickToLoginBtn();
        _ViewPagePO.clickToManageLink();      
        _ManagePagePO.clickToManageUsersLink();       
        _ManageUsersPO.clickToCreateNewAccountBtn();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void login2() throws InterruptedException {    
        Thread.sleep(3000);
        assertThat(_LoginPagePO.set_CSSSELECTOR_login_info_left_1(), is("Logged in as: administrator (administrator)"));
        _ViewPagePO.clickToLogoutLink();
    }

    @Test
    public void addNewUser() {  
        _CreateNewAccountPO.enterNewAccountDetails("username001", "username001", "username@username.it", "updater", true, false);
        _ManagePagePO.clickToManageUsersLink_1();  
        assertThat(_ManagePagePO.set_LINKTEXT_username001_1(), is("username001"));
        assertThat(_ManagePagePO.set_CSSSELECTOR_row_1tdnth_child2(), is("username001"));
        assertThat(_ManagePagePO.set_CSSSELECTOR_row_1tdnth_child3(), is("username@username.it"));
        assertThat(_ManagePagePO.set_CSSSELECTOR_row_1tdnth_child4(), is("updater"));
        _ViewPagePO.clickToLogoutLink();
    }
    
    @Test
    public void addExistingUser() {
        _CreateNewAccountPO.enterNewAccountDetails("username001", "username001", "username@username.it", "updater", true, true);
        assertThat(_CreateNewAccountPO.set_CSSSELECTOR_trnth_child2center_1(), is("That username is already being used. Please go back and select another one."));
        _ViewPagePO.clickToLogoutLink();
    }

    @Test
    public void addEmptyUser() {
        _CreateNewAccountPO.clickToCreateUserBtn_1();
        assertThat(_CreateNewAccountPO.set_CSSSELECTOR_trnth_child2center_1(), is("A necessary field \"\" was empty. Please recheck your inputs."));
        _ViewPagePO.clickToLogoutLink();
    }
}
