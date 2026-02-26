package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Aluno;
import com.weg.gestao_escolar.domain.model.Turma;
import com.weg.gestao_escolar.domain.repository.TurmaRepository;

import java.sql.SQLException;
import java.util.List;

public class TurmaRepositoryImpl implements TurmaRepository {
    @Override
    public Turma save(Turma turma) throws SQLException {
        return null;
    }

    @Override
    public Turma findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Turma> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Turma turma) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public void matricularAluno(Long turmaId, Long alunoId) throws SQLException {

    }

    @Override
    public void removerAlunoDaTurma(Long turmaId, Long alunoId) throws SQLException {

    }

    @Override
    public List<Aluno> findAlunosByTurmaId(Long turmaId) throws SQLException {
        return List.of();
    }
}
