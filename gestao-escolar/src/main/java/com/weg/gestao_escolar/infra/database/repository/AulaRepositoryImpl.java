package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Aula;
import com.weg.gestao_escolar.domain.repository.AulaRepository;
import com.weg.gestao_escolar.infra.database.connection.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AulaRepositoryImpl implements AulaRepository {
    @Override
    public Aula save(Aula aula) throws SQLException {
        String query = """
            INSERT INTO aula (
              turma_id
            , data_hora
            , assunto
            ) VALUES (?, ?, ?)
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setLong(1, aula.getTurmaId());
            stmt.setObject(2, aula.getDataHora());
            stmt.setString(3, aula.getAssunto());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    aula.setId(rs.getInt(1));
                }
                return aula;
            }
        }
    }

    @Override
    public Aula findById(int id) throws SQLException {
        String query = """
            SELECT 
              id
            , turma_id
            , data_hora
            , assunto
            FROM 
            aula
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    int idEncontrado = rs.getInt("id");
                    int turmaId = rs.getInt("turma_id");
                    LocalDate dataHora = rs.getObject("data_hora", LocalDate.class);
                    String assunto = rs.getString("assunto");

                    return new Aula(idEncontrado, turmaId, dataHora, assunto);
                }
                return null;
            }
        }
    }

    @Override
    public List<Aula> findAll() throws SQLException {
        String query = """
            SELECT 
              id
            , turma_id
            , data_hora
            , assunto
            FROM 
            aula
            """;

        List<Aula> listAula = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    int turmaId = rs.getInt("turma_id");
                    LocalDate dataHora = rs.getObject("data_hora", LocalDate.class);
                    String assunto = rs.getString("assunto");

                    Aula aula = new Aula(id, turmaId, dataHora, assunto);

                    listAula.add(aula);

                }
                return listAula;
            }
        }
    }

    @Override
    public void update(Aula aula) throws SQLException {
        String query = """
            UPDATE aula SET 
              turma_id = ?
            , data_hora = ?
            , assunto = ?
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, aula.getTurmaId());
            stmt.setObject(2, aula.getDataHora());
            stmt.setString(3, aula.getAssunto());
            stmt.setInt(4, aula.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
            DELETE FROM aula 
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Aula> findByTurmaId(int turmaId) throws SQLException {
        String query = """
            SELECT 
              id
            , turma_id
            , data_hora
            , assunto
            FROM 
            aula
            WHERE turma_id = ?
            """;

        List<Aula> listAula = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, turmaId);

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    int tId = rs.getInt("turma_id");
                    LocalDate dataHora = rs.getObject("data_hora", LocalDate.class);
                    String assunto = rs.getString("assunto");

                    Aula aula = new Aula(id, tId, dataHora, assunto);

                    listAula.add(aula);
                }
                return listAula;
            }
        }
    }
}
