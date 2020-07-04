package com.faculdade.repository;

import com.faculdade.model.Departamento;
import com.faculdade.repository.fakeRepository.FakeDepartamento;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class DepartamentoRepositoryTest {

    @Mock
    private DepartamentoRepository departamentoRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSelectAllDepartment() {
        assertThatThrownBy(() -> {
            List<Departamento> departamentos = FakeDepartamento.findAll();
            Mockito.when(departamentoRepository.findAll()).thenReturn(departamentos);

            assertThat(departamentos).hasSize(1);
            assertThat(departamentos.get(1)).isNotNull();
        });
    }

    @Test
    public void shouldSelectOneDepartamento() {
        assertThatThrownBy(() -> {
            Optional<Departamento> departamento = FakeDepartamento.creatDepartamento();
            Mockito.when(departamentoRepository.findById(1L)).thenReturn(departamento);

            assertThat(departamento).isNotNull();
            assertThat(departamento.get().getId()).isNotNull();
            assertThat(departamento.get().getId()).isEqualTo(2L);
        });
    }

    @Test
    public void shoulSaveDepartamento() {
        List<Departamento> departamentos = new ArrayList<>();
        departamentos = FakeDepartamento.findAll();

        Departamento newDepartamento = new Departamento();
        newDepartamento.setId(2L);
        newDepartamento.setNome("Matemática");
        departamentos.add(newDepartamento);

        Mockito.when(departamentoRepository.save(newDepartamento)).thenReturn(newDepartamento);
        Mockito.when(departamentoRepository.findById(2L)).thenReturn(Optional.of(newDepartamento));

        Departamento departamentoSalvo = departamentoRepository.findById(2L).get();

        assertThat(departamentoSalvo).isNotNull();
        assertThat(departamentoSalvo).isEqualTo(newDepartamento);
    }

    @Test
    public void ShouldUpdateDepartamento() {
        List<Departamento> departamentos = FakeDepartamento.findAll();
        Departamento departamentoAlterado = departamentos.get(0);
        departamentos.get(0).setNome("Matemática");
        Mockito.when(departamentoRepository.save(departamentoAlterado)).thenReturn(departamentoAlterado);

        assertThat(departamentos.get(0)).isNotNull();
        assertThat(departamentos.get(0)).isEqualTo(departamentoAlterado);
    }

}