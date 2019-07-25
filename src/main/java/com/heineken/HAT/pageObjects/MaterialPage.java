package com.heineken.HAT.pageObjects;

import com.heineken.HAT.core.config.GlobalConstants;
import com.heineken.HAT.core.enumManage.TestDataContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by mohana on 5/15/2019.
 */
public class MaterialPage extends BasePage{

    public MaterialPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Materials')]")
    WebElement materialLink;

    @FindBy(xpath = "(//*[starts-with(text(),' Create')])[1]")
    WebElement btnMaterialCreate;

    @FindBy(xpath = "//*[@class='glyphicon glyphicon-forward']")
    WebElement btnCreateConfirm;

    @FindBy(how = How.XPATH, using = "//*[text()='Disable Local Request']")
    WebElement btnDisableLocalRequest;

    @FindBy(how = How.XPATH, using = "//*[text()='My record is not a duplicate! Submit.']")
    WebElement btnDuplicateSubmit;

    @FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-copy']")
    WebElement duplicateBtn;

    @FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-check']")
    WebElement validateDuplicate;

    @FindBy(how = How.XPATH, using = "//*[text()='Local Data']")
    WebElement textLocalData;

    @FindBy(how = How.XPATH, using = "//*[text()='Global Data']")
    WebElement textGlobalData;

    @FindBy(how = How.XPATH, using = ".//*[@class='glyphicon glyphicon-flash']")
    WebElement btnLocalActions;

    @FindBy(how = How.XPATH, using = "//*[text()='Proceed']")
    WebElement btnProceed;

    @FindBy(how = How.XPATH, using = "(.//*[@class='glyphicon glyphicon-edit'])[1]")
    WebElement btnEditDesc;

    @FindBy(how = How.XPATH, using = ".//*[text()='Material Description per Language']/../../div[2]//*[text()='Description']/../div/input")
    WebElement txtBoxDesc;

    @FindBy(how = How.CSS, using = "button[id^='mxui_widget_ActionButton'][class='btn mx-button mx-name-actionButton1 editableByCondition btn-success']")
    WebElement btnMaterialDescSave;

    @FindBy(how = How.XPATH, using = "//*[text()='Material Group']/../div/button/span")
    WebElement btnMaterialGrpselection;

    @FindBy(how = How.XPATH, using = ".//*[@id='mxui_widget_SearchInput_0']/div[2]/input")
    WebElement txtboxMaterialGrpSearch;

    @FindBy(how = How.XPATH, using = "//*[text()='Gross Weight Base UoM']/../div/input")
    WebElement txtBoxGrossWeightUOM;

    @FindBy(how = How.XPATH, using = "//*[text()='Unit of Weight']/../div/button/span")
    WebElement btnUnitofWeight;

    @FindBy(how = How.XPATH, using = "//label[text()='Commercial Unit']/../../div[2]/input")
    WebElement txtboxUnitofWeightInput;

    @FindBy(how = How.XPATH, using = "//button[text()='Search']")
    WebElement btnUnitofWeightSearch;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Display value')]/../../../../../../table[2]/tbody/tr[1]/td/div")
    WebElement txtUnitofWeightDisplay;

    @FindBy(how = How.XPATH, using = ".//button[text()='Select']")
    WebElement btnUnitofWeightSelect;

    @FindBy(how = How.XPATH, using = "//*[text()='Base UoM']/../div/button/span")
    WebElement btnBaseUOMSelection;

    @FindBy(how = How.XPATH, using = "//label[text()='Commercial Unit']/../../div[2]/input")
    WebElement txtboxBaseUOM;

    @FindBy(how = How.XPATH, using = "//button[text()='Search']")
    WebElement btnSearch;

    @FindBy(xpath = "(//div[contains(text(),'CMG')]/../../../../../../table[2]/tbody/tr[1]/td/div)[1]")
    WebElement txtCMGSelect;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Display value')]/../../../../../../table[2]/tbody/tr[1]/td/div")
    WebElement txtBaseUOMDisplay;

    @FindBy(how = How.XPATH, using = "(//*[text()='Select'])[1]")
    WebElement btnBaseUOMSelect;

    @FindBy(how = How.XPATH, using = "//*[text()='Net Weight Base UoM']/../div/input")
    WebElement txtboxNetWeight;

    @FindBy(how = How.XPATH, using = "//*[text()='UoM - Primary']/../div[1]/div/select")
    WebElement slctUOMPrimary;

    @FindBy(how = How.XPATH, using = "//*[text()='Validate']")
    WebElement btnValidate;

    @FindBy(how = How.XPATH, using = "//*[text()='Duplicate Check']")
    WebElement btnDuplicateCheck;

    @FindBy(how = How.XPATH, using = ".//*[text()='Open Record']")
    WebElement btnOpenRecord;

    @FindBy(how = How.XPATH, using = ".//*[text()='Extend Selected']")
    WebElement btnExtendSelected;

    @FindBy(how = How.XPATH, using = "//*[text()='Export to Excel']")
    WebElement btnExportToExcel;

