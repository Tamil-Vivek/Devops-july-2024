# Day 3

## Info - Maven Plugin vs Maven Dependencies
<pre>
- Maven Dependencies
  - Whatever framework/libraries your application depends on is called dependencies
  - Example
    - JUnit Test Framework is used by your application to automate Unit and Integration Test Cases
- Maven Plugins
  - Maven depends plugins to do every activity
    - For instance to compile the applicaiton code it uses maven-compiler-plugin
      - to run the unit testcases, it depends on maven-surefire-plugin
      - to package jar file, maven depends on maven-jar-plugin
      - to package war file, maven depends on maven-war-plugin
      - to delete the target folder, maven depends on maven-clean-plugin
</pre>

## Lab - Multi module project
<pre>
cd ~/devops-july-2024
git pull
cd Day3/maven/multi-module-project/dal
mvn install
cd ..
cd bl
mvn install
cd ..
cd fe
mvn install
cd ..
mvn clean install
</pre>
