This simple library calculate how many servers (with specifed configuration) is needed to host a specifed amount of virtual machines.
Using combinatoric algorithm, calculate the most optimized way to get a smallest number of needed servers.

*Its just quest for 
<hr>

Difference between "intelligent" and "first fit" strategy:

Example:
<ul>
    <li>
        Server type = {CPU: 2, RAM: 32, HDD: 100}
    </li>
    <li>
    Virtual Machines = <code>[{CPU: 1, RAM: 10, HDD: 10},
                              {CPU: 1, RAM: 24, HDD: 10}, 
                              {CPU: 1, RAM: 32, HDD: 10}, 
                              {CPU: 1, RAM: 16, HDD: 10}, 
                              {CPU: 1, RAM: 8, HDD: 10}]</code>
    </li>
</ul>

<b>First fit:</b>
<ul>
    <li>
    Result = 4
    </li>
</ul>
    
<b>Intelligent:</b>
<ul>
    <li>
    Result = 3
    </li>
</ul>
