package com.weg.gestao_escolar.domain.repository;

import com.weg.gestao_escolar.domain.model.Professor;

import java.sql.SQLException;
import java.util.List;

public interface ProfessorRepository {
    Professor save(Professor professor) throws SQLException;
    Professor findById(int id) throws SQLException;
    List<Professor> findAll() throws SQLException;
    void update(Professor professor) throws SQLException;
    void delete(int id) throws SQLException;
}
