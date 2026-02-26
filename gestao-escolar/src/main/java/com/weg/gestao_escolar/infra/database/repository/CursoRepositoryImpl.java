package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Curso;
import com.weg.gestao_escolar.domain.repository.CursoRepository;
import com.weg.gestao_escolar.infra.database.connection.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryImpl implements CursoRepository {
    @Override
    public Curso save(Curso curso) throws SQLException {
        String query = """
            INSERT INTO curso (
              nome
            , codigo
            ) VALUES (?, ?)
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    curso.setId(rs.getInt(1));
                }
                return curso;
            }
        }
    }

    @Override
    public Curso findById(int id) throws SQLException {
        String query = """
            SELECT 
              id
            , nome
            , codigo
            FROM 
            curso
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    int idEncontrado = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String codigo = rs.getString("codigo");

                    return new Curso(idEncontrado, nome, codigo);
                }
                return null;
            }
        }
    }

    @Override
    public List<Curso> findAll() throws SQLException {
        String query = """
            SELECT 
              id
            , nome
            , codigo
            FROM 
            curso
            """;

        List<Curso> listCurso = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String codigo = rs.getString("codigo");

                    Curso curso = new Curso(id, nome, codigo);

                    listCurso.add(curso);

                }
                return listCurso;
            }
        }
    }

    @Override
    public void update(Curso curso) throws SQLException {
        String query = """
            UPDATE curso SET 
              nome = ?
            , codigo = ?
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.setInt(3, curso.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
            DELETE FROM curso 
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}
