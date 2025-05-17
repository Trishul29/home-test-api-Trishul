package CukeTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Inventory.feature",
        glue = {"src/test/java/StepDefination"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report",
                "json:target/cucumber-reports/report.json",
                "junit:target/cucumber-reports/report.xml"
        },
        monochrome = true,
        publish = false,
        dryRun = false
)

public class TestRunner {


}


