package com.faculdade.model;

import com.faculdade.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "intranet", name = "professor")
@Getter
@Setter
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_idprofessor")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "nm_sobrenome")
    private String sobreNome;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusEnum status;

    @ManyToMany
    @JoinTable(
            name = "prof_disciplina",
            joinColumns = @JoinColumn(name = "pk_idprofessor"),
            inverseJoinColumns = @JoinColumn(name = "pk_iddisciplina")
    )
    private List<Disciplina> disciplinasMinistradas = new ArrayList<>();

}
