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

Expected output
![image](https://github.com/user-attachments/assets/7bde20fb-2402-446e-83b6-250c81ac92d2)
![image](https://github.com/user-attachments/assets/1bfd63ed-94c7-46d2-babb-c7d418a2a553)
![image](https://github.com/user-attachments/assets/4baf48fa-544e-4722-8085-4f1349bb8756)
![image](https://github.com/user-attachments/assets/6d0c71f1-5048-4778-b906-c5e0b82e6994)
![image](https://github.com/user-attachments/assets/c1d64cdb-e1fc-4877-8d2e-1d70f24498d5)
![image](https://github.com/user-attachments/assets/2c65a29f-3297-4b7a-b752-e650982905e4)
![image](https://github.com/user-attachments/assets/ea4b3b60-cb4b-4e24-a9f8-f5958e33ad87)

## Lab - Finding the exec-maven-plugin goals
```
cd ~/devops-july-2024
git pull
cd Day3/cpp-app
mvn help:describe -Dplugin=org.codehaus.mojo:exec-maven-plugin
```

Expected output
![image](https://github.com/user-attachments/assets/98531fae-aefd-447d-977d-24336b3cf92b)


## Lab - Building c++ application using maven build tool
You need to install c++, make and dependent tools before proceeding
```
sudo apt install -y build-essential
```

Once the above tools are installed, you may proceed
```
cd ~/devops-july-2024
git pull
cd Day3/cpp-app
mvn compile
```

Expected output
![image](https://github.com/user-attachments/assets/75c6d827-e5b1-4d37-807d-4140832ea0db)
![image](https://github.com/user-attachments/assets/202246a1-a96e-46d1-9e21-c80c69fefc3d)
![image](https://github.com/user-attachments/assets/8f40997a-022e-49cd-98f3-5c83a16e12ac)
![image](https://github.com/user-attachments/assets/89608c65-ba6e-4f7e-b806-d7c4c0a2962f)

```
cd ~/devops-july-2024
git pull
cd Day3/cpp-app
tree
mvn clean
ls -l

mvn clean compile
```

Expected output
![image](https://github.com/user-attachments/assets/3be68993-82b6-45fb-aeaf-53e7d1072d70)
![image](https://github.com/user-attachments/assets/358c2512-7740-478a-bddb-096e05f64abd)
![image](https://github.com/user-attachments/assets/91f21d24-48ce-4b47-98e5-ffc5dbb62451)
