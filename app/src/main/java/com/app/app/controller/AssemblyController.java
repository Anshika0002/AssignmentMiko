package com.app.app.controller;

import com.app.app.model.ProgramResult;
import com.app.app.repository.ProgramResultRepository;
import com.app.app.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AssemblyController {

    @Autowired
    private AssemblyService assemblyService;

    @Autowired
    private ProgramResultRepository repository;

    @PostMapping("/execute")
    public ProgramResult executeProgram(@RequestBody String program) {
        int result = assemblyService.executeProgram(program);
        ProgramResult programResult = new ProgramResult();
        programResult.setProgram(program);
        programResult.setResult(result);
        repository.save(programResult);
        return programResult;
    }
}
