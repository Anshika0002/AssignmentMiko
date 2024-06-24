package com.app.app.simulator;

import java.util.HashMap;
import java.util.Map;

public class AssemblySimulator {
    private Map<String, Integer> registers = new HashMap<>();

    public void mv(String register, int value) {
        registers.put(register, value);
    }

    public void add(String reg1, String reg2) {
        int value1 = registers.getOrDefault(reg1, 0);
        int value2 = registers.getOrDefault(reg2, 0);
        registers.put(reg1, value1 + value2);
    }

    public void add(String reg, int value) {
        int regValue = registers.getOrDefault(reg, 0);
        registers.put(reg, regValue + value);
    }

    public int show(String reg) {
        return registers.getOrDefault(reg, 0);
    }
}
