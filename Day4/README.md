# Day 4

## Info - Ansible Idempotency property
<pre>
- Idempotency is a feature of all Configuration Management tools including Ansible
- Majority of the ansible modules support idempotency but not all of them
  - For example
    - copy, service, apt, yum modules supports idempotency
    - shell modules doesn't idempotency
- Ansible color status
  - Green - Success with no change
  - Yellow - Success with change
- Example
  - when we install nginx web server in an Ubuntu Virtual machine via Ansible Playbook
  - ansible will check if already the Virtual machine has latest version of nginx installed, in case it found that the machine already has latest version then ansible do will nothing, it will simply report the task was successful executed and it didn't change anything on the machine( it will report in green color )
  - if suppose ansible found that the virtual machine has an older version of nginx, then ansible will upgrade the nginx to latest
  - if suppose ansible found that the virtual machine has no nginx then, it will install the latest version of nginx
  - once ansible has installed latest nginx when we execute the playbook it will simply report the status in green i.e it won't repeat the installation 
  - this property is called Idempotency, we don't need to anything for this, ansible does this automatically
</pre>

## Info - Ansible Playbook Structure
![ansible](playbook.png)

## Lab - Listing all the modules ansible supports
```
ansible-doc -l
```

Expected output
![image](https://github.com/user-attachments/assets/27432e05-4042-4c21-a6d3-7c8033f1c0bc)

## Lab - Finding syntax details of a particular ansible module
```
ansible-doc service
ansible-doc shell
ansible-doc yum
ansible-doc apt
ansible-doc file
ansible-doc template
ansible-doc copy
ansible-doc command
```
Exptected output
![image](https://github.com/user-attachments/assets/e01e5807-75d9-4c23-8468-0fbe3eebb0e4)
![image](https://github.com/user-attachments/assets/d62df8c0-8bae-4471-b0eb-51351464596a)
![image](https://github.com/user-attachments/assets/dad48ce4-8591-47b7-a95a-6f39039ee3af)
![image](https://github.com/user-attachments/assets/161589df-6c0e-4874-904c-33ccf0419979)
![image](https://github.com/user-attachments/assets/6347b35d-d562-4cd3-a96a-039777eefdba)
![image](https://github.com/user-attachments/assets/2bcbcef7-91e4-4b1e-9f58-b29bd8bab5f9)
![image](https://github.com/user-attachments/assets/166dca72-a411-4e0c-a62b-606fbc7b362b)
![image](https://github.com/user-attachments/assets/8705822f-61c8-4f91-b6f4-7ff28f688c75)

## Lab - Running your first ansible playbook
```
cd ~/devops-july-2024
git pull
cd Day4/ansible
cat ping-playbook.yml
ansible-playbook -i hosts ping-playbook.yml
```

Expected output
![image](https://github.com/user-attachments/assets/4b611bbf-eed8-48d6-b425-6db167ff3fad)

## Lab - Multiple Plays in a single Playbook
```
cd ~/devops-july-2024
git pull
cd Day4/ansible
cat multiple-play-in-a-playbook.yml
ansible-playbook -i hosts multiple-play-in-a-playbook.yml
```
Expected output
![image](https://github.com/user-attachments/assets/1d925634-e21e-4261-b754-3962ba407725)

## Lab - Understanding Ansible Setup module
```
cd ~/devops-july-2024
git pull
cd Day4/ansible
ansible -i hosts ubuntu1 -m setup
```
Expected output
![image](https://github.com/user-attachments/assets/4c07d501-92af-404b-80ea-05f4b70fa54b)
![image](https://github.com/user-attachments/assets/8f02fbef-7350-49ff-884b-5b020b232cbe)

#### Things to note
<pre>
- ansible setup module will be the default module which will be executed in every Playbook
- the setup module will retrieve many details about the ansible node
- just to give an idea
  - setup module collects details like
    - hostname of the ansible node
    - Operating System details
    - System Hardware details
    - Operating System Family
    - OS version
    - Python version installed on the node
    - Package Manager supported on the node
</pre>  

## Lab - Install nginx in Ansible nodes using Ansible playbook
Install curl utility locally
```
sudo apt install -y curl
```

Now you may proceed with the below exercise
```
cd ~/devops-july-2024
git pull
cd Day4/ansible
cat install-nginx-playbook.yml
ansible-playbook -i hosts install-nginx-playbook.yml
curl http://localhost:8001
curl http://localhost:8002
```

Expected output
![image](https://github.com/user-attachments/assets/dd6485ed-1629-45e2-b0e0-578fead02732)
![image](https://github.com/user-attachments/assets/771f4bbf-c17c-4cfa-8a6b-aa99f204484e)
![image](https://github.com/user-attachments/assets/41cd63f7-d2b1-4b2f-a9db-b19cc405b10d)
![image](https://github.com/user-attachments/assets/b54e92d1-78ae-4291-ac88-71be942b3ff6)
![image](https://github.com/user-attachments/assets/7f0e1d24-6105-45d3-8272-633f2c71fada)

#### Things to note
<pre>
- ansible apt module is idempotent, hence only the first time it will install latest version of nginx, subsequent times we execute the playbook, ansible will report in green color(meaning - it won't reinstall i.e ansible will report - success with no change)
- shell module isn't idempotent, hence must be used only if no other option is available/possible
</pre>  

Running the playbook with multiple play, the first play will install curl on your local machine
```
cd ~/devops-july-2024
git pull
cd Day4/ansible
cat install-nginx-playbook.yml
ansible-playbook -i hosts install-nginx-playbook.yml --ask-become-pass
```

Expected output
![image](https://github.com/user-attachments/assets/c9364b4c-a754-42f6-884f-c7faf747aee3)

## Demo - Ansible ping a windows virtual machine from Azure portal
```
cd ~/devops-july-2024
git pull
cd Day4/ansible/windows
cat hosts
ansible -i hosts windows -m win_ping
```

Expected output
![image](https://github.com/user-attachments/assets/fdc4f552-1917-4c30-af72-477026d59bd8)

## Lab - Downloading jar from JFrog Artifactory
Make sure your JFrog Artifactory container is running and it has the jar file we are downloading.

```
cd ~/devops-july-2024
git pull
cd Day4/ansible
cat download-jar-from-jfrog-artifactory-playbook.yml
ls -l
ansible-playbook download-jar-from-jfrog-artifactory-playbook.yml
ls -l
```
Expected output
![image](https://github.com/user-attachments/assets/d521b1fb-dd46-4c84-a608-2d4fc8c2bc03)

## Lab - Passing arguments to ansible-playbook from command line
```
ansible-playbook passing-arguments-to-playbook-from-cli-playbook.yml -e greeting_msg=Hello

export GREETING_MSG="Hello!"
ansible-playbook passing-arguments-to-playbook-from-cli-playbook.yml -e greeting_msg=$GREETING_MSG
```
Expected output
![image](https://github.com/user-attachments/assets/dd0f2083-8df9-4370-9f8d-a6ab277dcf0f)
![image](https://github.com/user-attachments/assets/7247759f-9108-49fb-b979-80e0cea1a649)

## Lab - Using template module in playbooks
Create a file /home/rps/.my-vault-password with gedit and type 'root' without quotes and save the file.

```
cd ~/devops-july-2024
git pull
cd Day4/ansible
ansible-playbook install-nginx-playbook.yml --ask-become-pass
```
Expected output
![image](https://github.com/user-attachments/assets/7e7ef51e-26c4-40bd-b33e-736301fc91e4)

![image](https://github.com/user-attachments/assets/5d52d09a-18f6-4c99-a1c5-4b0cca700673)
![image](https://github.com/user-attachments/assets/cf819212-e275-4f90-bdcc-cde07ecfea9f)
![image](https://github.com/user-attachments/assets/638660e2-7671-4d41-98ce-b230a2d38f03)
![image](https://github.com/user-attachments/assets/c7d2f04c-14ea-4c47-8122-cc97aed2d370)
![image](https://github.com/user-attachments/assets/2c30f23f-a5ed-4927-8a8f-9cc6ef920eb3)
![image](https://github.com/user-attachments/assets/eacff1b9-a41a-49fd-badd-1e55cafec46f)



## Info - SCRUM - Daily stand-up meeting
<pre>
- is an inspect and adapt meeting
- in other words, it is fail-fast meeting
- the team inspects the yesterday's plan against the real status as on yesterday
- if the team finds a deviation, if required the plan must be updated

</pre>

## Info - DevOps
<pre>
- Developers
  - they need to automate unit/integrating testing using Test Frameworks
    - developers are expected to learn little bit of QA skills
  - Test Frameworks
    - Developers should follow TDD(Test Driven Development)
    - Java
      - JUnit/TestNg/Mockito/PowerMock/EasyMock/JMock, etc
    - C/C++
      - CUnit, CppUnit, Google Test/Mock
    - JavaScript ( Angular, NodeJS )
      - Jasmine, Karma
    - Python
      - PyTest
    - C#
      - NUnit/MSTest/Moq
- QA
  - they need to automate e2e functionality test, API Test, Stress/Load Test, Regression Test, Sanity Check, Smoke Test
  - the test automation expects to convert the testing effort into source code that can be pushed to Version control
  - QA folks are expected to learn little of development skills
  - Frameworks
    - Behaviour Driven Development Frameworks (BDD)
    - Cucumber, Specflow, Selenium, Raft
- System Administrators
  - they need to automate OS installation, provisioning, software installations, user management, etc
  - Provisioning
    - System Adminstrators are expected to use Infrastructure as a Code Tools like Cloudformation, Terraform, Docker, Vagrant, etc.,
    - System Administrators are expected to use Configuration Management Tools like Ansible, Puppet/Chef, etc to install softwares on an existing Virtual Machine or a OS on OnPrem environment(Private cloud), public cloud and Hybrid Cloud
    - System Administrators also has to know coding
</pre>

## Info - Continuous Integration (CI)
<pre>
- the code developed by each developer is continuously integrated in the dev branch
- Jenkins or CI Build Server grabs the latest code and it is going run the build along with unit and integration test cases
- If any test case fails, the build will fail, all the test cases are passing then the build will pass
</pre>

## Info - Continuous Deployment (CD)
<pre>
- the CI certified application binaries are automatically deployed into QA environment for further QA automated test execution  
</pre>

## Info - Continuous Delivery (CD)
<pre>
- the QA certified release(application binaries) are deployed into customer's environment which is close to production environment ( pre-prod ) environment
- the Customer will verify the functionality and if the customer found the application is working as expected and found to be stable, they can decide if they can make it live in production environment
</pre>

## Info - Jenkins Overview
<pre>
- Jenkins is a Continuous Integration Build Server
- it was developed in Java by Kohsuke Kawaguchi while he was working for Sun Microsystems
- the initial product developed was called Hudson
- it is an opensource tool
- Before leaving Oracle, Kohsuke Kawaguchi created a branch of Hudson source code called Jenkins
- Kohsuke founded a company called Cloudbees 
- Today Hudson and Jenkins shares lot of common code, but Jenkins has become very popular than Hudson
- Jenkins has over 10000+ active opensource contributors
- there are 2 variants of Jenkins
  1. Jenkins open-source
  2. Cloudbees ( Enterprise edition of Jenkins )
- it supports creating CI build for any programming language
</pre>

## Info - Jenkins alternates
<pre>
- Team City
- Bamboo
- Microsoft's Team Foundation Server (TFS)
- CircleCI
</pre>

## Info - Just in case you need to reset Jenkins Administrator password
<pre>
https://www.jenkins.io/doc/book/system-administration/admin-password-reset-instructions/  
</pre>

## Lab - Launching Jenkins from terminal
Verify if already any application is using the port 8080
```

```

The below command is a blocking command, hence don't press Ctrl+C, you may open new terminal tab to run other commands
```
cd ~/Downloads
java -jar ./jenkins.jar
```

Expected output
![image](https://github.com/user-attachments/assets/8f1413aa-66f9-486f-b45e-bb32122c0b57)
![image](https://github.com/user-attachments/assets/862429b9-e91d-4467-8b1c-5f088c621b9f)
![image](https://github.com/user-attachments/assets/dd81048c-1005-4f35-a43e-76fd3af2c56f)
![image](https://github.com/user-attachments/assets/8e9cbcca-bde3-49b7-8d0d-b81185f99d22)
![image](https://github.com/user-attachments/assets/c43285d2-e1f6-424b-92ae-7baafd04ea6d)
![image](https://github.com/user-attachments/assets/6adb9cb1-81b6-4a3b-b56c-c6d5fa22e78b)
Select "Install Suggested Plugins"
![image](https://github.com/user-attachments/assets/2e232d54-89ca-4fe5-b381-e62580f47da7)
![image](https://github.com/user-attachments/assets/3044f036-5390-440d-99bb-8ba787824bf6)
![image](https://github.com/user-attachments/assets/e2c26d85-dbbe-42ed-a5d4-0c116d781176)
![image](https://github.com/user-attachments/assets/d5523d1a-811d-4955-b98f-b5e76f6979b4)
Click on "Save and Continue"
![image](https://github.com/user-attachments/assets/af225f73-d027-4ae2-97aa-72c7c5114819)
Click on "Save and Finish"
![image](https://github.com/user-attachments/assets/b6da3a62-dd9b-4266-bdf5-591959ade755)
Click on "Start using Jenkins"
![image](https://github.com/user-attachments/assets/0a3ab8cf-eaad-465d-8f73-4a82e9d6d508)
![image](https://github.com/user-attachments/assets/73b16011-1186-4784-9ff8-64634623b1c5)
![image](https://github.com/user-attachments/assets/8471af7d-17e4-474d-87de-d81a8c1d7583)
Click on "Manage Jenkins"
![image](https://github.com/user-attachments/assets/6d890cd7-f23b-4f28-9a49-d4f60e9035c9)
Click on "Tools"
![image](https://github.com/user-attachments/assets/6f363bc3-dd1b-4330-81b1-f3e0694145ca)
Under "JDK Installation", select "Add JDK"
![image](https://github.com/user-attachments/assets/bf10e147-60a1-4b69-80b7-e3319593ec09)

Go to your Linux Terminal and type "mvn --version", copy the Java home and return back to Jenkins browser tab
![image](https://github.com/user-attachments/assets/80c5a758-a1b9-4635-a88b-a21381854247)
Paste the JDK path your copied from mvn terminal into the JDK_PATH in the Jenkins page
![image](https://github.com/user-attachments/assets/d8c89c15-ffcc-4e3e-b7cb-fcdb7228aad0)
![image](https://github.com/user-attachments/assets/cddeecfb-3bef-4667-bddf-3b3c5401814d)
Scroll to the bottom and you will see "Maven Installations"
![image](https://github.com/user-attachments/assets/e7cda284-deba-4ccb-af37-56b62d03aad6)
Click on "Add Maven"
![image](https://github.com/user-attachments/assets/1603b8ff-32c2-46df-9e48-369bdcd04cef)
Under Name, you can type MAVEN387 to indicate maven 3.8.7 or given an appropriate string as per your maven version.
Uncheck, "Install automatically"
![image](https://github.com/user-attachments/assets/75da5740-6f3b-497f-b111-7ec82e6f9e2f)

Go to terminal, copy the Maven home
![image](https://github.com/user-attachments/assets/5d215586-732b-4a05-b525-235912632655)
Return back to your Jenkins configuration page and paste the Maven Path as shown below
![image](https://github.com/user-attachments/assets/ae33da72-f101-4b5d-b4ce-39029a709608)

Click "Save" button
![image](https://github.com/user-attachments/assets/fb7941c3-5794-4ff8-8801-d463537dfde2)
