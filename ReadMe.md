
# Project Overview

This project is for Automated UI tests, which are written in Java with Selenium Web Driver.


### Prerequisites

1. Install IntelliJ https://www.jetbrains.com/idea/download/
2. Install Chrome

3. Install JDK 
a) Download JDK https://www.oracle.com/java/technologies/javase-downloads.html
b) Install downloaded executable file
c) in CMD run "java -version" in order to see if JDK is successfully installed

4. Visit Maven official website(http://maven.apache.org/download.cgi), download the Maven zip file
a) Add MAVEN_HOME system variable
b) Add %MAVEN_HOME%\bin To PATH
c) In CMD type "mvn –version" in order to see if Maven is successfully installed



## Running the tests

1. Open IntelliJ 
2. Open the project
3. IntelliJ will ask you to download all maven dependencies
3. In the terminal type "mvn clean test", if you want to run them on different env please use -D{PropertyName}={PropertyValue} to change it, or change it directly in the pom.xml

## Reports

###Allure Reports
1. Allure Reports can be generated from  : target/allure-reports
2. You will need to install Allure on your PC and start Allure server in order to be shown

###Extent Reports
1. Our main test reports will be Extent Reports and they can be found here: TestReports/ExtentReport.html
2. Surefire Reports can be found here : target/surefire-reports/AllTestSuite
a) JUnit test reports can be found here: target/surefire-reports/junitreports
b) Additional reports can be found in : target/surefire-reports/index.html



## Built With

* Maven
* Selenium
* TestNG
* Junit (only for assertions)
* Surefire
* ExtentReports


## Authors

Ivan Todorovski


## Thank you for reading! 

