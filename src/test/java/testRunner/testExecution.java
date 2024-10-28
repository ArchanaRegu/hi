package testRunner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/featureFiles",
glue={"stepDefinition"},
monochrome=true,
tags= "@Login or @Loginb or @Dashboard or @Logout",
plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})
public class testExecution extends AbstractTestNGCucumberTests {
/*@Override
@DataProvider(parallel=true)
public Object[][] scenarios(){
	return super.scenarios();
}*/

}

