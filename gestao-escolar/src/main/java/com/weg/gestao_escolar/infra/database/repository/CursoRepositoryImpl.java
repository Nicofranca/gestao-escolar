package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Curso;
import com.weg.gestao_escolar.domain.repository.CursoRepository;

import java.sql.SQLException;
import java.util.List;

public class CursoRepositoryImpl implements CursoRepository {
    @Override
    public Curso save(Curso curso) throws SQLException {
        return null;
    }

    @Override
    public Curso findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Curso> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Curso curso) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
