package com.faculdade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "intranet", name = "disciplina")
@Getter
@Setter
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_iddisciplina")
    private Long id;

    @Column(name = "nm_disciplina")
    private String nome;

    @Column(name = "tx_descricao")
    private String descricao;

    @Column(name = "nm_cargahoraria")
    private Integer cargaHoraria;

    @ManyToMany(mappedBy = "disciplinasMinistradas")
    private List<Professor> professores = new ArrayList<>();

    @ManyToMany(mappedBy = "disciplinas")
    private List<Curso> cursos = new ArrayList<>();
}
