package com.heineken.HAT.pageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by mohana on 5/17/2019.
 */
public class PageObjectManager {

    private WebDriver driver;

    private LoginPage loginPage;

    private MaterialPage materialPage;

    private CreateVendorPage createVendorPage;

    private CreateVendorRequestPage createVendorRequestPage;

    private SampleReferencePage sampleReferencePage;

    private GDAApprovalPage gdaApprovalPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? new LoginPage(driver) : loginPage;
    }

    public CreateVendorPage getCreateVendorPage() {
        return (createVendorPage == null) ? new CreateVendorPage(driver) : createVendorPage;
    }

    public CreateVendorRequestPage getCreateVendorRequestPage() {
        return (createVendorRequestPage == null) ? new CreateVendorRequestPage(driver) : createVendorRequestPage;
    }

    public SampleReferencePage getSampleReferencePage() {
        return (sampleReferencePage == null) ? new SampleReferencePage(driver) : sampleReferencePage;
    }

    public MaterialPage getMaterialPage()
    {
        return (materialPage == null) ? new MaterialPage(driver) : materialPage;
    }

    public GDAApprovalPage getGdaApprovalPage()
    {
        return (gdaApprovalPage == null) ? new GDAApprovalPage(driver) : gdaApprovalPage;
    }

}
