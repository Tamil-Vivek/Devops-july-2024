# Day 2

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
- 
</pre>  

## Info - Maven Alternative tools
<pre>
  
</pre>

## Info - Maven High-Level Architecture
<pre>
  
</pre>
