package com.faculdade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "intranet", name = "curso")
@Getter
@Setter
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_idcurso")
    private Long id;

    @Column(name = "nm_curso")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pk_iddepartamento")
    private Departamento departamento;

    @ManyToMany
    @JoinTable(
            name = "curs_disc",
            joinColumns = @JoinColumn(name = "pk_idcurso"),
            inverseJoinColumns = @JoinColumn(name = "pk_iddisciplina")
    )
    private List<Disciplina> disciplinas = new ArrayList<>();

}
