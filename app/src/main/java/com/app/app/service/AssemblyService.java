package com.app.app.service;

import com.app.app.simulator.AssemblySimulator;
import org.springframework.stereotype.Service;

@Service
public class AssemblyService {

    public int executeProgram(String program) {
        AssemblySimulator simulator = new AssemblySimulator();
        String[] lines = program.split("\n");

        for (String line : lines) {
            if (line.startsWith("MV")) {
                String[] parts = line.split(" ");
                String register = parts[1].replace(",", "");
                int value = Integer.parseInt(parts[2].replace("#", ""));
                simulator.mv(register, value);
            } else if (line.startsWith("ADD")) {
                String[] parts = line.split(" ");
                String reg1 = parts[1].replace(",", "");
                if (parts[2].startsWith("#")) {
                    int value = Integer.parseInt(parts[2].replace("#", ""));
                    simulator.add(reg1, value);
                } else {
                    String reg2 = parts[2];
                    simulator.add(reg1, reg2);
                }
            }
        }

        // Assuming the SHOW REG statement will always be "SHOW REG"
        return simulator.show("REG1"); // or any register you want to show
    }
}
