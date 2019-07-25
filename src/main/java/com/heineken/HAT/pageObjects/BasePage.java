package com.heineken.HAT.pageObjects;

import com.heineken.HAT.core.config.GlobalConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;


/**
 * Created by mohana on 5/8/2019.
 */
public class BasePage {

    public WebDriver driver;
    private final int webDriverWaitTime = GlobalConstants.WEB_DRIVER_WAIT_TIME;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public void waitForElementClickable(WebElement element) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void waitForElementPresent(WebElement element) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void mouseHoverJScript(WebElement element) {
        try{
            waitForElementPresent(element);
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) driver).executeScript(mouseOverScript,
                    element);
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void waitForLinkPresent(String linkText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(By
                    .linkText(linkText)));
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void waitForPartialLinkPresent(String linkText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(By
                    .partialLinkText(linkText)));
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }


    public void clickOnElement(WebElement element){
        try {
            waitForElementClickable(element);
            element.click();
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void clearOnElement(WebElement element){
        try {
            waitForElementClickable(element);
            element.clear();
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void enterValueOnElement(WebElement element,String value){
        try {
            waitForElementClickable(element);
            element.sendKeys(value);
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void enterValueOnElementThroughJS(WebElement element,String value){
        try {
            waitForElementClickable(element);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value=arguments[1];",element,value);
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            waitForElementPresent(element);
            flag = element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return flag;
    }


    public boolean isElementEnabled(WebElement element) {
        boolean flag = false;
        try {
            waitForElementPresent(element);
            flag = element.isEnabled();
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return flag;
    }



    public boolean isElementSelected(WebElement element){
        boolean flag=false;
        try{
            waitForElementPresent(element);
            flag=element.isSelected();
        }catch (NoSuchElementException e){
            e.getMessage();
        }
        return flag;
    }

    public boolean verifyText(WebElement element, String expectedText) {
        waitForElementPresent(element);
        boolean flag = false;
        try {
            String text = element.getText();
            flag = expectedText.equalsIgnoreCase(text);
        } catch (Exception e) {
            e.getMessage();
        }
        return flag;
    }

    public boolean verifyTextPresentOnPage(String expectedText) {
        boolean flag = false;
        try {
            String entireHtmlPageSource = driver.getPageSource();
            flag = entireHtmlPageSource.contains(expectedText);

        } catch (Exception e) {
            e.getMessage();
        }
        return flag;
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        waitForElementPresent(element);
        try {
            Select object = new Select(element);
            object.selectByVisibleText(visibleText);
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
    }

    public void selectByIndex(WebElement element, int index) {
        waitForElementPresent(element);
        try {
            Select object = new Select(element);
            object.selectByIndex(index);
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
    }

    public void selectByValue(WebElement element, String value) {
        waitForElementPresent(element);
        try {
            Select object = new Select(element);
            object.selectByValue(value);
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
    }

    public String getSelectedText(WebElement element) {
        waitForElementPresent(element);
        String firstSelectedOption = null;
        try {
            Select mySelectElement = new Select(element);
            firstSelectedOption = mySelectElement.getFirstSelectedOption().getText();

        } catch (NoSuchElementException e) {

        }
        return firstSelectedOption;

    }

    public void moveToElement(WebElement element) {
        waitForElementPresent(element);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public boolean isAlertPresent() {
        boolean flag=false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
            wait.until(ExpectedConditions.alertIsPresent());
            flag=true;
        } catch (NoAlertPresentException e) {
            e.getMessage();
            flag=false;
        } return flag;
    }

    public void acceptAlert() {
        try {
            if(isAlertPresent()) {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        } catch (NoAlertPresentException e) {
            e.getMessage();
        }
    }

    public void cancelAlert() {
        try {
            if(isAlertPresent()) {
                Alert alert = driver.switchTo().alert();
                alert.dismiss();
            }
        } catch (NoAlertPresentException e) {
            e.getMessage();
        }
    }

    public void mouseClick(WebElement element){
        waitForElementClickable(element);
        try{
            Actions actions=new Actions(driver);
            actions.moveToElement(element);
            actions.click(element);
            actions.build().perform();
        }catch (Exception e){

        }
    }

    public void mouseDoubleClick(WebElement element){
        waitForElementClickable(element);
        try{
            Actions actions=new Actions(driver);
            actions.moveToElement(element);
            actions.doubleClick(element);
            actions.build().perform();
        }catch (Exception e){

        }
    }

    public void waitForSeconds(int ms) {
        try {
            Thread.sleep(ms*GlobalConstants.THOUSAND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void jsClick(WebElement element){
        //In IE Browser normal click wont work sometimes, in that case one can use java script click
        waitForElementClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void waitUntilObjectDisappears(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            e.getMessage();
        }
    }

    public void scrollDown() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,800)", "");
    }

    public void scrollUp() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,-800)", "");
    }

    public void mouseMoveXY(int xOffset, int yOffset) {
        Actions mouseMove = new Actions(driver).moveByOffset(xOffset, yOffset);
        mouseMove.build().perform();
    }

    public void waitForPageLoad(){
        try{
            new WebDriverWait(driver,webDriverWaitTime).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        catch(Exception e){

        }
    }

    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    public void browserClose()
    {
        driver.close();
    }

    public void browserQuit()
    {
        driver.quit();
    }

    public void setPosition()
    {
        driver.manage().window().setPosition(new Point(-2000, 0));
    }

}
