package com.weg.gestao_escolar.infra.database.repository;

import com.weg.gestao_escolar.domain.model.Aluno;
import com.weg.gestao_escolar.domain.repository.AlunoRepository;
import com.weg.gestao_escolar.infra.database.connection.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {

    private final AlunoRepository alunoRepository;

    public AlunoRepositoryImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno save(Aluno aluno) throws SQLException {
        String query = """
            INSERT INTO aluno (nome, email, matricula, data_nascimento) 
            VALUES (?, ?, ?, ?)
            """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setObject(4, aluno.getDataNascimento());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()){
                    aluno.setId(rs.getInt(1));
                }
            }
            return aluno;
        }
    }

    @Override
    public Aluno findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Aluno> findAll() throws SQLException {
        String query = """
                SELECT 
                  id
                , nome
                , email
                , matricula
                , data_nascimento
                FROM 
                aluno
                """;

        List<Aluno> listAluno = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

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

    @Override
    public void update(Aluno aluno) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
