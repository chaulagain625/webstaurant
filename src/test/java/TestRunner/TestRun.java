package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/Resources/Features/SearchingDemo.feature",
        glue = "StepDefinitions",
        dryRun = false,
        monochrome = true,
        tags="@test",
        plugin={"pretty","html:target/cucumber-default-report.html","json:target/cucumber.json","rerun:target/failed.txt"}
)
public class TestRun {
}
