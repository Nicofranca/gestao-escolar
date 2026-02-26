package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Professor;
import com.weg.gestao_escolar.domain.repository.ProfessorRepository;

import java.sql.SQLException;
import java.util.List;

public class ProfessorRepositoryImpl implements ProfessorRepository {
    @Override
    public Professor save(Professor professor) throws SQLException {
        return null;
    }

    @Override
    public Professor findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Professor> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Professor professor) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
