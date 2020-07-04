package com.faculdade.model;

import com.faculdade.enums.SexoEnum;
import com.faculdade.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "intranet", name = "aluno")
@Getter
@Setter
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_idaluno")
    private Long id;

    @Column(name = "nm_aluno")
    private String nome;

    @Column(name = "tx_cpf")
    private String cpf;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusEnum status;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "sexo")
    private SexoEnum sexoEnum;

    @ManyToOne
    @JoinColumn(name = "pk_idturma")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "pk_idcurso")
    private Curso curso;

}
