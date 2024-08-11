package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.POs.DashboardPO;
import com.example.POs.LoginFormPO;

public class AddNewAttributes {
      private WebDriver driver;
    private LoginFormPO login;
    private DashboardPO dashboard;

    @BeforeEach
    public void setUp(){
        // declaration and instantiation of objects/variables
        driver = new ChromeDriver();
        login = new LoginFormPO(driver);
        dashboard = new DashboardPO(driver);
        login.loginTo("admin@prestashop.com", "password");
        dashboard.hoverOnCatalog();
        dashboard.clickProductAttributes();
    }

    @AfterEach
    public void teardown(){
        // close Chrome
        dashboard.logout();
        driver.close();
    }
    @Test
    public void addNewAttributes(){
        dashboard.clickAddNewAttributes();
        dashboard.enterName("Quantity");
        dashboard.enterPublicName("Qnt");
        dashboard.clickSave();
        assertTrue(dashboard.isSuccessMessageDisplayed(), "Test failed: Success message is not displayed");
    }
}
