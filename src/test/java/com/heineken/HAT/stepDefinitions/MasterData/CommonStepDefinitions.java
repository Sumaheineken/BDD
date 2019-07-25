package com.heineken.HAT.stepDefinitions.MasterData;

import com.heineken.HAT.cucumberUtil.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by mohana on 5/15/2019.
 */
public class CommonStepDefinitions {

    TestContext testContext;
    public CommonStepDefinitions(TestContext context){
        testContext=context;
    }

    @Before
    public void beforeScenario(){

    }

    @After
    public  void afterScenario(){
        testContext.getWebDriverSession().quitDriver();
    }

}
