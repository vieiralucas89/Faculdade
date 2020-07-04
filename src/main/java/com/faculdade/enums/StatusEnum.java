package com.faculdade.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusEnum {

    ATIVO(1, "Ativo"),
    INATIVO(2, "Inativo");

    StatusEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int codigo;
    public String descricao;

    public StatusEnum getCodigo(int codigo) {
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
