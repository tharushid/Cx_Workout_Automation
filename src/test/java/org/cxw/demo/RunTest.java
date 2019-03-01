package org.cxw.demo;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "html:target/cucumber-html-report/report.html", "json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt","junit:target/cucumber-results.xml" }, features = { "./src/resources/testcase"}, 
		 glue = {"org.cxw.demo"} ,tags = {"@create_project   "})

  



public class RunTest {

	
	
}
