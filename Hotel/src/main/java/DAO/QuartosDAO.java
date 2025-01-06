package DAO;

import Conexao.ConexaoSysHotel;
import SistemaHotel.Quartos;
import SistemaHotel.TipoQuartos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de CRUD na tabela quartos do banco de dados.
 */
public class QuartosDAO {

    // Atributo de conexão com o banco de dados.
    private Connection connection;

    /**
     * Construtor da classe QuartosDAO.
     */
    public QuartosDAO() {
        this.connection = new ConexaoSysHotel().getConexao();
    }

    /**
     * Salva um novo registro na tabela quartos.
     *
     * @param quarto Objeto Quartos a ser salvo.
     */
    public void inserir(Quartos quarto) {
        String sql = "INSERT INTO quartos (numero, quarto_disponivel, quartos_tq_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quarto.getNumero());
            stmt.setBoolean(2, quarto.isQuartoDisponivel());
            stmt.setInt(3, quarto.getTipoQuarto().getTipoQuartosId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro na tabela quartos pelo ID.
     *
     * @param id ID do registro a ser buscado.
     * @return Objeto Quartos encontrado ou null caso não exista.
     */
    public Quartos pesquisar(int id) {
        String sql = "SELECT * FROM quartos WHERE quartos_id = ?";
        Quartos quarto = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TipoQuartos tipoQuarto = new TipoQuartosDAO().pesquisar(rs.getInt("quartos_tq_id"));
                quarto = new Quartos(rs.getInt("numero"), tipoQuarto);
                quarto.setQuartosId(rs.getInt("quartos_id"));
                if (rs.getBoolean("quarto_disponivel")) {
                    quarto.setQuartoDisponivel();
                } else {
                    quarto.setQuartoOcupado();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quarto;
    }

    /**
     * Atualiza um registro na tabela quartos.
     *
     * @param quarto Objeto Quartos a ser atualizado.
     */
    public void atualizar(Quartos quarto) {
        String sql = "UPDATE quartos SET numero = ?, quarto_disponivel = ?, quartos_tq_id = ? WHERE quartos_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quarto.getNumero());
            stmt.setBoolean(2, quarto.isQuartoDisponivel());
            stmt.setInt(3, quarto.getTipoQuarto().getTipoQuartosId());
            stmt.setInt(4, quarto.getQuartosId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro na tabela quartos.
     *
     * @param id ID do registro a ser deletado.
     */
    public void apagar(int id) {
        String sql = "DELETE FROM quartos WHERE quartos_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os registros da tabela quartos.
     *
     * @return Lista de objetos Quartos.
     */
    public List<Quartos> listarTudo() {
        String sql = "SELECT * FROM quartos";
        List<Quartos> quartosList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoQuartos tipoQuarto = new TipoQuartosDAO().pesquisar(rs.getInt("quartos_tq_id"));
                Quartos quarto = new Quartos(rs.getInt("numero"), tipoQuarto);
                quarto.setQuartosId(rs.getInt("quartos_id"));
                if (rs.getBoolean("quarto_disponivel")) {
                    quarto.setQuartoDisponivel();
                } else {
                    quarto.setQuartoOcupado();
                }
                quartosList.add(quarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quartosList;
    }
}