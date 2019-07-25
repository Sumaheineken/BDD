package com.heineken.HAT.stepDefinitions.MasterData.Material;

import com.heineken.HAT.core.enumManage.TestDataContext;
import com.heineken.HAT.cucumberUtil.TestContext;
import com.heineken.HAT.cucumberUtil.TestContextManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateMaterialSAPStepDef extends TestContextManager {


    public CreateMaterialSAPStepDef(TestContext context){
        super(context);
    }

    @Given("^User logged in as Local Data Requester (.+)$")
    public void user_logged_in_as_local_data_requester(String mdmmopcosldr) throws Throwable {
        loginPage.login(mdmmopcosldr, "Heineken01");
    }

    @When("^User wants to create material for material type \"([^\"]*)\" in SAP$")
    public void user_wants_to_create_material_for_material_type_something_in_sap(String questionare) throws Throwable {
        materialPage.clickOnMaterialCreate();
        materialPage.selectQuestionareAndStartCreate(questionare);
        materialPage.clickConfirmCreate();

    }

    @Then("^Material should be created for material type in SAP$")
    public void material_should_be_created_for_material_type_in_sap() throws Throwable {
        materialPage.disableLocalData();
        materialPage.enterDescription("Test Data with Automation");
        materialPage.enterMaterialGroup("CMG0472");
        materialPage.grossWeightEntestTest("200");
        materialPage.unitOfWeightSelectionTest("G");
        materialPage.baseUOMSelectionTest("G");
        materialPage.netWeightEnterTest("200");
        materialPage.uomPrimarySelectionTest();
        materialPage.uomPrimarySelectionTest();
        materialPage.validateTestCreate();
        materialPage.duplicateCheckButton();
        materialPage.clickDuplicateCheck();
        String requestId = materialPage.getRequestId();
        testContext.scenarioContext.setContext(TestDataContext.REQUEST_ID,requestId);
        materialPage.clickCloseButtonToPopUp();
    }

    @Then("^User logged in as Global Data Administrator (.+)$")
    public void user_logged_in_as_global_data_administrator(String mdmgda) throws Throwable {
        loginPage.login(mdmgda, "Heineken01");
    }

    @And("^GDA review and approve the request$")
    public void gda_review_and_approve_the_request() throws Throwable {

        materialPage.reqIdSearchMyTasks((String) testContext.scenarioContext.getContext(TestDataContext.REQUEST_ID));
        materialPage.clickLocalActionButton();
        gdaApprovalPage.validateAndDuplicateCheckButton();
        gdaApprovalPage.clickDuplicateCheck_GDA();
        materialPage.clickCloseButtonToPopUp();
    }

    @And("^user perform process information check$")
    public void user_perform_process_information_check() throws Throwable {
        materialPage.processInfoSearch((String) testContext.scenarioContext.getContext(TestDataContext.REQUEST_ID));
        materialPage.getState();
        loginPage.logOut();
    }

    @Then("^Material should be saved as draft for material type in SAP$")
    public void material_should_be_saved_as_draft_for_material_type_in_sap() throws Throwable
    {
        materialPage.disableLocalData();
        materialPage.enterDescription("Test Data with Automation");
        materialPage.enterMaterialGroup("CMG0472");
        materialPage.grossWeightEntestTest("200");
        materialPage.unitOfWeightSelectionTest("G");
        materialPage.baseUOMSelectionTest("G");
        materialPage.netWeightEnterTest("200");
        materialPage.uomPrimarySelectionTest();
        materialPage.uomPrimarySelectionTest();
        materialPage.validateTestCreate();
        materialPage.SaveAsDraft();
        String requestId = materialPage.getRequestId_SaveAsDraft_SAP();
        testContext.scenarioContext.setContext(TestDataContext.REQUEST_ID,requestId);
        materialPage.clickCloseButtonToPopUp();
    }

    @Then("^LDR logged in with (.+) and submit the saved draft material$")
    public void ldr_logged_in_with_and_submit_the_saved_draft_material(String mdmmopcosldr) throws Throwable {

    }


    @Then("^LDR logged in with (.+) and resubmit the request$")
    public void ldr_logged_in_with_and_resubmit_the_request(String mdmmopcosldr) throws Throwable {
        loginPage.login(mdmmopcosldr, "Heineken01");
        materialPage.reqIdSearchMyTasks((String) testContext.scenarioContext.getContext(TestDataContext.REQUEST_ID));
        materialPage.clickLocalActionButton();
        materialPage.validateTestCreate();
        materialPage.duplicateCheckButton();
        materialPage.clickDuplicateCheck();
        materialPage.clickCloseButtonToPopUp();
    }


    @And("^GDA review and reject the request$")
    public void gda_review_and_reject_the_request() throws Throwable {

        materialPage.reqIdSearchMyTasks((String) testContext.scenarioContext.getContext(TestDataContext.REQUEST_ID));
        gdaApprovalPage.rejectGDA();
    }


    @Then("^LDR logged in with (.+) and discard the request$")
    public void ldr_logged_in_with_and_discard_the_request(String mdmmopcosldr) throws Throwable {
        loginPage.login(mdmmopcosldr, "Heineken01");
        materialPage.reqIdSearchMyTasks((String) testContext.scenarioContext.getContext(TestDataContext.REQUEST_ID));
        materialPage.clickLocalActionButton();
        materialPage.discardCreateLDR();
        materialPage.clickCloseButtonToPopUp();
    }
}
