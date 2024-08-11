package com.example.POs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DashboardPO {
    private WebDriver driver;
    WebDriverWait wait;
     Actions actions;

    By catalogMenu = By.id("maintab-AdminCatalog");
    By productsMenu = By.id("subtab-AdminProducts");
    By statesMenu = By.id("subtab-AdminStates");
    By productFeatures = By.id("subtab-AdminFeatures");
    By productAttributes= By.id("subtab-AdminAttributesGroups");

    By addNewProductButton = By.xpath("//*[@id=\"page-header-desc-product-new_product\"]");
    By NameField = By.id("name_1");
    By saveButton = By.cssSelector("button[type='submit']");
    By successMessage = By.cssSelector(".alert-success");
    By userIcon = By.xpath("//*[@id=\"employee_infos\"]/a/span[1]");
    By logoutLink = By.xpath("//*[@id=\"header_logout\"]");
    By errorMessage = By.cssSelector(".alert-danger");
    By editBtn = By.xpath("//*[@id=\"tr__10_0\"]/td[11]/div/div/a");
    By localizationMenu = By.id("maintab-AdminParentLocalization");
    By addNewStatesBtn = By.xpath("//*[@id=\"page-header-desc-state-new_state\"]/i");
    By stateNameField = By.id("name");
    By isoCodeField = By.id("iso_code");
    By pricesLink = By.xpath("//*[@id=\"link-Prices\"]");
    By priceField = By.xpath("//*[@id=\"priceTE\"]");
    By addNewFeaturesBtn = By.xpath("//*[@id=\"page-header-desc-feature-new_feature\"]/i");
    By addNewAttributesBtn= By.xpath("//*[@id=\"page-header-desc-attribute_group-new_attribute_group\"]");
    

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void hoverOnCatalog() {
        WebElement catalogElem = wait.until(ExpectedConditions.visibilityOfElementLocated(catalogMenu));
        actions.moveToElement(catalogElem).perform();
    }
    public void clickProducts() {
        WebElement productsElem = wait.until(ExpectedConditions.visibilityOfElementLocated(productsMenu));
        productsElem.click();
    }
    public void clickProductFeatures(){
        WebElement productsElem = wait.until(ExpectedConditions.visibilityOfElementLocated(productFeatures));
            productsElem.click();
    }
    public void clickProductAttributes(){
        WebElement productsElem = wait.until(ExpectedConditions.visibilityOfElementLocated(productAttributes));
            productsElem.click();
    }


    public void clickAddNewProduct() {
        driver.findElement(addNewProductButton).click();
    }
    public void clickAddNewAttributes() {
        driver.findElement(addNewAttributesBtn).click();
    }

    public void enterName(String productName) {
        driver.findElement(NameField).sendKeys(productName);
    }
    public void enterPublicName(String publicName) {
        driver.findElement(By.xpath("//*[@id=\"public_name_1\"]")).sendKeys(publicName);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
        /*WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div"));
        String actualErrorMessage = errorMessage.getText();
        return actualErrorMessage.contains(expectedErrorMessage);*/
    }
   


    public void logout() {
        driver.findElement(userIcon).click();
        driver.findElement(logoutLink).click();
    }

    public void editProduct() {
       driver.findElement(editBtn).click();
    }

    public void clearProductNameField() {
        driver.findElement(NameField).clear();
    }

    public void hoverOnLocalization() {
        WebElement catalogElem = wait.until(ExpectedConditions.visibilityOfElementLocated(localizationMenu));
        actions.moveToElement(catalogElem).perform();
    }
    public void clickStates() {
        WebElement productsElem = wait.until(ExpectedConditions.visibilityOfElementLocated(statesMenu));
        productsElem.click();
    }
    public void clickAddNewState() {
        driver.findElement(addNewStatesBtn).click();
    }
    public void enterStateName(String stateName) {
        driver.findElement(stateNameField).sendKeys(stateName);
    }
    public void enterISOCode(String isoCode) {
        driver.findElement(isoCodeField).sendKeys(isoCode);
    }

    public void selectCountry(String country) {
        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_country")));
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByVisibleText(country);
    }
    public void selectZone(String zone) {
        WebElement zoneDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_zone")));
        Select dropdown = new Select(zoneDropdown);
        dropdown.selectByVisibleText(zone);
    }
    /*public void clickStateSaveBtn() {
        driver.findElement(saveButton).click();
    }*/

    public void clickPrices(){
        driver.findElement(pricesLink).click();
    }
    public void enterPreTax(String price){
        driver.findElement(priceField).clear();
        driver.findElement(priceField).sendKeys(price);
    }
    public String getRetailPriceWithTax() {
        WebElement retailPriceWithTaxField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priceTI")));
        return retailPriceWithTaxField.getAttribute("value");
    }

    public void selectTaxRule(String rule) {
        WebElement taxRule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_tax_rules_group\"]")));
        Select dropdown = new Select(taxRule);
        dropdown.selectByVisibleText(rule);
    }

    public void clickAddNewFeatures(){
        driver.findElement(addNewFeaturesBtn).click();
    }
}
