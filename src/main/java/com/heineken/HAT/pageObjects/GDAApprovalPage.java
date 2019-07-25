package com.heineken.HAT.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

 public class GDAApprovalPage extends BasePage{

        public GDAApprovalPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(how = How.XPATH, using = "//*[text()='OK']")
        WebElement btnOK;

        @FindBy(how = How.XPATH, using = ".//*[text()='Open Record']")
        WebElement btnOpenRecord;

        @FindBy(how = How.XPATH, using = ".//*[text()='Extend Selected']")
        WebElement btnExtendSelected;

        @FindBy(how = How.XPATH, using = "//*[text()='Export to Excel']")
        WebElement btnExportToExcel;

        @FindBy(how = How.XPATH, using = "//*[text()='Confirm and Approve']")
        WebElement btnConfirmAndApprove;

        @FindBy(how = How.XPATH, using = "//*[text()='Proceed']")
        WebElement btnProceed;

        @FindBy(how = How.XPATH, using = ".//*[text()='Request complies to all Validations']")
        WebElement txtValidationMsg;

        @FindBy(how = How.XPATH, using = ".//button[text()='Submit Global Request']")
        WebElement btnGlobalRequest;

        @FindBy(how = How.XPATH, using = "//*[text()='Reject Global Request']")
        WebElement btnRejectGlobalRequest;

        @FindBy(how = How.XPATH, using = "//a[contains(text(),'Process Information')]")
        WebElement menuProcessInfo;

        @FindBy(how = How.CSS, using = ".btn.btn-primary")
        WebElement btnMsgReqIdOk;

        @FindBy(how = How.XPATH, using = "//a[text()=' My Tasks']")
        WebElement menuMyTask;

        @FindBy(how = How.XPATH, using = ".//*[text()='Search']")
        WebElement btnReqIdMyTaskSearch;

        @FindBy(how = How.XPATH, using = "//label[text()='Request ID']/../../div[2]/input")
        WebElement txtboxReqIdSearch;

        @FindBy(how = How.XPATH, using = "(.//button[text()='Search'])[1]")
        WebElement btnReqIdEnterSearch;

        @FindBy(how = How.XPATH, using = ".//button[text()='Open Task']")
        WebElement btnOpenTask;

        @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-flash']")
        WebElement btnlocalAction;

        @FindBy(how = How.XPATH, using = "(.//*[text()='Comments'])/../div/div[2]/div[2]/button[1]")
        WebElement clickCommentsNew;

        @FindBy(how = How.XPATH, using = "//*[text()='Save']")
        WebElement btnSave;

        @FindBy(how = How.XPATH, using = "((.//*[text()='Edit Comments'])/../../div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/textarea)")
        WebElement textComment;

        @FindBy(how = How.XPATH, using = "//*[text()='Validate and Duplicate Check']")
        WebElement btnValidateDuplicateCheck;

        @FindBy(how = How.XPATH, using = "//*[@class='close mx-dialog-close']")
        WebElement btnClose;

        @FindBy(how = How.XPATH, using = ".//button[text()='Approve Global Request']")
        WebElement btnApproveGlobalRequest;

        public void validateAndDuplicateCheckButton() {
            clickOnElement(btnValidateDuplicateCheck);
        }

        public void clickDuplicateCheck_GDA() throws InterruptedException {
            Thread.sleep(3000);
            if(driver.findElements(By.xpath(".//*[text()='Open Record']")).size()>0)
            {
                setPosition();
                btnOpenRecord.sendKeys(Keys.TAB);
                btnExportToExcel.sendKeys(Keys.TAB);
                btnConfirmAndApprove.sendKeys(Keys.RETURN);
                clickOnElement(btnProceed);
                maximizeWindow();
            }
            else if(isElementPresent(btnClose)){
                clickCloseButtonToPopUp();
                approvalBtnClick();
            }

        }

        public void approvalBtnClick() {
            waitForElementClickable(btnApproveGlobalRequest);
            jsClick(btnApproveGlobalRequest);
        }

        public void clickCloseButtonToPopUp() {
            waitForElementClickable(btnClose);
            jsClick(btnClose);
        }


        public void rejectGDA() {
            scrollUp();
            clickOnElement(clickCommentsNew);
            enterValueOnElement(textComment, "Data Reject");
            clickOnElement(btnSave);
            clickOnElement(btnlocalAction);
            clickOnElement(btnRejectGlobalRequest);
            clickOnElement(btnOK);
        }
}
