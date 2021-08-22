# Test Automation Project

Acceptance test for http://www.xe.com/currencyconverter/
The Acceptance criteria is to test multiple conversion rates
The test should iterate over 5 sets of sample data.
Example iteration: 
The test should input from Euro to pounds.
Verify the result on the proceeding page.

In my Selenium test automation framework we use the following:
• Java as the programming language
• Page object model as a design pattern
• TestNG as the assertion framework
• Maven as the build tool
• RemoteWebDriver as the browser automation tool
• IntelliJ as the IDE


## Table of Contents

1. Development requirements
2. Configuring test project
3. Creating tests
4. Running tests 
5. Project structure

## 1. Development requirements

**Required:** Chrome browser, Chrome Driver(91.0.4472.19), Java Development Kit 15 (JDK11) and maven (3.6.3) should be present on environment in order to develop and/or run the tests.

## 2. Configuring test project

* Add this project as maven project
* Enable auto import for maven

## 3. Creating tests

The test cases are written in Java programming language. The implementation of feature file is written in 

## 4. Running tests
 
Run testng.xml file to execute all the test cases. The path is src\test\java\testbase\testng.xml
 

## 5. Project structure

src: It is the root directory of source code and test code.

1. main: This directory is the root directory of the source code related to the application itself, not test code.
	a. java: This directories under main and test contains the Java code for the application itself which is under main and the Java code for the test which is under test.
		i. Pages: This directory contains the collection of different page directories (Page 1, Page 2, .. Page n) of the application, where each page directory contains the source code and object repo classes related to that page.
			1. Page1.java: This class contains the source code related to the page1 in the application.
			2. Page1ObjectRepository.java: This class contains the collection of web elements/locators of the page1 in the application.

		ii. Utils: This directory contains the Java classes which can be used throughout the application. In this framework, Utils directory contains the following java classes.
			1. Base: This class contains the reusable methods. All page classes will extend this Base class thus inheriting all the base methods.
			2. InitiateDriver: This class is used to initiate the driver based on configuration setup.
			3. Object_Base: This is the base class for all the page object classes. All the page object classes will extend this object base class thus initializing the locators under it.
			4. PropertyReader: This class is to read the property files under resource folders.

		iii. Pages.java: This class contains all the page references. All the difference page will be accessed through this references.

	b. resources: This directory contains the resources needed by the project. For example, property files, excel sheets etc.

2. test: This directory contains the test source code.
	a. Test Pages: This directory contains the collection of different test page directories (Page1 Test, Page2 Test, .. Page n Test) of the application, where each test page directory contains the test source code related to that page.
		i. Page1 Test.java: This class contains the test source code related to the page1 in the application.

	b. TestBase.java: TestBase class take care of initializing the driver, loading configuration file and other reusable methods like screenshot and many more.

	c. testng.xml: This file is used to create and handle multiple test classes. This xml file is used to configure test run, set test dependency, include or exclude any test, method, class or package and set priority etc.


3. target: This directory is created by the Maven. It contains all the output of the build (compiled classes, JAR files, test report etc).

   Reporting (Allure Reporter): It is a HTML Reporter which displays all tests that are run, total tests executed, passed failed , skipped along with snapshots of failed test cases. Below you can find the snapshot of the report:

4. pom.xml: It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects.