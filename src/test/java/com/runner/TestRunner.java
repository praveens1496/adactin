package com.runner;

import org.junit.runner.RunWith;

import com.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = SnippetType.CAMELCASE, tags = "@Login", features = {
		"src\\test\\resources" }, glue = { "com.stepdefinition" }, dryRun = false)
public class TestRunner {

	public void afterclass() {
		Reporting.generateJVMreport(System.getProperty("user.div") + "\\target\\cucumber.json");
	}
}
