package TestRunner;


import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;


import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
		features = "Features",
		glue = {"stepDefinitons"},
		tags = {"@test"}
		)
public class RunCukesTest{

}