package TestCases.PO;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewQuestionPO {
    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public AddNewQuestionPO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }
    
    public void clickNewQuestionLink() {
        driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[3]/a")).click();
    }

    public void enterQuestionTitle(String title) {
        driver.findElement(By.id("title")).sendKeys(title);
    }

    public void selectQuestionType(String type) {
        By elem = By.id(type);
        MyUtils.WaitForElementLoaded(driver, elem);
       driver.findElement(elem).click();
      
    }

    public void clickOkButton() {
        driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/div[2]/input")).click();
    }
    public void clickOKBtn() {
        driver.findElement(By.name("cmdOk")).click();
    }

    public void selectFirstAnswer() {
        By elem = By.cssSelector("input[type='radio']");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clearAndEnterWeightingForAnswer(int answerNumber, String weighting) {
        By weightingFieldSelector = By.cssSelector("input[name='grade_" + answerNumber + "']");
        MyUtils.WaitForElementLoaded(driver, weightingFieldSelector);
        
        WebElement weightingField = driver.findElement(weightingFieldSelector);
        weightingField.clear();
        weightingField.sendKeys(weighting);
    }


    public void clickAddAnswerButton() {
        By addansw = By.name("cmdAddAnsw");
        MyUtils.WaitForElementLoaded(driver, addansw);
        driver.findElement(addansw).click();
    }

    public void selectFirstCheckbox() {
        By elem = By.cssSelector("input[type='checkbox']");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickExerciseLink(String exerciseName) {
        driver.findElement(By.linkText(exerciseName)).click();
    }
    public void clickExerciseLink(){
        By exerciseLink = By.linkText("Exercise 001");
        MyUtils.WaitForElementLoaded(driver, exerciseLink);
        driver.findElement(exerciseLink).click();
    }

    public void clearAndEnterWeightingForTF(String answerType, String weighting) {
    String inputName = (answerType.equalsIgnoreCase("true")) ? "trueGrade" : "falseGrade";
    By weightingFieldSelector = By.cssSelector("input[name='" + inputName + "']");
    
    // Wait for the element to be loaded
    MyUtils.WaitForElementLoaded(driver, weightingFieldSelector);
    WebElement weightingField = driver.findElement(weightingFieldSelector);
    weightingField.clear();
    weightingField.sendKeys(weighting);
}

}
