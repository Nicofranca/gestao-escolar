package com.weg.gestao_escolar.domain.repository;

import com.weg.gestao_escolar.domain.model.Aula;

import java.sql.SQLException;
import java.util.List;

public interface AulaRepository {
    Aula save(Aula aula) throws SQLException;
    Aula findById(int id) throws SQLException;
    List<Aula> findAll() throws SQLException;
    void update(Aula aula) throws SQLException;
    void delete(int id) throws SQLException;
    List<Aula> findByTurmaId(int turmaId) throws SQLException;
}
