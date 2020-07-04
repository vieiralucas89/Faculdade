package com.faculdade.controller;

import com.faculdade.model.Professor;
import com.faculdade.service.ProfessoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessoreService professoreService;

    @GetMapping
    public List<Professor> lista() {
        return professoreService.listar();
    }

    @PostMapping
    public void salvarDepartamento(@RequestBody Professor professor) {
        professoreService.salvar(professor);
    }


}
