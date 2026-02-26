package com.weg.gestao_escolar.domain.repository;

import com.weg.gestao_escolar.domain.model.Nota;

import java.sql.SQLException;
import java.util.List;

public interface NotaRepository {
    Nota save(Nota nota) throws SQLException;
    Nota findById(int id) throws SQLException;
    List<Nota> findAll() throws SQLException;
    void update(Nota nota) throws SQLException;
    void delete(int id) throws SQLException;

    List<Nota> findByAlunoId(int alunoId) throws SQLException;
    List<Nota> findByAulaId(int aulaId) throws SQLException;
}
