package DAO;

import Conexao.ConexaoSysHotel;
import SistemaHotel.TipoQuartos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de CRUD na tabela tipo_quartos do banco de dados.
 */
public class TipoQuartosDAO {
    
    // Atributo de conexão com o banco de dados.
    private Connection connection;

    /**
     * Construtor da classe TipoQuartosDAO.
     */
    public TipoQuartosDAO() {
        this.connection = new ConexaoSysHotel().getConexao();
    }

    /**
     * Salva um novo registro na tabela tipo_quartos.
     *
     * @param tipoQuarto Objeto TipoQuartos a ser salvo.
     */
    public void inserir(TipoQuartos tipoQuarto) {
        String sql = "INSERT INTO tipo_quartos (nome, capacidade_pessoas, preco_diaria, descricao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tipoQuarto.getNome());
            stmt.setInt(2, tipoQuarto.getCapacidadePessoas());
            stmt.setDouble(3, tipoQuarto.getPrecoDiaria());
            stmt.setString(4, tipoQuarto.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro na tabela tipo_quartos pelo ID.
     *
     * @param id ID do registro a ser buscado.
     * @return Objeto TipoQuartos encontrado ou null caso não exista.
     */
    public TipoQuartos pesquisar(int id) {
        String sql = "SELECT * FROM tipo_quartos WHERE tipo_quartos_id = ?";
        TipoQuartos tipoQuarto = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tipoQuarto = new TipoQuartos(rs.getString("nome"), rs.getInt("capacidade_pessoas"), rs.getDouble("preco_diaria"), rs.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoQuarto;
    }

    /**
     * Atualiza um registro na tabela tipo_quartos.
     *
     * @param tipoQuarto Objeto TipoQuartos a ser atualizado.
     */
    public void atualizar(TipoQuartos tipoQuarto) {
        String sql = "UPDATE tipo_quartos SET nome = ?, capacidade_pessoas = ?, preco_diaria = ?, descricao = ? WHERE tipo_quartos_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tipoQuarto.getNome());
            stmt.setInt(2, tipoQuarto.getCapacidadePessoas());
            stmt.setDouble(3, tipoQuarto.getPrecoDiaria());
            stmt.setString(4, tipoQuarto.getDescricao());
            stmt.setInt(5, tipoQuarto.getTipoQuartosId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro na tabela tipo_quartos.
     *
     * @param id ID do registro a ser deletado.
     */
    public void apagar(int id) {
        String sql = "DELETE FROM tipo_quartos WHERE tipo_quartos_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os registros da tabela tipo_quartos.
     *
     * @return Lista de objetos TipoQuartos.
     */
    public List<TipoQuartos> listarTudo() {
        String sql = "SELECT * FROM tipo_quartos";
        List<TipoQuartos> tipoQuartosList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoQuartos tipoQuarto = new TipoQuartos(rs.getString("nome"), rs.getInt("capacidade_pessoas"), rs.getDouble("preco_diaria"), rs.getString("descricao"));
                tipoQuartosList.add(tipoQuarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoQuartosList;
    }
}
