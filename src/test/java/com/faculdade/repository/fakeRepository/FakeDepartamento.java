package com.faculdade.repository.fakeRepository;

import com.faculdade.model.Departamento;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
public class FakeDepartamento {

    private List<Departamento> departamentos;

    public FakeDepartamento() {
        departamentos = new ArrayList<>();
    }

    public static Optional<Departamento> creatDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setId(1L);
        departamento.setNome("TI");
        return Optional.of(departamento);
    }

    public static List<Departamento> findAll() {
        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(creatDepartamento().get());
        return departamentos;
    }

    public static Departamento findById() {
        return findAll().get(1);
    }

    public static List<Departamento> addDepartmentInList(Departamento departamento) {
        List<Departamento> departamentos = findAll();
        departamentos.add(departamento);
        return departamentos;
    }

    public static List<Departamento> updateDepartment(Departamento departamento, Long id) {
        List<Departamento> departamentos = findAll();
        return departamentos.stream().map(val -> {
            if (val.getId().equals(departamento.getId())) {
                val.setNome("Matemática");
                return val;
            }
            return val;
        }).collect(Collectors.toList());

    }
}
