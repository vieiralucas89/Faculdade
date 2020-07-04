package com.faculdade.service;

import com.faculdade.model.Departamento;
import com.faculdade.repository.DepartamentoRepository;
import com.faculdade.repository.fakeRepository.FakeDepartamento;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class DepartamentoServiceTest {

    @InjectMocks
    private DepartamentoService departamentoService;

    @Mock
    private DepartamentoRepository departamentoRepository;


    @Test
    public void shouldSelectAllDepartment() {
        Departamento departamento = FakeDepartamento.creatDepartamento().get();
        ImmutableList<Departamento> departamentos = new ImmutableList.Builder<Departamento>()
                .add(departamento).build();

        Mockito.when(departamentoRepository.findAll()).thenReturn(departamentos);

        List<Departamento> allDepartmens = departamentoService.finAllDepartamentos();
        assertThat(allDepartmens).hasSize(1);
    }

    @Test
    public void shouldSelectDepartmentById() {
        Departamento newDepartamento = FakeDepartamento.creatDepartamento().get();
        newDepartamento.setId(2L);

        ImmutableList<Departamento> departamentos = new ImmutableList.Builder<Departamento>()
                .add(newDepartamento).build();
        Mockito.when(departamentoRepository.findAll()).thenReturn(departamentos);

        List<Departamento> allDepartment = departamentoService.finAllDepartamentos();
        assertThat(allDepartment).hasSize(1);

    }

    @Test
    public void shoulSalvar() {
        Optional<Departamento> departamento = FakeDepartamento.creatDepartamento();

        Mockito.when(departamentoRepository.findById(1L)).thenReturn(departamento);
        Mockito.when(departamentoRepository.save(departamento.get())).thenReturn(departamento.get());

        Departamento updateResult = departamentoService.editar(departamento.get());
        assertThat(updateResult).isNotNull();
        assertThat(updateResult).isEqualTo(updateResult);
    }

    @Test
    public void editar() {
        Departamento departamento = FakeDepartamento.creatDepartamento().get();

        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.of(departamento));
        Mockito.when(departamentoRepository.save(departamento)).thenReturn(departamento);

        Departamento departamentoAlterado = departamentoService.editar(departamento);

        assertThat(departamentoAlterado).isEqualTo(departamento);
    }

}