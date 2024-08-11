package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.POs.DashboardPO;
import com.example.POs.LoginFormPO;

/**
 * Unit test for simple App.
 */
public class AddNewProductTest 
{
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
        dashboard.clickProducts();
    }

    @AfterEach
    public void teardown(){
        // close Chrome
        dashboard.logout();
        driver.close();
    }

    @Test
    public void addNewProduct()
    {
        dashboard.clickAddNewProduct();
        dashboard.enterName("Blue Jacket3");
        dashboard.clickSave();
        assertTrue(dashboard.isSuccessMessageDisplayed(), "Test Failed: Success message is not displayed");

    }
    @Test
    public void addEmptyProduct(){
        dashboard.clickAddNewProduct();
        dashboard.clickSave();
        assertTrue(dashboard.isErrorMessageDisplayed(), "Test Failed: Error message is not displayed");
        // String expectedErrorMessage = "2 errors This link_rewrite field is required at least in English (English) This name field is required at least in English (English)";
        //assertTrue(dashboard.isErrorMessageDisplayed(expectedErrorMessage));
    
    }
    @Test
    public void editProduct()
    {
        dashboard.editProduct();
        dashboard.clearProductNameField();
        dashboard.enterName("Deep Blue Jacket");
        dashboard.clickSave();
        assertTrue(dashboard.isSuccessMessageDisplayed(), "Test failed: Success message is not displayed");
   
    }

    @Test
    public void addNewProductWithTaxFee() throws InterruptedException{
        dashboard.clickAddNewProduct();
        dashboard.clickPrices();
        Thread.sleep(5000);
        dashboard.enterPreTax("10");
        String retailPriceWithTax = dashboard.getRetailPriceWithTax();
        assertEquals("12.20", retailPriceWithTax, "Retail price with tax is incorrect");
       
    }

    @Test
    public void addNewProductWithTax10() throws InterruptedException{
        dashboard.clickAddNewProduct();
        dashboard.clickPrices();
        Thread.sleep(5000);
        dashboard.enterPreTax("10");
        dashboard.selectTaxRule("IT Reduced Rate (10%)");
        String retailPriceWithTax = dashboard.getRetailPriceWithTax();
        assertEquals("11.00", retailPriceWithTax, "Retail price with tax is incorrect");
    }
    

}
