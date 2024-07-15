# Day 1

## Info - Hypervisor Overview
<pre>
- is virtualization software
- with virtualization software, we can run multiple Operating Systems in the laptop/desktop/workstation/server
- many OS can run simultaneously
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

## Info - What is Container Runtime?

## Info - What is Container Engine?

## Info - Docker Overview

## Info - Docker Alternatives

