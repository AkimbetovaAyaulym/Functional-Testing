package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.POs.ChangePasswordPO;
import com.example.POs.LoginFormPO;
import com.example.POs.ManageContentPO;

import com.example.POs.editUserPO;
import com.example.POs.usersPO;

public class addNewUser {
    private WebDriver driver;
    private LoginFormPO login;
    private ManageContentPO manageContent;
    private editUserPO editUser;
    private usersPO users;
    private ChangePasswordPO changePwd;
    @BeforeEach
    public void setUp(){
        // declaration and instantiation of objects/variables
        driver = new ChromeDriver();
        login = new LoginFormPO(driver);
        manageContent = new ManageContentPO(driver);
        editUser = new editUserPO(driver);
        users = new usersPO(driver);
        changePwd = new ChangePasswordPO(driver);
        login.loginTo("admin", "password");
    }
    @AfterEach
    public void teardown(){
        driver.close();
       
    }
    @Test
    public void addNewUserTest(){
        manageContent.clickToUsersLink();
        users.clickAddNewUser();
        editUser.enterDetails("usertest", "usertest123", "usertest123", "user@test.com", "Administrator");
        editUser.clickSaveBtn();
        assertTrue(users.isUserPresent("usertest"));
        manageContent.clickLogout();
    }
    @Test 
    public void changeUserPassword(){
        manageContent.clickToUsersLink();
        users.clickUser("usertest");
        editUser.clickToChangePwd();
        changePwd.enterNewPassword("newpassword", "newpassword");
        changePwd.clickSaveBtn();
        assertTrue(users.isPasswordChanged());
        manageContent.clickLogout();
    }

    @Test
    public void addUsersLink() throws InterruptedException{
        manageContent.clickToUsersLink();
        users.clickUser("admin");
        users.enterSocialLinks("https://www.facebook.com/some_fake_user_name_52432562135863", "https://instagram.com/some_fake_user_name_52432562135863");
        users.clickSaveBtn();
        manageContent.clickToUsersLink();
        Thread.sleep(3000);
        users.clickUser("admin");
        Thread.sleep(3000);
        assertEquals("https://www.facebook.com/some_fake_user_name_52432562135863", users.getFacebookLink());
        assertEquals("https://instagram.com/some_fake_user_name_52432562135863", users.getInstagramLink());
        manageContent.clickLogout();
    }


}
