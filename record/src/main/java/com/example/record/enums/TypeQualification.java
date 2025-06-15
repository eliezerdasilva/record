package com.example.record.enums;

public enum TypeQualification {
	A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
	AB("AB"),
    AC("AC"),
    AD("AD"),
    AE("AE");
   
    private final String descricao;

    TypeQualification (String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

