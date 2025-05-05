package com.example.record.enums;

public enum UserCategory {
	ADMIN("Administrador"),
    DRIVER("Motorista");
    

    private final String descricao;

    UserCategory (String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