    @FindBy(how = How.XPATH, using = "//*[text()='My record is not a duplicate! Submit.']")
    WebElement btnMyRecordNotDuplicate;

    @FindBy(how = How.XPATH, using = ".//*[text()='Request complies to all Validations']")
    WebElement txtValidationMsg;

    @FindBy(how = How.XPATH, using = ".//button[text()='Submit Global Request']")
    WebElement btnGlobalRequest;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Process Information')]")
    WebElement menuProcessInfo;

    @FindBy(how = How.XPATH, using = "(//*[starts-with(text(),' Process Search')])[1]")
    WebElement menuProcessInfoSearch;

    @FindBy(how = How.CSS, using = ".btn.btn-primary")
    WebElement btnMsgReqIdOk;

    @FindBy(how = How.XPATH, using = "//*[@class='close mx-dialog-close']")
    WebElement btnClose;

    @FindBy(how = How.XPATH, using = "//*[@class='glyphicon glyphicon-refresh']")
    WebElement btnReqIDClear;

    @FindBy(how = How.XPATH, using = "(//*[text()='State'])[2]/../../../../../../table[2]//td[9]")
    WebElement txtStatus;

    @FindBy(how = How.XPATH, using = "(//*[@class='mx-dateinput-input-wrapper'])[1]")
    WebElement txtboxRequestedDate;

    @FindBy(how = How.XPATH, using = "//*[@class='form-control mx-dateinput-input']")
    WebElement txtBoxRequestedStrtDate;

    @FindBy(how=How.XPATH, using="//span[contains(text(),'Request ID')]/following::input[1]")
    WebElement txtboxRequestId;

    @FindBy(how=How.XPATH, using=".//*[@class='glyphicon glyphicon-search']")
    WebElement reqIDSearch;

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

    @FindBy(how = How.XPATH, using = "//*[text()='Reject Global Request']")
    WebElement btnRejectAction;

    @FindBy(how = How.CSS, using = ".glyphicon.glyphicon-ok")
    WebElement btnGDAApproval;

    @FindBy(how = How.CSS, using = "glyphicon glyphicon-save")
    WebElement btnGlobalRequestSubmit;

    @FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-saved']")
    WebElement btnSavingAsDraft;

    @FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-ban-circle']")
    WebElement btnDiscardCreate;

    @FindBy(how = How.XPATH, using = "//*[text()='OK']")
    WebElement btnOK;

    @FindBys(@FindBy(xpath = ".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr/td[10]"))
    List<WebElement> txtStates;

    @FindBy(how = How.CSS, using = ".modal-body.mx-dialog-body>p")
    WebElement txtDialogBox;

    public void clickOnMaterialCreate()
    {
        waitForElementPresent(materialLink);
        clickOnElement(materialLink);
        clickOnElement(btnMaterialCreate);
    }

    public void selectQuestionareAndStartCreate(String questionare)
    {
        waitForElementPresent(btnCreateConfirm);
        clickOnElement(driver.findElement(By.xpath("//*[contains(text(),'"+questionare+"')]")));
    }

    public void clickConfirmCreate()
    {
        scrollUp();
        jsClick(btnCreateConfirm);
    }

    public void switchToLocalData()
    {
        waitForElementPresent(textLocalData);
        jsClick(textLocalData);
    }

    public void switchToGlobalData()
    {
        waitForElementPresent(textGlobalData);
        jsClick(textGlobalData);
    }

    public void clickLocalActionButton()
    {
        waitForElementClickable(btnLocalActions);
        clickOnElement(btnLocalActions);
    }

    public void disableLocalData()
    {
        switchToLocalData();
        clickLocalActionButton();
        jsClick(btnDisableLocalRequest);
        clickOnElement(btnProceed);
    }

    public void enterDescription(String description) {
        waitForElementClickable(btnEditDesc);
        jsClick(btnEditDesc);
        waitForElementClickable(txtBoxDesc);
        mouseClick(txtBoxDesc);
        enterValueOnElement(txtBoxDesc, description);
        jsClick(btnMaterialDescSave);
    }

    public void enterMaterialGroup(String materialgroup) {
        scrollUp();
        jsClick(btnMaterialGrpselection);
        waitForElementPresent(txtboxMaterialGrpSearch);
        clickOnElement(txtboxMaterialGrpSearch);
        clearOnElement(txtboxMaterialGrpSearch);
        enterValueOnElement(txtboxMaterialGrpSearch, materialgroup);
        clickOnElement(btnSearch);
        clickOnElement(txtCMGSelect);
        clickOnElement(btnUnitofWeightSelect);
    }

    public void grossWeightEntestTest(String grossUomValue) {
        clickOnElement(txtBoxGrossWeightUOM);
        clearOnElement(txtBoxGrossWeightUOM);
        enterValueOnElement(txtBoxGrossWeightUOM, grossUomValue);
    }

