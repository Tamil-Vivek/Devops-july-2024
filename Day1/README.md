![image](https://github.com/user-attachments/assets/22156215-aa28-4e18-b8f4-85753ea5e57f)![image](https://github.com/user-attachments/assets/7a4cfe0f-91a5-41e2-b111-7915485ddad9)# Day 1
## Info - How many physical servers are required to support 1000 Operating System when no virtualization supported
- 1000 Physical servers are required
- Your organization has to procure 1000 servers
- we need a lab facility with power, network, 
, sound-proofed room
- servers are power hungry, they normally tend to consume more power(electricity)
- real-estate expenses
- if you need huge lab room, then the rental/lease cost for the lab facility will also be more
- 
## Info - Hypervisor Overview
<pre>
- is virtualization software
- with virtualization software, we can run multiple Operating Systems in the laptop/desktop/workstation/server
- many OS can run simultaneously
- we are able to consolidate more physical servers with minimal number of physical servers
- this type of virtualization is called heavy-weight virtualization, the reason is each Virtual Machine must be allocated with dedicated hardware resources
  - CPU
  - Memory (RAM)
  - Storage ( Hard Disk or SSDs )
  - Network Card
  - Graphics Card
- there are 2 types of virtualization software or hypervisors
  - type 1
    - is also called as Bare Metal Hypervisors
    - to create Virtual Machines(VM) we don't need to have a Host Operating System
    - Examples
      - VMWare vCenter/vSphere
  - type 2
    - this type of hypervisor is installed in laptops/desktops/workstations
    - in laptops/desktops/workstations normally we will already one primary Operating system
      - it could be Windows/Linux/Mac
      - the Primary OS installed on the Laptop/Desktop/Mac is called Host Operating System
    - the virtualization software is installed on top of the Host OS
    - each Operating System that we install on top of the Hypervisor is called Guest Operating System
    - each Guest OS is installed within a Virtual Machine
    - each Virtual Machine(VM) represents one Operating System
    - Examples
      - VMWare Workstation ( supported in Linux/Windows )
      - VMWare Fusion ( supported in Mac OS-X )
      - Oracle VirtualBox
      - Parallels ( supported in Mac OS-X )
      - KVM - opensource hypervisor software supported in all Linux distributions
      - Microsoft Hyper-V
</pre>

## Info - What is the minimal number of Physical servers required to host 1000 Virtual Machine on top of Hypervisor software ?
<pre>
- 1 Physical server is enough to host 1000 Virtual Machines
- HyperThreading
  - each Physical CPU Core is capable of running 2 threads parallely
  - hence each Physical CPU Core is treated/seen as 2/4/6 virtual/logical CPU Cores
- Server Configuration
  - Processor with atleast 512 CPU Cores ( 1024 virtual CPU Cores )
  - 1 TB or more RAM
  - 10 TB or more Storage ( Hard Disk or Solid Slate Disks )
</pre>

## Info - Containerization
<pre>
- is an application virtualization technology
- is called light-weight virtualization technolgy
  - because container's don't get their own dedicated hardware resources
  - all containers running in the same OS shares the Hardware resources from underlying OS 
- each container represents a single application or a single application process
- container is not an Operating System
- container doesn't have OS Kernel
- containers will never be able to replace an Operating System
- containers will never be able to replace a virtual machine or Hypervisors softwares
- containers is not a replacement/alternate to Virtualization or Hypervisors of OS
- commons characteristics between a virtual machine and a container
  - containers get their own IP address just like virtual machines
  - containers has file system just like virtual machines
  - containers has their own network card (virtual) just like virtual machines
  - container has their own network stack just like virtual machines
  - containers has their own Port range ( 0-65535 ports ) just like virtual machines
  - container represents a single application, while virtual represents an fully functional OS
- containers and hypervisors are complementing technology not competing technology
- containers runs on top of some Operating System
- containers shares the Hardware resources from the underlying Operating System ( Host or Guest OS )
</pre>

## Info - Docker High-Level Architecture
![docker](DockerHighLevelArchitecture.png)

## Info - What is Container Runtime?
<pre>
- is a low-level software to manage containers and container images
- is not user-friendly, hence end-user like us generally won't use container runtimes
- examples
  - runC is a Container Runtime
  - CRI-O is a container runtime
</pre>

## Info - What is Container Engine?
<pre>
- is a high-level software to manage containers and container images 
- is user-friendly
- internally container engines depends on Container Runtime to manage containers and images
- examples
  - Docker is a Container Engine that depends on containerd which in turn depends on runC Container Runtime
  - Podman is a Container Engine that depends on CRI-O Container Runtime
</pre>

## Info - What is Docker Image?
<pre>
- is a blueprint of a Container
- it has one application and all its dependent softwares, libraries, etc required to run the application
</pre>

## Info - What is a Docker Container?
<pre>
- container is an instance of a Docker Image
- all the sofwares and tools that are installed in the docker image are available in each container created from a Docker Image
- container gets a Private IP address
- containers also files/folders ( file system )
- container has port-range ( 0-65535 )
- container has virtual network cards ( software defined network cards )
</pre>

## Info - What is Docker Registry
<pre>
- Docker Registry it is a server that hosts multiple Docker Images
- Usually uses Sonatype Nexus or JFrog Artifactory 
- Local Docker Registry is a just a folder on your system
- Remote & Private Registry, they are servers which could be powered by either Nexus or Artifactory
</pre>  

## Info - Docker Overview
<pre>
- Docker is a Container Engine
- follows Client/Server Architecture
- it comes in 2 flavours
  1. Docker Community Edition - Docker CE
  2. Docker Enterprise Edition - Docker EE
- Docker supports 3 types of Container Registries
  1. Local Docker Registry
  2. Private Docker Registry and
  3. Remote Docker Registry
- it is developed in Go lang by Docker Inc organization
</pre>

## Info - Docker Alternatives
<pre>
- containerd
- Podman
- LXC
</pre>

## Info - Container Orchestration Platforms
- Container Orchestration Platforms helps managing your containerized application workloads
- they manage your applications
- they have inbuilt
  - application monitoring features ( health check, readiness check, liveliness check )
  - it can repair your application when it stops responding
  - it can scale up/down your application instances when the user traffic to application increases/decreases
  - it can help your rollout new application version without any downtime
  - self-healing
  - it support load-balancers
  - it supports exposing your application to internal applications or to external world as services
  - it supports service discovery
  - it supports CI/CD ( Google Kubernetes & Openshift supports this )
  - it supports serverless architecture ( Google Kubernetes & Openshift supports this )
- Examples
  - Docker SWARM 
  - Google Kubernetes
  - Red Hat Openshift

## Lab - Finding docker version
```
docker --version
```
Finding more details about your docker setup
```
docker info
```
Expected output
![image](https://github.com/user-attachments/assets/9d8aba72-f38d-42e0-b29f-66b3f134cccf)
![image](https://github.com/user-attachments/assets/a186542b-510c-49b7-9754-3d9c61660b79)

## Lab - Listing the docker images in the local Docker Registry
```
docker images
```

Expected output
![image](https://github.com/user-attachments/assets/923413f8-cc16-40c2-9aaf-9f3489909a9c)

## Lab - Downloading mysql docker image from Docker Hub Registry to Local Docker Registry
```
docker pull mysql:latest
```

Expected output
![image](https://github.com/user-attachments/assets/efb4c808-cf4c-49c8-8038-01c031f2f5dc)


## Lab - Creating a creating in foreground(interactive) mode
```
docker run -it --name c1 --hostname c1 ubuntu:16.04 /bin/bash
```

Expected output
![image](https://github.com/user-attachments/assets/0627d8ec-a25f-4d36-8641-46d09ec348ec)
![image](https://github.com/user-attachments/assets/5205da11-7fb1-482d-87a8-e8e941c4588c)

Finding the hostname from the container shell
```
hostname
```

Finding the IP address of the c1 container shell
<pre>
hostname -i
</pre>

Listing the files/folders inside the container file system
```
ls -l
```

Installing softwares inside container using the container shell
```
apt update && apt install -y net-tools iputils-ping
```

Expected output
![image](https://github.com/user-attachments/assets/ac80a6c9-46f8-49c7-8fa7-e62fb0be8b90)

Comong out of the container shell
```
exit
```

Expected output
![image](https://github.com/user-attachments/assets/2b268fce-2a9b-4dc5-a976-6e0514519794)

## Lab - Listing the currently running containers
```
docker ps
```

Expected output
![image](https://github.com/user-attachments/assets/93bb981c-2fae-4b32-a87c-d51605c36033)


## Lab - Listing all containers
```
docker ps -a
```
Expected output
![image](https://github.com/user-attachments/assets/c26b6737-ccb7-4d8d-8e9f-9a3cebbbabcc)

## Lab - Starting an existed container and getting inside its container shell
```
docker ps -a
docker start c1
docker exec -it c1 /bin/bash
ls
exit
```

Expected output
![image](https://github.com/user-attachments/assets/d8b95b00-ac82-46a6-9d5f-9e90389f4566)

## Lab - Deleting a running container

In order to delete a running container we must stop it before deleting it or use must force delete it
```
docker ps
docker rm c1
docker stop c1
docker rm c1
docker ps -a
```

Expected output
![image](https://github.com/user-attachments/assets/46836394-9472-4336-bbc3-802c8cdf7668)


## Lab - Coming out of container shell without using exit command

As soon as you execute the below command, you will be taken inside the container shell automatically as we created the container in foreground(interactive) mode using -it(interactive terminal) switch.
```
docker run -it --name c1 --hostname c1 ubuntu:16.04 /bin/bash
```

In order to come out of the container without terminating the container, we need using the shortcut keys Ctrl+P followed by Ctrl+Q.
```
Ctrl + P
Ctrl + Q
```

You can list the containers to see the c1 container is still running while you came outside the conainter shell
```
docker ps
```

Expected output
![image](https://github.com/user-attachments/assets/9cd42930-640e-4ab6-904e-3eeab79023be)

## Lab - Creating a container and running it in the background mode
```
docker run -dit --name c2 --hostname c2 ubuntu:16.04 /bin/bash
docker ps
```

In order to get inside the container shell
```
docker exec -it c2 /bin/bash
ls -l
exit
```

Expected output
![image](https://github.com/user-attachments/assets/a9856e9f-1241-415e-b3c8-da66529fcab7)

## Lab - Stopping and starting multiple containers with single command
```
docker ps
docker stop c1 c2
docker ps
docker ps -a
docker start c1 c2
docker ps
```

Expected output
![image](https://github.com/user-attachments/assets/65d1b017-0bef-4e2b-b751-e1e8bcd474a)

## Lab - Finding an IP address of a running container without getting inside the container shell
```
docker inspect c1
docker inspect c1 | grep IPA
docker inspect -f {{.NetworkSettings.IPAddress}} c1
docker inspect -f {{.NetworkSettings.IPAddress}} c2
```

Expected output
![image](https://github.com/user-attachments/assets/94e538e6-4c08-487f-b691-003b37950e4f)
![image](https://github.com/user-attachments/assets/6a8ac48a-27a7-4537-826e-14fcb318e280)
![image](https://github.com/user-attachments/assets/93ad6446-28c6-4397-864b-1aa8268a2131)
![image](https://github.com/user-attachments/assets/e57338d9-64c6-4b99-b22e-13131192074d)

## Lab - Extracting NetworkID of a container using inspect command
```
docker inspect -f {{.NetworkSettings.Networks.bridge.NetworkID}} c2  
```

Expected output
![image](https://github.com/user-attachments/assets/f10450de-1b49-4248-a4d5-ebcc3547c5fc)

## Lab - Finding more details about a docker image using inspect`
```
docker images
docker image inspect mysql:latest
```

Expected output
![image](https://github.com/user-attachments/assets/76a2a871-393a-4bd6-b8c2-732e3bdfbe69)
![image](https://github.com/user-attachments/assets/c33767d6-2a84-4116-98f0-9f04442f8673)
![image](https://github.com/user-attachments/assets/21282070-a916-4a97-8080-00199b13a2f7)
![image](https://github.com/user-attachments/assets/2e9e0980-140c-44f4-91bd-f846500edc53)

#### Things to note
<pre>
- each Docker Image has one or more layers
- just like each Docker Image has an unique name and ID, docker layers also has an unique ID
- the Docker layers are independent and they can used in multiple Docker Images for reuse
- this is how, docker image format helps in building a small footprint docker images
</pre>

## Lab - Deleting an image from local docker registry
```
docker images
docker rmi mysql:latest
docker images
```

Expected output
![image](https://github.com/user-attachments/assets/f92728f8-4041-4516-b85e-d5e0b9ef5fd7)
![image](https://github.com/user-attachments/assets/49f4970d-2c48-4678-b1ed-8a6918d30e37)

## Lab - Checking the status of docker server service
```
sudo systemctl status docker
```

Expected output
![image](https://github.com/user-attachments/assets/38b12457-124f-47b5-a63f-016d5610ed9e)

## Lab - Renaming a container
```
docker ps
docker rename c1 container-1
docker rename c2 container-2
docker ps
```

Expected output
![image](https://github.com/user-attachments/assets/714d94fd-6c69-44ac-8d6c-aa6134480c23)

## Lab - Creating mysql db server container
```
docker run -d --name db1 --hostname db1 -e MYSQL_ROOT_PASSWORD=root@123 mysql:latest
docker ps
```

Get inside the mysql container shell
```
docker exec -it db1 /bin/sh
```

Connect to the mysql server using mysql client, when prompts for password type 'root@123' without quotes
```
mysql -u root -p
SHOW DATABASES;
CREATE DATABASE tektutor;
USE tektutor;
CREATE TABLE training ( id INT NOT NULL, name VARCHAR(250) NOT NULL, duration VARCHAR(250) NOT NULL, PRIMARY KEY(id) );

DESCRIBE TABLE training;

INSERT INTO training VALUES ( 1, "DevOps", "5 Days" );
INSERT INTO training VALUES ( 2, "Developing Golang Microservices", "5 Days" );
INSERT INTO training VALUES ( 3, "Developing Windows Device Drivers", "5 Days" );

SELECT * FROM training;
exit
exit
```

Expected output
![image](https://github.com/user-attachments/assets/f8b73c26-ffa5-4377-844d-b295005b74a5)
![image](https://github.com/user-attachments/assets/6ef9790b-b0f2-4e17-985d-43188a51bfd6)
![image](https://github.com/user-attachments/assets/250d615e-b3dd-4892-81b1-bf7f0be6d1fe)
![image](https://github.com/user-attachments/assets/50a5d93b-0cb4-44ff-8121-4a33bd3b3373)
