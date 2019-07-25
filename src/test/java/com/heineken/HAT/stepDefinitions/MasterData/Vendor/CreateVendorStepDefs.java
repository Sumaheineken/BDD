package com.heineken.HAT.stepDefinitions.MasterData.Vendor;

import com.heineken.HAT.core.enumManage.TestDataContext;
import com.heineken.HAT.cucumberUtil.TestContext;
import com.heineken.HAT.cucumberUtil.TestContextManager;
import com.heineken.HAT.pageObjects.CreateVendorPage;
import com.heineken.HAT.pageObjects.CreateVendorRequestPage;
import com.heineken.HAT.pageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


/**
 * Created by mohana on 5/15/2019.
 */
public class CreateVendorStepDefs extends TestContextManager{

    public CreateVendorStepDefs(TestContext context){
        super(context);
    }

    @Given("^Login as LDR Vendor$")
    public void login_as_LDR_Vendor(){
        loginPage.login("MDVM_BE01_LDR", "Heineken01");
        String userName="MDVM_BE01_LDR";
        testContext.scenarioContext.setContext(TestDataContext.REQUEST_ID,userName);
    }

    @Then("^select option to create vendor$")
    public void select_option_to_create_vendor() {
        createVendorPage.selectVendorOptionToCreate();
        System.out.println("RequestID "+testContext.scenarioContext.getContext(TestDataContext.REQUEST_ID));
    }

    @And("^disable local data$")
    public void disable_local_data() {
        createVendorRequestPage.clickLocalDataTab();
        createVendorRequestPage.clickFlashButton();
    }



}
