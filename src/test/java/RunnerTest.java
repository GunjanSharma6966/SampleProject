import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"features"}
            ,glue= {"stepdefinition"}
            ,tags = {"@tests"}
    )

    public class RunnerTest {

    }

