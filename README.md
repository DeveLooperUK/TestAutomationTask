# TestAutomationTask

Selenium-Cucumber-Java
This repository contains a collection of sample selenium-cucumber-java projects and libraries that demonstrate how to use the tool and develop automation scripts using the Cucumber BDD framework with Java as a programming language. It automatically generates Surfire, Cucumber, HTML and JSON reporters as well. It also generates screenshots for your tests if you enable it and also generates error shots for your failed test cases as well.

Installation (pre-requisites)
JDK 1.8+ (make sure Java class path is set)
Maven (make sure .m2 class path is set)
IntelliJ/Eclipse
IntelliJ/Eclipse Plugins for
Maven
Cucumber
Git

Framework set up
Fork / Clone repository from here or download zip and set it up in your local workspace.

Framework Overview

The cucumber BDD testing framework specifies acceptance tests as written from the view of the Product Owner. Using keywords such as Given, When, Then and And, acceptance criteria tests known as feature files can then be broken down into testable steps. Cucumber Selenium framework runs by specifying the test cases using tags that are to be run.
Cucumber Selenium - Overall test framework leveraging the Cucumber framework with Selenium written in JAVA.
pom.xml file - It is used to download and upload libraries and tools using dependencies and builds that you will need in the framework.
Feature File - The feature file specifies the steps in the BDD language style.
Hooks class - Hooks class is the most important class as it performs the following functions.
Step Definition Feature File - Java class whereby the steps from the feature file are broken down to be coded into automation tests.
Feature Model Class - Java class whereby the step definition calls on methods that require action from the automated user such as entering text, finding/asserting fields on the UI
Feature Page Object Class - Java class whereby the necessary HTML objects are captured as WebElements to be manipulated by the associated model class
ChromeDriver.exe - Local chrome driver necessary in order
Cucumber Reports - Cucumber has a built-in report generation whereby Feature files tested are automatically written to Cucumber’s own reporting system
Utilities- Utilities package may consist of UI/Database/API/Excel/MS Office/Driver/ConfigReader utility classes including testing methods that are used often in Singleton Model.
Configuration Reader - CR class reads the properties file Configuration.properties.
Configuration.properties - It is used to manage credentials and access points that are used in Singleton Model



Run Some Sample Tests
Open terminal (MAC OSX) or command prompt / power shell (for windows OS) and navigate to the project directory type mvn verify or mvn test command to run features. With this command, it will invoke the default Chrome browser and will execute the tests.

To run features on the specific browser to be used, mvn verify "-Dbrowser=browser_name" browser_name can be one of the following but make sure that the browser‚  driver file is present and specified in the system variable. -- firefox -- chrome -- ie -- safari etc.
Please note that browser drivers are not included as part of this framework. The reason for not including is that Selenium browser driver versions are varies based on the browser version that you are using and also the Selenium server version.

To run specific feature if you have multiple feature files use, mvn test -Dcucumber.options="classpath:features/my_first.feature"

Reporters
Once you run your tests, the framework generates the various types of reports taking screenshots of failures and errors automatically. This framework selenium-cucumber-java uses several different types of test reporters to communicate pass/failure.

Cucumber Report: 
    


HTML Report:

 

JSON Report:

 








Developed automation scripts using the BDD approach

Tests are written in the Cucumber framework using the Gherkin Syntax. More about Gherkin & Cucumber can be found at https://cucumber.io/docs/reference A typical test will look similar to this:

Feature: Performing a Yahoo Search

    As a user on the Yahoo search page
    I want to search for Selenium-Webdriver
    Because I want to learn more about it

    Background:

        Given I am on the search page

    Scenario: Performing a search operation
        When I enter "Selenium Webdriver" into the search box
        And  I click the search button
        Then I should see a list of search results

    Scenario Outline: Performing a search operation with passing test data as data table
        When I enter <searchItem> into the search box
        And  I click the search button
        Then I should see a list of search results

        Examples:
        |searchItem|
        |"Selenium Webdriver"|

The Page Object Design Pattern
Within your Web App's UI there are areas that your tests interact. A Page Object simply models these as objects within the test code. This reduces the amount of duplicated code and means that if the UI changes, the fix need only be applied in one place. In other wards, one of the challenges of writing test automation is keeping your [selectors] ( classes, id's, or xpath' etc.) up to date with the latest version of your code. The next challenge is to keep the code you write nice and DRY (Don't Repeat Yourself). The page object pattern helps us accomplish this in one solution. Instead of including our selectors in our step definitions(in Cucumber) we instead place them in a .java file where we can manage all these selectors and methods together. Your test file should only call the test methods.

You can also place reusable methods or logic inside of these pages and call them from your step definitions java files. The page object serves as a layer of abstraction between tests and code. When A test fails, it fails on an individual step. That step may call a selector that is no longer valid, but that selector may be used by many other steps. By having a single source of truth of what the selector is supposed to be, fixing one selector on the page object could repair a number of failing tests that were affected by the same selector.

Contribution
Create a fork of the project into your own repository. Make all your necessary changes and create a pull request with a description on what was added or removed and details explaining the changes in lines of code. If approved, project owners will merge it.

Licensing
MIT
![image](https://user-images.githubusercontent.com/57773219/169663491-2f6baffd-ce43-4282-8694-89ad948d79ea.png)
