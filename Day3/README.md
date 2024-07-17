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
cd Day3/maven/cpp-app
tree
mvn clean
ls -l

mvn clean compile
```

Expected output
![image](https://github.com/user-attachments/assets/3be68993-82b6-45fb-aeaf-53e7d1072d70)
![image](https://github.com/user-attachments/assets/358c2512-7740-478a-bddb-096e05f64abd)
![image](https://github.com/user-attachments/assets/91f21d24-48ce-4b47-98e5-ffc5dbb62451)


## Lab - Maven profiles
```
cd ~/devops-july-2024
git pull
cd Day3/maven/profiles/multi-module-project
mvn clean compile
mvn test -P test
mvn package -P package
mvn install -P install
mvn deploy -P deploy
```

Expected output
![image](https://github.com/user-attachments/assets/9571a1e4-0122-4d2f-8f7b-e26759441098)
![image](https://github.com/user-attachments/assets/1df9a5e2-8064-4e51-a67c-6883eddc8fff)
![image](https://github.com/user-attachments/assets/677a2708-2ad8-4c6b-8ca4-7823cf874af5)
![image](https://github.com/user-attachments/assets/8ca95cd2-5259-4f52-9be4-9ea80ce6aadd)
![image](https://github.com/user-attachments/assets/fb80c6db-1955-4ed4-8b18-4fe19a8d8de0)
![image](https://github.com/user-attachments/assets/f6efe529-f7b8-4c18-87ba-e44f0e5a196f)


## Info - Infrastructure as a Code Tool Overview
<pre>
- Let's one of the Dev team has approched me to install RHEL 9.2 in a Virtual machine
- is used to provision Virtual Machine, Physical machine with Operating System, Storage, etc
- Examples
  - Cloudformation which is used in AWS Infrastructure automation
  - Terraform is cloud newtral infrastructure as a code tool
    - is used to automate infrastructure in any public cloud AWS, Azure, GCP, Digital Ocean
    - can also be used to provision VMs in onPrem environment
</pre>  

## Info - Configuration Management Overview
<pre>
- If you already a machine with Operating System installed in it, you can use Configuration Management tools to further install softwares, configure the software, create users, provide permissions, deny certain permissions to certain user, manage network, etc.,
- Examples
  - Puppet
    - DSL ( Domain Specific Language - the language in which the automation script is written )
    - DSL used is Puppet's proprietary language
  - Chef
    - DSL used is Ruby
  - Ansible
    - DSL used is YAML ( Yet Another Markup Language - superset of JSON )
</pre>

## Ansible Overview
<pre>
- is a configuration management tool
- developed in Python by Michael Deehan along with Opensource contributors
- Michael Deehan was former employee of Red Hat, who was developing a similar configuration tool at Red Hat, at some point Red Hat had decommissioned the project, hence Michael Deehan had quit Red Hat and started a company called Ansible Inc
- can be installed only in Linux
- the machine where Ansible is installed is called Ansible Controller Machine (ACM)
- the machines managed by Ansible is called Ansible Nodes
- Ansible comes in 3 flavours
  - Ansible Core 
    - Command line only
    - opensource
  - AWX
    - Ansible Tower opensource
    - developed on top of Ansible core opensource tool
    - supports webconsole
  - Ansible Tower
    - support Webconsole 
    - Red Hat Licensed Product
    - developed on top of AWX
</pre>

## Ansible Inventory file
<pre>
- text file
- contains connections details to ansible nodes(servers)
- two types of inventory are there
  1. Static Inventory - manually ansible nodes(servers) are added and removed
  2. Dynamic Inventory - it is python script
</pre>

## Ansible ad-hoc commands
<pre>
- trivial commands like ping can be executed as ad-hoc commands
- any ansible module can be invoked in commandline without writing ansible playbook for quick testing or R&D
</pre>

## Ansible Playbooks
<pre>
- is a YAML file
- that follows a specific format and sections to be considered as an Ansible Playbook
- all Ansible Playbooks are YAML file but not all YAML files are Ansible Playbook
- Playbook invokes many Ansible modules in a particular order to automate software installation and configuration management activities
</pre>

## Lab - Creating a key-pair for rps user
Accept all defaults( press enter key 3 times in total )
```
cd ~
whoami
ssh-keygen
```

Expected output
![image](https://github.com/user-attachments/assets/73845b92-f8a1-4138-9b6b-a0088aaa5fe6)

## Lab - Building a Custom Ansible Ubuntu Node
```
cd ~/devops-july-2024
git pull
cd Day3/ansible/CustomAnsibleNodeContainerImages/ubuntu
cp ~/.ssh/id_ed25519.pub authorized_keys
docker build -t tektutor/ansible-ubuntu-node:latest .
docker images
```

Expected output
![image](https://github.com/user-attachments/assets/1c197f33-e3dc-450c-b099-ceca239450e3)
![image](https://github.com/user-attachments/assets/58c44e6e-f88d-43eb-bd1c-cfdc0ba18639)
![image](https://github.com/user-attachments/assets/a0f3cde8-c8c8-466a-a85c-6ff815cad229)

## Lab - Creating ubuntu container using our custom docker image
```
docker run -d --name ubuntu1 --hostname ubuntu1 -p 8001:80 -p 2001:22 tektutor/ansible-ubuntu-node:latest
docker run -d --name ubuntu2 --hostname ubuntu2 -p 8002:80 -p 2002:22 tektutor/ansible-ubuntu-node:latest
docker ps
```

Expected output
![image](https://github.com/user-attachments/assets/7b70e213-dea7-4ee0-97db-101170d87ded)

Let's test if we are able ssh into the ubuntu1 and ubuntu2 containers
```
ssh -p 2001 root@localhost
exit
ssh -p 2002 root@localhost
exit
```

Expected output
![image](https://github.com/user-attachments/assets/afe8f32a-e92f-4ce2-b6fc-de43da3fd33c)
![image](https://github.com/user-attachments/assets/987883cd-f2ad-4e45-9304-14e764ca3a89)


## Lab - Ansible ping adhoc command
```
cd ~/devops-july-2024
git pull
cd Day3/ansible/static-inventory
cat inventory
ansible -i inventory all -m ping
```

Expected output
![image](https://github.com/user-attachments/assets/4d812790-1be0-4c21-a9cc-d299e6df7153)

As the latest version of ansible seems to expecte Python 3.6 to installed, let's upgrade the ubuntu we use in Dockerfile and redo the all the procedures to rebuild the image

Let's delete the ubuntu1 and ubuntu2 containers
```
docker rm -f ubuntu1 ubuntu2
docker ps -a
```

Let's rebuild the image with Ubuntu latest image as base image
```
cd ~/devops-july-2024
git pull
cd Day3/ansible/CustomAnsibleNodeContainerImages/ubuntu
docker build -t tektutor/ansible-ubuntu-node:latest .
docker images
```

Let's recreate the ubuntu1 and ubuntu2
```
docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ansible-ubuntu-node:latest
docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ansible-ubuntu-node:latest
docker ps
```

Check if you are able to ssh into ubuntu1 and ubuntu2
```
ssh -p 2001 root@localhost
exit
ssh -p 2002 root@locahost
exit
```

Troubleshooting below error
![image](https://github.com/user-attachments/assets/f03657ce-6d61-4c4d-a99c-d0e44f55e59a)
![image](https://github.com/user-attachments/assets/0d24b4f3-d124-4ca1-bfb8-77fff15380c3)


If all went well, you can try to do ansible ping adhoc command
```
cd ~/devops-july-2024
git pull
cd Day3/ansible/static-inventory
cat inventory
ansible -i inventory all -m ping
```

Expected output
![image](https://github.com/user-attachments/assets/c0621ae3-898c-456a-8b7c-26a340ed59df)
![image](https://github.com/user-attachments/assets/bbba5e70-6142-4ddd-977a-af50eeda79b5)
![image](https://github.com/user-attachments/assets/6990acb8-499c-4aa5-9981-9f28c50e2722)

