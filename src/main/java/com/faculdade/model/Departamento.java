package com.faculdade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "intranet", name = "departamento")
@Getter
@Setter
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_iddepartamento")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;

    @OneToMany
    @JoinColumn(name = "pk_idprofessor")
    private List<Professor> professores = new ArrayList<>();

    @OneToMany(mappedBy = "departamento")
    private List<Curso> cursos = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "pk_iddisciplina")
    private List<Disciplina> disciplinas = new ArrayList<>();

}