    public void unitOfWeightSelectionTest(String unitofWeight){

        clickOnElement(btnUnitofWeight);
        waitForElementPresent(txtboxUnitofWeightInput);
        clickOnElement(txtboxUnitofWeightInput);
        enterValueOnElement(txtboxUnitofWeightInput, unitofWeight);
        clickOnElement(btnSearch);
        clickOnElement(driver.findElement(By.xpath("//*[text()='"+unitofWeight+"']")));
        clickOnElement(btnBaseUOMSelect);
    }

    public void baseUOMSelectionTest(String baseUom)
    {
        scrollUp();
        waitForElementPresent(btnBaseUOMSelection);
        clickOnElement(btnBaseUOMSelection);
        enterValueOnElement(txtboxBaseUOM, baseUom);
        clickOnElement(btnSearch);
        clickOnElement(driver.findElement(By.xpath("//*[text()='"+baseUom+"']")));
        clickOnElement(btnBaseUOMSelect);
    }

    public void netWeightEnterTest(String netWeightBaseUoM)
    {
        waitForElementPresent(txtboxNetWeight);
        clickOnElement(txtboxNetWeight);
        clearOnElement(txtboxNetWeight);
        enterValueOnElement(txtboxNetWeight, netWeightBaseUoM);
    }

    public void uomPrimarySelectionTest() {
        waitForElementPresent(slctUOMPrimary);
        selectByIndex(slctUOMPrimary, 1);
    }

    public void validateTestCreate()
    {
        clickOnElement(btnValidate);
    }

    public void duplicateCheckButton() {
        waitForElementClickable(txtValidationMsg);
        clickOnElement(duplicateBtn);
    }

    public void clickDuplicateCheck() throws InterruptedException {
        waitForSeconds(GlobalConstants.WAIT_THREE_SECOND);
        if(driver.findElements(By.xpath(".//*[text()='Open Record']")).size()>0)
        {
            setPosition();
            btnOpenRecord.sendKeys(Keys.TAB);
            btnExtendSelected.sendKeys(Keys.TAB);
            btnExportToExcel.sendKeys(Keys.TAB);
            btnMyRecordNotDuplicate.sendKeys(Keys.RETURN);
            clickOnElement(btnProceed);
            maximizeWindow();
        }
        else if(isElementPresent(btnClose)){
            clickCloseButtonToPopUp();
            submitGlobalRequestTest();
        }
    }

    public void submitGlobalRequestTest() {
        waitForElementPresent(txtValidationMsg);
        clickOnElement(btnGlobalRequest);
    }

    public void processInfoSearch(String requestId) {
        waitForElementClickable(menuProcessInfo);
        jsClick(menuProcessInfo);
        jsClick(menuProcessInfoSearch);
        waitForElementClickable(txtboxRequestId);
        clickOnElement(txtboxRequestId);
        enterValueOnElement(txtboxRequestId, requestId);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateFormatted = dateFormat.format(date);
        enterValueOnElement(txtBoxRequestedStrtDate, dateFormatted);
        clickOnElement(reqIDSearch);
    }

    public void SaveAsDraft()  {
        waitForElementPresent(txtValidationMsg);
        clickOnElement(btnSavingAsDraft);
    }

    public void submitRequestOkBtnClick() {
        waitForElementClickable(btnMsgReqIdOk);
        mouseClick(btnMsgReqIdOk);
    }

    public void clickCloseButtonToPopUp() {
        waitForElementClickable(btnClose);
        jsClick(btnClose);
    }

    public void getState()
    {
        waitForSeconds(10);
        List<WebElement> states = txtStates;
        for (WebElement state:states) {
            System.out.println();
            System.out.println("Request Id status details " + state.getText());
        }
    }

    public void discardCreateLDR() {
        clickOnElement(btnDiscardCreate);
    }

    public void discardCreateGDA() {
        clickOnElement(btnDiscardCreate);
        jsClick(btnProceed);
        clickOnElement(btnOK);
    }

    public void reqIdSearchMyTasks(String requestId)
    {
        waitForElementClickable(menuMyTask);
        jsClick(menuMyTask);
        waitForElementPresent(btnReqIdMyTaskSearch);
        jsClick(btnReqIdMyTaskSearch);
        clickOnElement(txtboxReqIdSearch);
        enterValueOnElement(txtboxReqIdSearch,requestId);
        waitForElementPresent(btnReqIdEnterSearch);
        clickOnElement(btnReqIdEnterSearch);
        waitForElementPresent(btnOpenTask);
        clickOnElement(btnOpenTask);
    }

    public String getRequestId(){
        waitForElementPresent(txtDialogBox);
        String reqId=txtDialogBox.getText();
        String[] parts = reqId.split(" ");
        String id = parts[2];
        return id;
    }

    public String getRequestId_SaveAsDraft_SAP(){
        waitForElementPresent(txtDialogBox);
        String reqId=txtDialogBox.getText();
        String[] parts = reqId.split(" ");
        String id = parts[parts.length-1];
        String idNum = id.replaceAll("\\.", "");
        return idNum;
    }

}


