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
```
cd ~/devops-july-2024
git pull
cd Day4/ansible
ansible-playbook install-nginx-playbook.yml --ask-vault-pass
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

