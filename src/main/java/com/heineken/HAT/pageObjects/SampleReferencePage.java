package com.heineken.HAT.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mohana on 5/31/2019.
 */
public class SampleReferencePage extends BasePage{

    public SampleReferencePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="usernameInput")
    WebElement txtUsername;

    @FindBy(id="passwordInput")
    WebElement txtPassword;

    @FindBy(id="loginButton")
    WebElement loginButton;

    public void enterUserName(String userName) {
          enterValueOnElement(txtUsername,userName);
    }

    public void enterPassword(String psw) {
        enterValueOnElement(txtPassword,psw);
    }

    public void clickLoginButton(){
        clickOnElement(loginButton);
    }

    public void login(String userName,String psw){
        enterUserName(userName);
        enterPassword(psw);
        clickLoginButton();
    }

}
