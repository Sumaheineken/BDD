package com.heineken.HAT.stepDefinitions.MasterData;

import com.heineken.HAT.core.enumManage.TestDataContext;
import com.heineken.HAT.cucumberUtil.TestContext;
import com.heineken.HAT.cucumberUtil.TestContextManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


/**
 * Created by mohana on 5/15/2019.
 */
public class SampleReferenceStepDefs extends TestContextManager{

    public SampleReferenceStepDefs(TestContext context){
        super(context);
    }

    @Given("^Sample Step Def$")
    public void login_as_LDR_Vendor(){
        loginPage.login("MDVM_BE01_LDR", "Heineken01");
        String request_ID="MDVM_BE01_LDR";
        testContext.scenarioContext.setContext(TestDataContext.REQUEST_ID,request_ID);
    }

    @When("Next Step")
    public void next_step(){
        String request_id= (String) testContext.scenarioContext.getContext(TestDataContext.REQUEST_ID);

    }


}
