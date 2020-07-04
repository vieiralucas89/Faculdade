package com.faculdade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "intranet", name = "turma")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_idturma")
    private Long id;

    @Column(name = "nm_turma")
    private String nome;

    @Column(name = "periodo")
    private Integer periodo;

    @Column(name = "data_ini")
    private LocalDate data_ini;

    @Column(name = "data_fim")
    private LocalDate data_fim;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();

}
