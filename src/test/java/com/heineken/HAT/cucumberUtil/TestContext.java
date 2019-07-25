package com.heineken.HAT.cucumberUtil;

import com.heineken.HAT.core.config.WebDriverSession;
import com.heineken.HAT.pageObjects.PageObjectManager;

public class TestContext {
 private WebDriverSession webDriverSession;
 private PageObjectManager pageObjectManager;
 public ScenarioContext scenarioContext;
 
 public TestContext(){
     webDriverSession = new WebDriverSession();
     pageObjectManager = new PageObjectManager(webDriverSession.getDriver());
     scenarioContext = new ScenarioContext();
 }
 
 public WebDriverSession getWebDriverSession() {
  return webDriverSession;
 }
 
 public PageObjectManager getPageObjectManager() {
 return pageObjectManager;
 }

 public ScenarioContext getScenarioContext() {
   return scenarioContext;
 }

}