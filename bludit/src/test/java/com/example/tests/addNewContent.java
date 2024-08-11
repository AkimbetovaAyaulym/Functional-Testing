package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.POs.ContentPagePO;
import com.example.POs.LoginFormPO;
import com.example.POs.ManageContentPO;
import com.example.POs.editContentPO;

/**
 * Unit test for simple App.
 */
public class addNewContent 
{
    private WebDriver driver;
    private LoginFormPO login;
    private ManageContentPO manageContent;
    private editContentPO editContent;
    private ContentPagePO contentPage;
    @BeforeEach
    public void setUp(){
        // declaration and instantiation of objects/variables
        driver = new ChromeDriver();
        login = new LoginFormPO(driver);
        manageContent = new ManageContentPO(driver);
        editContent = new editContentPO(driver);
        contentPage = new ContentPagePO(driver);
        login.loginTo("admin", "password");
    }
    @AfterEach
    public void teardown(){
        driver.close();
       
    }

    @Test
    public void addaNewContent()
    {
        manageContent.clickAddNewContent();
        manageContent.enterTitle("Test Content");
        manageContent.clickSaveBtn();
        assertEquals("Test Content", manageContent.getFirstPublishedContentTitle());
        manageContent.clickLogout();
    }

    @Test 
    public void editContent() throws InterruptedException{
        manageContent.clickContentLink();
        contentPage.clickTestContent();
        editContent.clickAdvancedBtn();
        editContent.clearFriendlyUrl();
        editContent.enterFriendlyUrl("new-post-url");
        editContent.clickSaveBtn();
        manageContent.clickContentLink();
        assertTrue(manageContent.getFirstPublishedContentUrl().contains("/new-post-url"));
        manageContent.clickLogout();
    }
    @Test
    public void changeThePosition() throws InterruptedException{
        manageContent.clickContentLink();
        contentPage.clickTestContent();
        editContent.clickAdvancedBtn();
        editContent.clearPositionField();
        editContent.enterPositionField("30");
        editContent.clickSaveBtn();
        Thread.sleep(3000);
        manageContent.clickContentLink();
        contentPage.clickTestContent();
        editContent.clickAdvancedBtn();
        assertEquals("30", editContent.getPosition());
        manageContent.clickLogout();
    }

    @Test
    public void changeTheParentofContent(){
        manageContent.clickContentLink();
        manageContent.clickToContent("Test Content");
        editContent.clickAdvancedBtn();
        editContent.selectParent("Create your own content");
        editContent.clickSaveBtn();
        manageContent.clickContentLink();
        contentPage.clickTestContent();
        editContent.clickAdvancedBtn();
        assertEquals("Create your own content", editContent.getSelectedParent());
        manageContent.clickLogout();
    }
    @Test
    public void addANewDraft() throws InterruptedException{
        manageContent.clickAddNewContent();
        manageContent.enterTitle("Draft Content");
        Thread.sleep(3000);
        manageContent.clickSaveDraftBtn();
        Thread.sleep(3000);
        assertEquals("Draft Content", manageContent.getFirstPublishedContentTitle());
        manageContent.clickLogout();
    }
    @Test
    public void setaStickyContent(){
        manageContent.clickContentLink();
        manageContent.clickToContent("Set up your new site");
        editContent.clickAdvancedBtn();
        editContent.selectStatus("Sticky");
        editContent.clickSaveBtn();
        manageContent.clickContentLink();
        assertEquals("Set up your new site", manageContent.getFirstStickyContent());
        manageContent.clickLogout();
    }

    @Test
    public void deleteContent(){
        manageContent.clickContentLink();
        manageContent.clickToContent("Follow Bludit");
        editContent.clickDeleteBtn();
        editContent.confirmAlert();
        assertFalse(manageContent.isFollowBluditPresent());
        manageContent.clickLogout();
    }
    
}
