package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Aluno;
import com.weg.gestao_escolar.domain.model.Turma;
import com.weg.gestao_escolar.domain.repository.TurmaRepository;
import com.weg.gestao_escolar.infra.database.connection.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepositoryImpl implements TurmaRepository {
    @Override
    public Turma save(Turma turma) throws SQLException {
        String query = """
            INSERT INTO turma (
              nome
            , curso_id
            , professor_id
            ) VALUES (?, ?, ?)
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCursoId());
            stmt.setInt(3, turma.getProfessorId());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    turma.setId(rs.getInt(1));
                }
                return turma;
            }
        }
    }

    @Override
    public Turma findById(int id) throws SQLException {
        String query = """
            SELECT 
              id
            , nome
            , curso_id
            , professor_id
            FROM 
            turma
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    int idEncontrado = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int cursoId = rs.getInt("curso_id");
                    int professorId = rs.getInt("professor_id");

                    return new Turma(idEncontrado, nome, cursoId, professorId);
                }
                return null;
            }
        }
    }

    @Override
    public List<Turma> findAll() throws SQLException {
        String query = """
            SELECT 
              id
            , nome
            , curso_id
            , professor_id
            FROM 
            turma
            """;

        List<Turma> listTurma = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int cursoId = rs.getInt("curso_id");
                    int professorId = rs.getInt("professor_id");

                    Turma turma = new Turma(id, nome, cursoId, professorId);

                    listTurma.add(turma);

                }
                return listTurma;
            }
        }
    }

    @Override
    public void update(Turma turma) throws SQLException {
        String query = """
            UPDATE turma SET 
              nome = ?
            , curso_id = ?
            , professor_id = ?
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCursoId());
            stmt.setInt(3, turma.getProfessorId());
            stmt.setInt(4, turma.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
            DELETE FROM turma 
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void matricularAluno(int turmaId, int alunoId) throws SQLException {
        String query = """
            INSERT INTO turma_aluno (
              turma_id
            , aluno_id
            ) VALUES (?, ?)
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, turmaId);
            stmt.setInt(2, alunoId);

            stmt.executeUpdate();
        }
    }

    @Override
    public void removerAlunoDaTurma(int turmaId, int alunoId) throws SQLException {
        String query = """
            DELETE FROM turma_aluno 
            WHERE turma_id = ? AND aluno_id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, turmaId);
            stmt.setInt(2, alunoId);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Aluno> findAlunosByTurmaId(int turmaId) throws SQLException {
        String query = """
            SELECT 
              a.id
            , a.nome
            , a.email
            , a.matricula
            , a.data_nascimento
            FROM 
            aluno a
            INNER JOIN turma_aluno ta ON a.id = ta.aluno_id
            WHERE ta.turma_id = ?
            """;

        List<Aluno> listAluno = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, turmaId);

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String matricula = rs.getString("matricula");
                    LocalDate dataNascimento = rs.getObject("data_nascimento", LocalDate.class);

                    Aluno aluno = new Aluno(id, nome, email, matricula, dataNascimento);

                    listAluno.add(aluno);
                }
                return listAluno;
            }
        }
    }
}
