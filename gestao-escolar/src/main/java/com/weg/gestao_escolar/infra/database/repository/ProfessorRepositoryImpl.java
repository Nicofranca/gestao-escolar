package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Professor;
import com.weg.gestao_escolar.domain.repository.ProfessorRepository;
import com.weg.gestao_escolar.infra.database.connection.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {
    @Override
    public Professor save(Professor professor) throws SQLException {
        String query = """
            INSERT INTO professor (
              nome
            , email
            , disciplina
            ) VALUES (?, ?, ?)
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    professor.setId(rs.getInt(1));
                }
                return professor;
            }
        }
    }

    @Override
    public Professor findById(int id) throws SQLException {
        String query = """
            SELECT 
              id
            , nome
            , email
            , disciplina
            FROM 
            professor
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    int idEncontrado = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String disciplina = rs.getString("disciplina");

                    return new Professor(idEncontrado, nome, email, disciplina);
                }
                return null;
            }
        }
    }

    @Override
    public List<Professor> findAll() throws SQLException {
        String query = """
            SELECT 
              id
            , nome
            , email
            , disciplina
            FROM 
            professor
            """;

        List<Professor> listProfessor = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String disciplina = rs.getString("disciplina");

                    Professor professor = new Professor(id, nome, email, disciplina);

                    listProfessor.add(professor);

                }
                return listProfessor;
            }
        }
    }

    @Override
    public void update(Professor professor) throws SQLException {
        String query = """
            UPDATE professor SET 
              nome = ?
            , email = ?
            , disciplina = ?
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
            DELETE FROM professor 
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}
