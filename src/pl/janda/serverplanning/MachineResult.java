package pl.janda.serverplanning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MachineResult {

    private List<Machine> virtualMachines;

    MachineResult() {
        virtualMachines = new ArrayList<>();
    }

    List<Machine> getVirtualMachines() {
        return virtualMachines;
    }

    int getAmount() {
        return virtualMachines.size();
    }

    int currentCpuUsage() {
        return virtualMachines.stream().flatMapToInt(i -> IntStream.of(i.CPU)).sum();
    }

    int currentRamUsage() {
        return virtualMachines.stream().flatMapToInt(i -> IntStream.of(i.RAM)).sum();
    }

    int currentHddUsage() {
        return virtualMachines.stream().flatMapToInt(i -> IntStream.of(i.HDD)).sum();
    }

    void tryAddVirtualMachine(Machine machine) {
        if(!virtualMachines.contains(machine))
            virtualMachines.add(machine);
    }

    boolean containMachine(Machine machine) {
        return virtualMachines.stream().anyMatch(i -> i == machine);
    }

}