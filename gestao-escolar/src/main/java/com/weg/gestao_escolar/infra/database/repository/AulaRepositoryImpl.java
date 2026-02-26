package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Aula;
import com.weg.gestao_escolar.domain.repository.AulaRepository;

import java.sql.SQLException;
import java.util.List;

public class AulaRepositoryImpl implements AulaRepository {
    @Override
    public Aula save(Aula aula) throws SQLException {
        return null;
    }

    @Override
    public Aula findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Aula> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Aula aula) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public List<Aula> findByTurmaId(Long turmaId) throws SQLException {
        return List.of();
    }
}
