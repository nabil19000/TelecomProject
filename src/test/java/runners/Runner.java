package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/AddCustomerModule.feature",
        glue = "stepDefinition",
        tags = "@Test1",
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html: target/reports/cucumber.html",
                "json: target/reports/cucumber.json"


        }
)

public class Runner {
}
