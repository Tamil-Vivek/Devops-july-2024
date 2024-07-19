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
