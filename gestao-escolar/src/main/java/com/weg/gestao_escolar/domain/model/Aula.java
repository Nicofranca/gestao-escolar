package com.weg.gestao_escolar.domain.model;

import java.time.LocalDate;

public class Aula {
    private int id;
    private int turmaId;
    private LocalDate dataHora;
    private String assunto;

    public Aula(String assunto, LocalDate dataNascimento, int turmaId) {
        this.assunto = assunto;
        this.dataHora = dataNascimento;
        this.turmaId = turmaId;
    }

    public Aula(int id, int turmaId, LocalDate dataNascimento, String assunto) {
        this.id = id;
        this.turmaId = turmaId;
        this.dataHora = dataNascimento;
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

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
