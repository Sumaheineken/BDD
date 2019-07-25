package com.heineken.HAT.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mohana on 5/15/2019.
 */
public class CreateVendorRequestPage extends BasePage{

    public CreateVendorRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[text()='Local Data']")
    WebElement localDataTab;

    @FindBy(xpath=".//*[@class='glyphicon glyphicon-flash']")
    WebElement flashButton;

    @FindBy(xpath="//*[text()='Disable Local Request']")
    WebElement disableLocalRequestButton;

    @FindBy(xpath="//*[text()='Proceed']")
    WebElement proceedButton;

    public void clickLocalDataTab() {
        clickOnElement(localDataTab);
    }

    public void clickFlashButton() {
        clickOnElement(flashButton);
    }



}
