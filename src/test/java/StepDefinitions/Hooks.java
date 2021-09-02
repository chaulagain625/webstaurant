package StepDefinitions;

import Utilities.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {

    /**
     * For lunching browser and always run before any scenario and even before any background.
     */
    @Before
    public  void launchBrowser(){
        setUp();
    }

    /**
     * For closing browser after the test case has been done.
     * This method will be always execute does not depends on fail or pass of the scenario.
     */
    @After
    public void end(Scenario scenario){
        byte[]pic;
        if(scenario.isFailed()){
            pic=takeScreenshot("failed/"+ scenario.getName());
        }else{
            pic=takeScreenshot("passed/"+ scenario.getName());
        }
        scenario.attach(pic,"image/png",scenario.getName());

        tearDown();
    }
}
