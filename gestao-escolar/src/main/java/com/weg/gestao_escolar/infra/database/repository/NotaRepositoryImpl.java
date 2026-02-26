package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Nota;
import com.weg.gestao_escolar.domain.repository.NotaRepository;
import com.weg.gestao_escolar.infra.database.connection.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotaRepositoryImpl implements NotaRepository {
    @Override
    public Nota save(Nota nota) throws SQLException {
        String query = """
            INSERT INTO nota (
              aluno_id
            , aula_id
            , valor
            ) VALUES (?, ?, ?)
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setLong(1, nota.getAlunoId());
            stmt.setLong(2, nota.getAulaId());
            stmt.setDouble(3, nota.getValor());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    nota.setId(rs.getInt(1));
                }
                return nota;
            }
        }
    }

    @Override
    public Nota findById(int id) throws SQLException {
        String query = """
            SELECT 
              id
            , aluno_id
            , aula_id
            , valor
            FROM 
            nota
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    int idEncontrado = rs.getInt("id");
                    int alunoId = rs.getInt("aluno_id");
                    int aulaId = rs.getInt("aula_id");
                    double valor = rs.getDouble("valor");

                    return new Nota(idEncontrado, alunoId, aulaId, valor);
                }
                return null;
            }
        }
    }

    @Override
    public List<Nota> findAll() throws SQLException {
        String query = """
            SELECT 
              id
            , aluno_id
            , aula_id
            , valor
            FROM 
            nota
            """;

        List<Nota> listNota = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    int alunoId = rs.getInt("aluno_id");
                    int aulaId = rs.getInt("aula_id");
                    double valor = rs.getDouble("valor");

                    Nota nota = new Nota(id, alunoId, aulaId, valor);

                    listNota.add(nota);

                }
                return listNota;
            }
        }
    }

    @Override
    public void update(Nota nota) throws SQLException {
        String query = """
            UPDATE nota SET 
              aluno_id = ?
            , aula_id = ?
            , valor = ?
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, nota.getAlunoId());
            stmt.setInt(2, nota.getAulaId());
            stmt.setDouble(3, nota.getValor());
            stmt.setInt(4, nota.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
            DELETE FROM nota 
            WHERE id = ?
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Nota> findByAlunoId(int alunoId) throws SQLException {
        String query = """
            SELECT 
              id
            , aluno_id
            , aula_id
            , valor
            FROM 
            nota
            WHERE aluno_id = ?
            """;

        List<Nota> listNota = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, alunoId);

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    int aId = rs.getInt("aluno_id");
                    int aulaId = rs.getInt("aula_id");
                    double valor = rs.getDouble("valor");

                    Nota nota = new Nota(id, aId, aulaId, valor);

                    listNota.add(nota);
                }
                return listNota;
            }
        }
    }

    @Override
    public List<Nota> findByAulaId(int aulaId) throws SQLException {
        String query = """
            SELECT 
              id
            , aluno_id
            , aula_id
            , valor
            FROM 
            nota
            WHERE aula_id = ?
            """;

        List<Nota> listNota = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, aulaId);

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    int alunoId = rs.getInt("aluno_id");
                    int aId = rs.getInt("aula_id");
                    double valor = rs.getDouble("valor");

                    Nota nota = new Nota(id, alunoId, aId, valor);

                    listNota.add(nota);
                }
                return listNota;
            }
        }
    }
}
