package com.report;

import java.io.File;
import java.util.ArrayList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJVMreport(String jsonfile) {
		File file = new File(System.getProperty("user.dir") + "\\target");
		Configuration config = new Configuration(file, "Adactin Automation");
		config.addClassifications("OS", "Win11");
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Version", "103");
		config.addClassifications("Sprint", "33");

		java.util.List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonfile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, config);
		builder.generateReports();

	}

}
