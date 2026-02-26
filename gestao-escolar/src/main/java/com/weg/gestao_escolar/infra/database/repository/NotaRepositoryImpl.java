package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Nota;
import com.weg.gestao_escolar.domain.repository.NotaRepository;

import java.sql.SQLException;
import java.util.List;

public class NotaRepositoryImpl implements NotaRepository {
    @Override
    public Nota save(Nota nota) throws SQLException {
        return null;
    }

    @Override
    public Nota findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Nota> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Nota nota) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public List<Nota> findByAlunoId(Long alunoId) throws SQLException {
        return List.of();
    }

    @Override
    public List<Nota> findByAulaId(Long aulaId) throws SQLException {
        return List.of();
    }
}
