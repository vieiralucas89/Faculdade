package com.faculdade.service;

import com.faculdade.model.Professor;
import com.faculdade.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessoreService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    public void salvar(Professor professor) {
        validaCamposObrigatorios(professor);
        professorRepository.save(professor);
    }

    private void validaCamposObrigatorios(Professor professor) {

    }
}
