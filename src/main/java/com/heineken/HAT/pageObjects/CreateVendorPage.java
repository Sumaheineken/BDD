package com.heineken.HAT.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mohana on 5/15/2019.
 */
public class CreateVendorPage extends BasePage{

    public CreateVendorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[contains(text(),'Vendors')]")
    WebElement vendorLink;

    @FindBy(xpath="(//*[starts-with(text(),' Create')])[2]")
    WebElement createVendorLink;

    @FindBy(xpath="//span[contains(text(),'Y001, 3rd Party Vendor')]")
    WebElement vendorOption;

    @FindBy(xpath="//*[@class='glyphicon glyphicon-forward']")
    WebElement submitOption;

    @FindBy(xpath="//a[contains(text(),'My Tasks')]")
    WebElement myTasks;

    public void clickVendorLink() {
        clickOnElement(vendorLink);
    }

    public void clickMyTasksLink() {
        clickOnElement(myTasks);
    }

    public void clickCreateVendorLink() {
        clickOnElement(createVendorLink);
    }

    public void selectVendorOption(){
        clickOnElement(vendorOption);
    }

    public void submitOption(){
       clickOnElement(submitOption);
    }

    public void selectVendorOptionToCreate() {
        mouseHoverJScript(vendorLink);
        clickVendorLink();
        clickCreateVendorLink();
        selectVendorOption();
        submitOption();
    }



}
