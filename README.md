## Introduction
The purpose of this repository is to present the setup of effective UI test automation project having in mind environments where tests should be executed, operating system, browsers used and test suite organization.

## Stack
* Java - Jdk 1.8 
* Maven - Apache Maven 3.8.1
* Selenium Web Driver 3
* TestNG - 6.14.3
* Jenkins - 2.277.4

## Installation Guide

### Java
Java download link https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
To check installed java version type "java -version" in your terminal

![Java version](docs/images/JavaVersion.png)
For troubleshooting take a look at https://java.com/en/download/help/path.html

### Maven
Maven download link https://maven.apache.org/download.cgi
To check installed maven version type "mvn -v" in your terminal

![Maven version](docs/images/MavenVersion.png)
For troubleshooting take a look at https://www.baeldung.com/install-maven-on-windows-linux-mac

### Environment variable setup

#### Windows environment variable
![Environment variable Windows](docs/images/EnvironmentVariables1.gif)

#### Mac environment variable
Under /Users/username .bash_profile file should be created or edited if existing
````
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_291.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH
export M2_HOME=/Applications/apache-maven-3.8.1
export PATH=$PATH:$M2_HOME/bin
````

### Web Driver settings
Web drivers are given under /webDrivers folder and separated in mac and windows folder.

---
**NOTE**
 Driver version must match corresponding browser version on your system and webrivers given with this demo project may not match your browser versions (they should be checked and updated with the update of browser version).
---

### Jenkins
Jenkins download link https://www.jenkins.io/download/
In order to execute maven job at Maven Plugin manager page install maven integration plugin
![Maven integration](docs/images/MavenIntegrationPlugin.png)

## Run test
If all setup is done correctly you can run your test with in terminal with
````
mvn clean test -DsuiteXmlFile=suites/featureSuites/aboutSuite.xml -Denvironment=live -Dos=windows -DbrowserName=chrome
````
![Run test](docs/images/RunTest.gif)