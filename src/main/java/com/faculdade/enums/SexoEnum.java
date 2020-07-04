package com.faculdade.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SexoEnum {

    MASCULINO(1, "Masculino"),
    FEMININO(2, "Femenino");

    SexoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int codigo;
    public String descricao;

    public SexoEnum getCodigo(int codigo) {
        return Stream.of(values())
                .filter(fil -> fil.codigo == codigo)
                .findAny()
                .orElse(null);
    }

    @JsonValue
    public int getCodigo() {
        return codigo;
    }

}
