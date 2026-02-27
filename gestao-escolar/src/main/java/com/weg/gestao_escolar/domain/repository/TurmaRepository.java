package com.weg.gestao_escolar.domain.repository;

import com.weg.gestao_escolar.domain.model.Aluno;
import com.weg.gestao_escolar.domain.model.Turma;

import java.sql.SQLException;
import java.util.List;

public interface TurmaRepository {
    Turma save(Turma turma) throws SQLException;
    Turma findById(int id) throws SQLException;
    List<Turma> findAll() throws SQLException;
    void update(Turma turma) throws SQLException;
    void delete(int id) throws SQLException;

    //turma_aluno
    void matricularAluno(int turmaId, int alunoId) throws SQLException;
    void removerAlunoDaTurma(int turmaId, int alunoId) throws SQLException;
    List<Aluno> findAlunosByTurmaId(int turmaId) throws SQLException;
}
