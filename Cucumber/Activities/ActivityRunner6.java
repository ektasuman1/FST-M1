package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// For pretty 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SimpleAlert",
    plugin = {"pretty"},
    monochrome = true
)

  
  // For HTML
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinition"},
        tags = "@SimpleAlert",
        plugin = {"html: test-reports-html"},
        monochrome = true
)

  // For json
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SimpleAlert",
    plugin = {"json: test-reports/json-report.json"},
    monochrome = true
)

public class ActivitiesRunner {}

public class ActivitiesRunner6 {
    //This is intentionally blank
}


