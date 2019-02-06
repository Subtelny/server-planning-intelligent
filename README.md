This simple library calculate how many servers (with specifed configuration) is needed to host a specifed amount of virtual machines.
Using combinatoric algorithm, calculate the most optimized way to get a smallest number of needed servers.

Difference between "intelligent" and "first fit" strategy:

Example:
    - Server type = {CPU: 2, RAM: 32, HDD: 100}
    - Virtual Machines = [{CPU: 1, RAM: 10, HDD: 10},
                          {CPU: 1, RAM: 24, HDD: 10}, 
                          {CPU: 1, RAM: 32, HDD: 10}, 
                          {CPU: 1, RAM: 16, HDD: 10}, 
                          {CPU: 1, RAM: 8, HDD: 10}]

First fit:
    - Result = 4
    
Intelligent:
    - Result = 3