# Day 2

## Lab - Cloning TekTutor Training Repository ( one time activity )
```
cd ~
git clone https://github.com/tektutor/devops-july-2024.git
cd devops-july-2024
ls -l
```

## Info - Maven Overview
<pre>
- Maven is a build tool, predominantly used by Java projects but it is language agnostic(independent) tool
- It is possible to build C/C++,C#, etc project using maven 
- opensource build tool developed and maintained by Apache Foundation 
- Maven is a better build tool compared to Ant, as Maven was created by same Apache Foundation resolving all the issues that Ant build tool had
- Maven has supports depedency management
  - if your application has third-party framework/library dependency, those jar files will be automatically downloaded and their class path is managed by Maven if you have just mentioned the maven co-ordinates of the dependent libraries in the pom.xml
- Maven also uses pom.xml file to captures the project details
- Unlike Ant, in Maven we will not be writing build instructions in pom.xml, we just provide some meta-data while Maven takes care of build the language specific build instructions
- settings.xml is used by Maven to capture any login credentials, gloabal maven settings, etc.,
- Maven has standards and conventions for everything is called Convention over Configuration
</pre>

## Info - Maven vs Ant
<pre>
- Ant and Maven is build tool developed and maintained by Apache Foundation
- Ant build tool is also mainly used by Java project
- Ant doesn't support dependency management
  - in case your project depends on some third-party libraries, Ant doesn't have an inbuilt feature to download them, manage class path, etc
  - we need to take care of dependency management ourselves
  - Ant doesn't have any standards in terms of
    - where you should place your application source code
    - where you should place your test source code, etc
    - hence, every teams figures out their own project folder structure
    - this makes it difficult for even a Ant veteran when they move in to a new project which is based on Ant
    - Ant uses build.xml file to capture all the build instructions, which is not a good idea
    - Apache foundation found Ant build tool's complexity grows as the size of project grows
    - hence, Apache foundation wanted to develop a new build tool which will solve all the above Ant issues
    - Maven is the new build tool developed by Apache foundation which solves all the Ant issues
</pre>

## Info - What is Maven co-ordinates ?
<pre>
- Maven co-ordinates to used to name application binaries in such a way, each artifactory(.jar, war, ear, zip, etc) has an unique name within the Maven repositories
- Just like the GPS co-ordinates has 3 attributes
  - Altitude, Longitude and Latitude
  - the combination of all 3 co-ordinates will always be pointing to an unique location on earth
  - same way, the combination of Maven Coordinates will also be unique to point to single artifact
    - GroupId
    - ArtifactId
    - Version 
- Everything in Maven project are given a name in terms of Maven co-ordinates
</pre>  

## Info - Maven Convention over Configuration
<pre>
- 80-20 Principle
- Apache foundation has done extensive study to identify the most common usecase of Maven and they made it simple
- At the same, Maven also supports many advanced use-cases where you may not be able to follow the Maven's conventions strictly, in such cases you need to do more configurations in pom.xml and settings.xml files.
- Maven has conventions on
  - how to name your project
  - how your project folder structure should look like
  - where you must maintain your application source code 
  - where you must maintain your application test source code
- If we follow Maven's conventions then with less or no extra configuraiton we can manage a project 
- In case we can't follow Maven's conventions then Maven allows us configure to help Maven follow your convention
  
</pre>  

## Info - Maven Alternative tools
<pre>
- Ant is the oldest build tools used in Java projects
- Gradle - which is a modern build tool that came after Maven
</pre>

## Info - Maven High-Level Architecture
<pre>
  
</pre>

## Info - JDK vs JRE
<pre>
- JDK - Java Development Kit - used by Developers in Dev environment
  - When we install JDK we get both javac(compiler) and java(interpretter)
  - source ( the machine where the application is compiled )
- JRE - Java Runtime Environment - used by QA and Production environments
  - we only get Java(interpreter) when we install JRE
  - target( the machine where the application will be running)
</pre>


## Lab - Finding maven version
```
mvn --version
tree /usr/share/maven
```

Expected output
![image](https://github.com/user-attachments/assets/2b3db5bd-5a06-43a2-abb9-e0082fcac5ce)
![image](https://github.com/user-attachments/assets/996d13ae-4cff-434d-862f-35f61a18610f)

## Lab - Creating a simple Core java application using Maven as a build tool
```
cd ~/devops-july-2024
git pull
cd Day2/Hello
mvn validate
mvn compile
```

Expected output
![image](https://github.com/user-attachments/assets/b4491893-ebb9-495d-b0c1-0bf443cb3bd3)
![image](https://github.com/user-attachments/assets/a01cc59a-f1c0-468c-9458-75dda5c5a92b)

When the maven.compiler.source and maven.compiler.target is not configured, the maven version we have installed uses maven-compiler-plugin:3.1 which was released in the year 2013, at that time the stable version of JDK was JDK 1.5, hence irrespective of which version of JDK you have installed on your machine, it will use the Java as v1.5 only.

In case you are using latest Java features, when the compiler feature set is restricted to JDK 1.5, your code may not compile.
![image](https://github.com/user-attachments/assets/9768ff82-d100-4c18-9f88-286680b97c6b)
![image](https://github.com/user-attachments/assets/d1dc4934-5b81-446d-944e-feaa1dd50594)
![image](https://github.com/user-attachments/assets/1eeb5395-9b8a-43ad-a28f-80f3954a7dff)
![image](https://github.com/user-attachments/assets/2c2d4f32-b7a6-4293-a8e9-2c26b1c51014)

#### Things to note
<pre>
- Maven has plugins to do each and every activities
- There are maven plugins to compile, package, test, etc.,
- to compile java applications maven depends on a plugin called maven-compiler-plugin
- for each maven plugin there might be several version available in the Maven Central Repository, we can configure the pom.xml to use any specific version of maven-compiler-plugin.
- the maven-compiler-plugin will invoke the javac compiler to compile the java project
- depending the version of maven-compiler-plugin we are using it may a default version of JDK
- in our case, the default maven-compiler-version happens to be 3.1 which uses JDK 1.5 and JRE 1.5 
- hence, we have to configure the properties to instruct maven to use a specific version of JDK and JRE
</pre>
  ```
  <properties>
    <maven-compiler-source>1.8</maven-compiler-source>
    <maven-compiler-target>1.8</maven-compiler-target>
  </properties>
  ```
![image](https://github.com/user-attachments/assets/7f5e0d81-d8f5-4e0c-a32d-3098e1dd5298)

## Info - Commonly used Maven commands
<pre>
- mvn compile - compiles the application source code kept under src/main/java and sub-folders
- mvn test    - compiles the test case source code kept under src/test/java and sub-folders
- mvn clean   - will delete the target folder where all the .class, jar/war/ear files are stored
- mvn clean compile - will first delete the target folder and compiles the applicaiton source code
- mvn package - will create jar/war/ear depending on the type of your project
</pre>

## Info - Maven Dependency Management
<pre>
- Our application depends on JUnit Testing Framework to perform automatted Unit and Integration Testing
- We need to add a dependency section and give the maven-coordinated of Junit testing framework jar 
</pre>
![image](https://github.com/user-attachments/assets/5d8ef6ab-01e7-4124-a566-652ae3f857b8)
![image](https://github.com/user-attachments/assets/ad09947d-3773-48d5-8326-9b945d9e90ea)
