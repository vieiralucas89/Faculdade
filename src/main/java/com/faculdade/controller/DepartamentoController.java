package com.faculdade.controller;

import com.faculdade.model.Departamento;
import com.faculdade.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/{idDepartamento}")
    public Departamento buscarPorId(@PathVariable("idDepartamento") Long idDepartamento) {
        return departamentoService.buscarPorId(idDepartamento);
    }

    @GetMapping
    public List<Departamento> lista() {
        return departamentoService.finAllDepartamentos();
    }

    @PostMapping
    public void salvar(@RequestBody Departamento departamento) {
        departamentoService.salvar(departamento);
    }

    @PutMapping
    public void editar(@RequestBody Departamento departamento) {
        departamentoService.editar(departamento);
    }


}
