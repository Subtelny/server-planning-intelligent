package pl.janda.serverplanning;

public class Machine {

    final int CPU;
    final int RAM;
    final int HDD;

    Machine(int cpu, int ram, int hdd) {
        CPU = cpu;
        RAM = ram;
        HDD = hdd;
    }
}