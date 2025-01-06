package DAO;

import Conexao.ConexaoSysHotel;
import SistemaHotel.Hospedes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de CRUD na tabela hospedes do banco de dados.
 */
public class HospedesDAO {

    // Atributo de conexão com o banco de dados.
    private Connection connection;

    /**
     * Construtor da classe HospedesDAO.
     */
    public HospedesDAO() {
        this.connection = new ConexaoSysHotel().getConexao();
    }

    /**
     * Salva um novo registro na tabela hospedes.
     *
     * @param hospede Objeto Hospedes a ser salvo.
     */
    public void inserir(Hospedes hospede) {
        String sql = "INSERT INTO hospedes (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
            stmt.setString(3, hospede.getTelefone());
            stmt.setString(4, hospede.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro na tabela hospedes pelo ID.
     *
     * @param id ID do registro a ser buscado.
     * @return Objeto Hospedes encontrado ou null caso não exista.
     */
    public Hospedes pesquisar(int id) {
        String sql = "SELECT * FROM hospedes WHERE hospedes_id = ?";
        Hospedes hospede = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                hospede = new Hospedes(rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"));
                hospede.setHospedesId(rs.getInt("hospedes_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospede;
    }

    /**
     * Atualiza um registro na tabela hospedes.
     *
     * @param hospede Objeto Hospedes a ser atualizado.
     */
    public void atualizar(Hospedes hospede) {
        String sql = "UPDATE hospedes SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE hospedes_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
            stmt.setString(3, hospede.getTelefone());
            stmt.setString(4, hospede.getEmail());
            stmt.setInt(5, hospede.getHospedesId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro na tabela hospedes.
     *
     * @param id ID do registro a ser deletado.
     */
    public void apagar(int id) {
        String sql = "DELETE FROM hospedes WHERE hospedes_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os registros da tabela hospedes.
     *
     * @return Lista de objetos Hospedes.
     */
    public List<Hospedes> listarTudo() {
        String sql = "SELECT * FROM hospedes";
        List<Hospedes> hospedesList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Hospedes hospede = new Hospedes(rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"));
                hospede.setHospedesId(rs.getInt("hospedes_id"));
                hospedesList.add(hospede);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospedesList;
    }
}