package com.weg.gestao_escolar.domain.repository;

import com.weg.gestao_escolar.domain.model.Curso;

import java.sql.SQLException;
import java.util.List;

public interface CursoRepository {
    Curso save(Curso curso) throws SQLException;
    Curso findById(int id) throws SQLException;
    List<Curso> findAll() throws SQLException;
    void update(Curso curso) throws SQLException;
    void delete(int id) throws SQLException;
}
