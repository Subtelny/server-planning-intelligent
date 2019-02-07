This simple library calculate how many servers (with specifed configuration) is needed to host a specifed amount of virtual machines.
Using combinatoric algorithm, calculate the most optimized way to get a smallest number of needed servers.

<hr>

Difference between "intelligent" and "first fit" strategy:

Example:
<ul>
    <li>
    Server type = <code>{CPU: 2, RAM: 32, HDD: 100}</code>
    </li>
    <li>
    Virtual Machines = <code>[{CPU: 1, RAM: 10, HDD: 10},
                              {CPU: 1, RAM: 24, HDD: 10}, 
                              {CPU: 1, RAM: 32, HDD: 10}, 
                              {CPU: 1, RAM: 16, HDD: 10}, 
                              {CPU: 1, RAM: 8, HDD: 10}]</code>
    </li>
</ul>

First fit:
<ul>
    <li>
    Result = 4
    </li>
</ul>
    
Intelligent:
<ul>
    <li>
    Result = 3
    </li>
</ul>

<hr>
Usage:
<br>
<pre>
ServerPlanning planning = new ServerPlanning(serverType, virtualMachines...);
int serversAmount = planning.calculate();
</pre>
