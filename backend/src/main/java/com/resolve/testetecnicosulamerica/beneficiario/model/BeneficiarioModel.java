package com.resolve.testetecnicosulamerica.beneficiario.model;

import java.time.LocalDate;

public class BeneficiarioModel {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
