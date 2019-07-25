package com.heineken.HAT.cucumberUtil;

import com.heineken.HAT.core.enumManage.TestDataContext;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by mohana on 5/30/2019.
 */
public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(TestDataContext key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(TestDataContext key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(TestDataContext key){
        return scenarioContext.containsKey(key.toString());
    }

}
