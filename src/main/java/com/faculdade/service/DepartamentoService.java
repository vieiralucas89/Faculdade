package com.faculdade.service;

import com.faculdade.model.Departamento;
import com.faculdade.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository repository) {
        departamentoRepository = repository;
    }

    public List<Departamento> finAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento buscarPorId(Long idDepartamento) {
        return departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new IllegalArgumentException("Departamento não foi encontrado."));
    }

    public void salvar(Departamento departamento) {
        validarCamposObrigatoriosDepartamento(Optional.of(departamento));
        departamentoRepository.save(departamento);
    }

    public Departamento editar(Departamento departamento) {
        Optional.of(buscarPorId(departamento.getId()))
                .map(departamentoAlerado -> {
                    departamentoAlerado.setNome(departamento.getNome());
                    return ResponseEntity.ok().body(departamentoRepository.save(departamento));
                }).orElse(ResponseEntity.notFound().build());
        return departamento;
    }

    private void validarCamposObrigatoriosDepartamento(Optional<Departamento> departamento) {
        if (departamento.isEmpty()) {
            throw new IllegalArgumentException("Algum campo do Departamento está vazio.");
        }
    }
}
