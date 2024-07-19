# Day 5
## Lab - Installing Docker and Ansible Jenkins Plugins
![image](https://github.com/user-attachments/assets/75a8aada-8522-473e-9976-45a5c774acb6)
Click on "Manage Jenkins"
![image](https://github.com/user-attachments/assets/e684aa93-eabb-416d-987a-701e498a83a5)
Click "Plugins"
![image](https://github.com/user-attachments/assets/e839a1ae-1dab-41bc-8ffa-8cf5e81145e2)
Select "Available Plugins"
![image](https://github.com/user-attachments/assets/8e57a501-c18d-4ef8-af27-5767e49192bc)
Search "Docker" and Select "Docker 1.6.2"
![image](https://github.com/user-attachments/assets/83459d39-3083-46d5-884e-7d185f5f1e54)
Search "Ansible" and Select "Ansible"
![image](https://github.com/user-attachments/assets/aeffdaa7-b33f-4ad8-8ef7-acee56b0ec7c)
Click "Install"
![image](https://github.com/user-attachments/assets/ae195671-f2c1-4f76-8269-905fcf7ad324)
Select check "Restart Jenkins when installation is complete and no jobs are running"
![image](https://github.com/user-attachments/assets/4cdb930a-178b-40ab-b60e-aebf652f3fc3)
In case, you don't see any progress refresh your web browser page
![image](https://github.com/user-attachments/assets/6f32e2a7-206d-4ca5-a07a-86e36e122e0d)
To verify if Docker and Ansible Plugins are installed, navigate to "Manage Jenkins" --> "Plugins" --> "Installed Plugins" and Search for Docker
![image](https://github.com/user-attachments/assets/59eccbd9-fa8f-4756-8f19-77e06ff2cda3)
Clear Search and search for Ansible
![image](https://github.com/user-attachments/assets/d45de9cc-c916-4afc-b5bd-cebb08a83920)

Once you have confirmed that all necessary plugins are installed, let's go back to the Jenkins Dashboard landing page
![image](https://github.com/user-attachments/assets/2c0706f7-5cd7-44c8-92e4-69c8ea0755da)


## Lab - Creating a Maven style Jenkins Job
![image](https://github.com/user-attachments/assets/2c0706f7-5cd7-44c8-92e4-69c8ea0755da)
In the center of the Jenkins page click "Create a Job" or you may click "Create Item" from the menu shown in the left side.
![image](https://github.com/user-attachments/assets/fdacc918-165b-4a2e-8c2f-0fc75c6c7aa4)
As the Maven style Job is missing, we need to install "Maven Integration Plugin". Navigate to "Manage Jenkins" --> "Plugins" --> "Available Plugins" search for "Maven Integration" and install and restart.
![image](https://github.com/user-attachments/assets/1633726e-7559-41b2-98f7-a832052b27db)
![image](https://github.com/user-attachments/assets/aeb70368-5a4f-404e-9548-33dfe94a1685)

![image](https://github.com/user-attachments/assets/2c0706f7-5cd7-44c8-92e4-69c8ea0755da)
From the landing page, let's click "Create a Job"
![image](https://github.com/user-attachments/assets/1b33ea2d-9f83-42c0-ab8c-859a44c1a302)
Select "Maven Project" and type "Hello Maven Jenkins Job" under Enter an item name
![image](https://github.com/user-attachments/assets/e7ece0d9-09d5-4dc5-b12e-77c5008fbba1)
Click "ok" button
![image](https://github.com/user-attachments/assets/a3476ceb-e665-4930-85bd-e3bb0747406b)

General Section
![image](https://github.com/user-attachments/assets/8f924ac4-720c-4d83-bedb-f776a4cde6fd)

Source Code Management
Select "Git" and type https://github.com/tektutor/devops-july-2024.git under "Repository Url"
Under Branches to build, replace "master" with "main" branch
![image](https://github.com/user-attachments/assets/96a0ecdf-9947-4582-90c7-ce870538eb1b)

Triggers
Select "Poll SCM" and type "H/02 * * * *" under schedule
![image](https://github.com/user-attachments/assets/afada48b-7406-4392-8f90-8c3382119a47)

Build

Under "Root pom" we need to give the relative path where Jenkins can find the pom.xml
"Day3/maven/multi-module-project/pom.xml"
![image](https://github.com/user-attachments/assets/03165093-22ba-4824-a319-d672cd67690f)
Under the "Goals and options" type "clean deploy"
![image](https://github.com/user-attachments/assets/c5319756-2aa9-4722-9e8c-98c675fb2db3)

Scroll down to click on "Save" button
![image](https://github.com/user-attachments/assets/a91d82e9-c477-4f03-94fd-de3386084f14)

![image](https://github.com/user-attachments/assets/7ab0b990-2011-4347-9fe1-546e8d054ac5)
![image](https://github.com/user-attachments/assets/637a55c2-8a6a-44b4-bad3-bfd76ff61ecd)
![image](https://github.com/user-attachments/assets/0967f96f-88b9-4172-ad02-3c93d442386b)
![image](https://github.com/user-attachments/assets/0a0e40d1-3250-4a9b-b802-e5568758d31b)


## Lab - Creating a Freestyle Jenkins Job
![image](https://github.com/user-attachments/assets/5316809a-7f74-4c35-a15f-de222cfcb4cf)
Click "New item"
![image](https://github.com/user-attachments/assets/e6c39e76-a0dc-4a08-b475-d3992e09f1a0)
Type "Freestyle Jenkins Job" under the item name and select "Freestyle project"
![image](https://github.com/user-attachments/assets/bdab028d-14f0-4954-9e42-faea48427be5)
Click "Ok" button
![image](https://github.com/user-attachments/assets/82844975-0f0e-4a58-848d-aa5278ddf80e)

General section
![image](https://github.com/user-attachments/assets/dbb5db5b-8c5c-4dea-918c-da88825ff8eb)

Source Code Management
Type https://github.com/tektutor/devops-july-2024.git under repository url and replace "*/master" with "*/main" under Branch specifier
![image](https://github.com/user-attachments/assets/36457f78-91e6-475a-b718-bb89b4292eb8)

Build Triggers
Type "H/02 * * * *" under Poll SCM --> schedule
![image](https://github.com/user-attachments/assets/2c1892e9-8575-4ccf-a8ab-8e4248ba8731)

Build Steps
![image](https://github.com/user-attachments/assets/1caf5e66-ddf7-4d4e-8483-e6b5d7c57aa3)
![image](https://github.com/user-attachments/assets/4bc194db-b00a-40a3-b37e-5f2c176f8ba7)
Select "Execute Shell"
![image](https://github.com/user-attachments/assets/c4117c93-e5ba-457a-9595-cdab74904ee3)
Under the Execute Shell --> command type
```
cd Day3/maven/multi-module-project
mvn clean install
```
![image](https://github.com/user-attachments/assets/5722d383-d29f-49bb-b21e-c5438184ec22)

Click "Save" button
![image](https://github.com/user-attachments/assets/635338a7-db10-4244-9fae-f2640a7a030c)

## Lab - Creating a FreeStyle Jenkins Job and triggering Ansible Playbook
Create a file name ~/.become-password-file and type 'rps' without quotes, save and close the file.


![image](https://github.com/user-attachments/assets/9d123e37-d2e5-4408-a4f7-914148c85300)
Click "New Item"
![image](https://github.com/user-attachments/assets/38e8843a-07d0-4234-95dc-30dfdfc5366d)
Type "Invoke Ansible Playbook" and Copy project from "Freestyle Jenkins Job"
![image](https://github.com/user-attachments/assets/01f0b72b-9f40-4781-9971-b181f928884b)
![image](https://github.com/user-attachments/assets/a315a2d0-19bb-437f-8b1c-39d71cdb9752)
Click "ok" button
![image](https://github.com/user-attachments/assets/03836181-7679-42f7-9840-c3081c0cd1c9)

![image](https://github.com/user-attachments/assets/d9778524-ffa2-4fc9-ab4e-4f9c7b7cd208)

Build Steps
![image](https://github.com/user-attachments/assets/ed0e2f05-54ac-4a74-a496-798670521d7b)

Click "save" button
![image](https://github.com/user-attachments/assets/8ddf27e1-d5c9-486d-84b3-fbde17d6e8d6)

![image](https://github.com/user-attachments/assets/219ea628-72bb-46ad-bb1b-557fd4a0ff27)
![image](https://github.com/user-attachments/assets/4835d240-7aea-47f0-8696-c8ffc63015c0)
![image](https://github.com/user-attachments/assets/a2661c8b-4f83-469e-8b64-bde069998a02)

## Lab - Invoking Ansible Playing using Ansible Jenkins plugin

### Things to remember
<pre>
- Ansible searches for ansible.cfg as mentioned in the ANSIBLE_CONFIG environment variable
- In case you have exported the ANSIBLE_CONFIG environment variable, then ansible searches for ansible.cfg in the current directory
- In case, the ansible.cfg is not present in the current folder then ansible searches for .ansible.cfg under your home directory
- In case, the ~/.ansible.cfg is not found then ansible finally searches ansible.cfg under /etc/ansible/ansible.cfg folder
- In the above paths, wherever ansible finds the ansible.cfg first it picks it and ignores the other options.
</pre>

Copy the ansible.cfg from your Day4/ansible folder to your home directory
```
cd ~/devops-july-2024
git pull
cd Day4/ansible
cp ansible.cfg ~/.ansible.cfg
```
![image](https://github.com/user-attachments/assets/0224fab5-e654-401a-8d55-6c4db4d9770c)
![image](https://github.com/user-attachments/assets/c1e07efd-c9dd-40cc-824b-51e6acd6e345)
![image](https://github.com/user-attachments/assets/f7da046e-099a-42a5-8f15-26d018441d21)
![image](https://github.com/user-attachments/assets/f3a5de23-c4cd-4703-ba8a-d137ff3835e2)
![image](https://github.com/user-attachments/assets/ff39b648-c3d4-4424-aa4e-46208afd8778)
![image](https://github.com/user-attachments/assets/661d72cb-b501-4b2f-924a-2341ab4f34ec)
![image](https://github.com/user-attachments/assets/834722ee-aa0b-4cae-bc9b-9ed638b5b091)
![image](https://github.com/user-attachments/assets/ae018c98-2ef9-4e01-b1f4-298f4781f93d)
![image](https://github.com/user-attachments/assets/9d0aaabf-aa9f-4521-8687-0655cda58733)
![image](https://github.com/user-attachments/assets/37a28a1c-d45d-42b5-827b-c360a7f7afa9)
![image](https://github.com/user-attachments/assets/c2080087-8784-47db-a313-70606b5fbca1)

## Info - Jenkins Master-Slave Node Setup usecases
<pre>
- Currently used Jenkins is the Master Jenkins that comes with Web GUI
- We could add many slave Jenkins which are headless, they only instructions from Jenkins Master
- end-users will not able to give instructions or interact with Jenkins slave instances
- the main usecase of master-slave node setup is
  - to support executing parallel builds
  - to support running builds and testing in different OS environments
- the slave nodes can be ec2 instance running in aws, azure vm instances, or could on-prem virtual machine or physical machine or docker containers
- in our case, we are going to use docker containers as Jenkins slave nodes
</pre>

## Lab - Configuring Docker containers as Jenkins slave nodes

We need to configure the Docker Service (Service) - Do this in the terminal
```
sudo systemctl status docker
sudo gedit /usr/lib/systemd/system/docker.service
sudo systemctl daemon-reload
sudo systemctl restart docker
sudo systemctl status docker
```
Expected output
![image](https://github.com/user-attachments/assets/c2cdd716-5613-423b-be5a-8fb197a848c8)
![image](https://github.com/user-attachments/assets/6e7ba1a9-6f14-4c3a-ba6e-c8741cc4a034)
![image](https://github.com/user-attachments/assets/8cc99836-ef97-4b7f-af75-8bba37532028)
Save and exit
![image](https://github.com/user-attachments/assets/c158c842-9983-47a3-92b6-b1b176bd5890)
![image](https://github.com/user-attachments/assets/f56b7fb2-af23-4084-bfa4-e90c130c0461)



![image](https://github.com/user-attachments/assets/881523eb-1092-4196-b200-4992e13514e2)
Manage Jenkins
![image](https://github.com/user-attachments/assets/f251e0b1-ed7a-46aa-bec3-37c543c60946)
Click on "Clouds"
![image](https://github.com/user-attachments/assets/4bd415e9-738a-4073-91d9-8b3b96c82faf)
New Cloud
![image](https://github.com/user-attachments/assets/04a0ed81-9966-4a0f-ace7-5d229a9e7b89)
![image](https://github.com/user-attachments/assets/cfc91899-124b-46c0-912a-0b41d3c26a6f)
Click "Create"
![image](https://github.com/user-attachments/assets/ad411d9c-0e72-442b-9afb-1fb4474a2d12)
Expand "Docker Cloud details"
![image](https://github.com/user-attachments/assets/03a6b37f-f034-4307-a1b5-91a8d620bf1b)
![image](https://github.com/user-attachments/assets/3448e9de-1a46-4cc9-af34-34b3ad4c35dc)

Scroll Down to see "Docker Agent Templates"
![image](https://github.com/user-attachments/assets/6483f61c-878a-43c6-b8eb-f5900f3dfd54)
Add Docker Template
![image](https://github.com/user-attachments/assets/0b238bde-51b2-4d5c-9bea-8331446ee740)
![image](https://github.com/user-attachments/assets/fcd58715-4c6d-4022-9ffd-4ca2c26204f7)
![image](https://github.com/user-attachments/assets/a25c33c6-f754-4981-bb4b-2848a571bea5)
![image](https://github.com/user-attachments/assets/3e156d7a-7ef9-4872-98e3-3f09429612fd)
![image](https://github.com/user-attachments/assets/335c22e3-da96-48b9-ac8f-0c86a7ead3fc)

Click "Save" button
![image](https://github.com/user-attachments/assets/a2158751-b3ab-4d75-b6c1-674c2c395b1d)

## Lab - Creating a CICD Pipeline
![jenkins](CICD.png)

Let's create a declarative pipeline using Jenkinsfile
![image](https://github.com/user-attachments/assets/0dc33e30-212e-4fa5-9a85-dce320875f9c)
Click "New Item", let's create a Pipeline project and give it a name "CICD Pipeline"
![image](https://github.com/user-attachments/assets/e872e2a7-9cf4-4de7-a9b9-f4b690f20101)
Click "Ok" button

General
![image](https://github.com/user-attachments/assets/d32ae7b1-2b56-4280-b398-08df1ac03cef)

Build Triggers
![image](https://github.com/user-attachments/assets/197dc75a-5489-4b5b-a7f2-172001e09092)

Make sure you update the dockerimage as shown below
Under Manage Jenkins --> Clouds --> docker-jenkins-slave --> Docker Agent Templates --> Docker Image
![image](https://github.com/user-attachments/assets/131441d1-584e-494b-bf64-6b37d196ed0f)


Pipeline
<pre>
1. Pipeline --> Definition --> Select "Pipeline Script from SCM"
2. Under SCM --> Select Git
3. Repository URL - https://github.com/tektutor/devops-july-2024.git
4. Under Branch Specifier replace "*/master" with "*/main"
5. Under Script Path, change Jenkinsfile to Day5/CICD/Jenkinsfile
</pre>
![image](https://github.com/user-attachments/assets/8bfae090-e3c7-42f1-9bcd-da985fff1615)
![image](https://github.com/user-attachments/assets/ff8fc567-1f51-4563-a19f-7ca161212830)
Click "Save" button
![image](https://github.com/user-attachments/assets/d6cb0b88-cf6b-4145-b354-3eb9c6f0dc56)


Expected output
![image](https://github.com/user-attachments/assets/4ca82eeb-9f2c-4721-b9bd-01b7430600ac)
![image](https://github.com/user-attachments/assets/2ff02c18-065c-4d5d-a2c0-1f756a3f9498)
![image](https://github.com/user-attachments/assets/830c335e-36c4-4d1f-bde8-b0df8cd30133)
![image](https://github.com/user-attachments/assets/84e0b49a-abf5-428b-8d74-f0664963522b)
