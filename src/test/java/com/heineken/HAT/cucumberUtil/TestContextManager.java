package com.heineken.HAT.cucumberUtil;

/**
 * Created by mohana on 5/21/2019.
 */
import com.heineken.HAT.cucumberUtil.TestContext;
import com.heineken.HAT.pageObjects.*;

public class TestContextManager {

    public TestContext testContext;
    public LoginPage loginPage;
    public CreateVendorPage createVendorPage;
    public CreateVendorRequestPage createVendorRequestPage;
    public SampleReferencePage sampleReferencePage;
    public MaterialPage materialPage;
    public GDAApprovalPage gdaApprovalPage;

    public TestContextManager(TestContext context){
        testContext=context;
        loginPage=testContext.getPageObjectManager().getLoginPage();
        createVendorPage=testContext.getPageObjectManager().getCreateVendorPage();
        createVendorRequestPage=testContext.getPageObjectManager().getCreateVendorRequestPage();
        sampleReferencePage=testContext.getPageObjectManager().getSampleReferencePage();
        materialPage = testContext.getPageObjectManager().getMaterialPage();
        gdaApprovalPage = testContext.getPageObjectManager().getGdaApprovalPage();
    }

}
