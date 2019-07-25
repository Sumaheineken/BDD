package com.heineken.HAT.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mohana on 5/15/2019.
 */
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="usernameInput")
    WebElement txtUsername;

    @FindBy(id="passwordInput")
    WebElement txtPassword;

    @FindBy(id="loginButton")
    WebElement loginButton;

    @FindBy(xpath = "//*[@class = 'glyphicon glyphicon-log-out']")
    WebElement btnLogOut;

    public void enterUserName(String userName) {
          waitForElementClickable(txtUsername);
          enterValueOnElement(txtUsername,userName);
    }

    public void enterPassword(String psw) {
        waitForElementClickable(txtPassword);
        enterValueOnElement(txtPassword,psw);
    }

    public void clickLoginButton(){
        waitForElementClickable(loginButton);
        clickOnElement(loginButton);
    }

    public void login(String userName,String psw){
        enterUserName(userName);
        enterPassword(psw);
        clickLoginButton();
    }

    public void logOut()
    {
        clickOnElement(btnLogOut);
    }

}
