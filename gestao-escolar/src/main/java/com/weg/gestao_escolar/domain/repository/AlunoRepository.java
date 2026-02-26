package com.weg.gestao_escolar.domain.repository;

import com.weg.gestao_escolar.domain.model.Aluno;

import java.sql.SQLException;
import java.util.List;

public interface AlunoRepository {
    Aluno save(Aluno aluno) throws SQLException;
    Aluno findById(int id) throws SQLException;
    List<Aluno> findAll() throws SQLException;
    void update(Aluno aluno) throws SQLException;
    void delete(int id) throws SQLException;
}
