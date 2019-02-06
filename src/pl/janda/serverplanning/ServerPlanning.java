package pl.janda.serverplanning;

import java.util.ArrayList;
import java.util.List;

public class ServerPlanning {

    private final Machine serverType;
    private final List<Machine> virtualMachines;

    public ServerPlanning(Machine serverType, List<Machine> virtualMachines) {
        this.serverType = serverType;
        this.virtualMachines = virtualMachines;
    }

    public int calculate() {
        List<MachineResult> machineResults = new ArrayList<>();

        for (int i = 1; i < virtualMachines.size() + 1; i++) {
            machineResults.addAll(combinations(i, virtualMachines));
        }

        List<MachineResult> officialy = new ArrayList<>();
        machineResults.stream().sorted((o1, o2) -> o2.getAmount() - o1.getAmount()).forEachOrdered(machineResult -> {

            if(machineResult.getVirtualMachines().stream().noneMatch(machine -> officialy.stream().anyMatch(official -> official.containMachine(machine)))) {
                officialy.add(machineResult);
            }

        });

        return officialy.size();
    }

    private List<MachineResult> combinations(int n, List<Machine> k) {
        List<MachineResult> machineResults = new ArrayList<>();

        int amountArrays = (int)Math.pow(k.size(), n);
        for(int i = 0; i < amountArrays; i++) {
            machineResults.add(new MachineResult());
        }

        for(int j = 0; j < n; j++) {
            int p = (int) Math.pow(k.size(), n - j - 1);
            for(int i = 0; i < amountArrays; i++) {
                MachineResult c = machineResults.get(i);
                int index = i / p % k.size();

                if(haveSpaceForVirtualMachine(c, k.get(index)))
                    c.tryAddVirtualMachine(k.get(index));
            }
        }

        return machineResults;
    }

    private boolean haveSpaceForVirtualMachine(MachineResult machineResult, Machine virtualMachine) {
        if(serverType.CPU >= machineResult.currentCpuUsage() + virtualMachine.CPU) {
            if (serverType.RAM >= machineResult.currentRamUsage() + virtualMachine.RAM) {
                if (serverType.HDD >= machineResult.currentHddUsage() + virtualMachine.HDD) {
                    return true;
                }
            }
        }
        return false;
    }

}
