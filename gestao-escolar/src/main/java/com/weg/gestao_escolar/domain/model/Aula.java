package com.weg.gestao_escolar.domain.model;

import java.time.LocalDate;

public class Aula {
    private int id;
    private int turmaId;
    private LocalDate dataNascimento;
    private String assunto;

    public Aula(String assunto, LocalDate dataNascimento, int turmaId) {
        this.assunto = assunto;
        this.dataNascimento = dataNascimento;
        this.turmaId = turmaId;
    }

    public Aula(int id, int turmaId, LocalDate dataNascimento, String assunto) {
        this.id = id;
        this.turmaId = turmaId;
        this.dataNascimento = dataNascimento;
        this.assunto = assunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(int turmaId) {
        this.turmaId = turmaId;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
