package DAO;

import Conexao.ConexaoSysHotel;
import SistemaHotel.Hospedes;
import SistemaHotel.Quartos;
import SistemaHotel.Reservas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de CRUD na tabela reservas do banco de dados.
 */
public class ReservasDAO {
    
    private Connection connection;

    /**
     * Construtor da classe ReservasDAO.
     */
    public ReservasDAO() {
        this.connection = new ConexaoSysHotel().getConexao();
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * Salva um novo registro na tabela reservas.
     *
     * @param reserva Objeto Reservas a ser salvo.
     */
    public void inserir(Reservas reserva) {
        reserva.calcularValorTotal(); // Calcula o valor total antes de inserir
        String sql = "INSERT INTO reservas (reservas_quarto_id, reservas_hospedes_id, data_checkin, data_checkout, valor_total, reserva_ativa) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getQuarto().getQuartosId());
            stmt.setInt(2, reserva.getHospede().getHospedesId());
            stmt.setDate(3, java.sql.Date.valueOf(reserva.getDataCheckin()));
            stmt.setDate(4, java.sql.Date.valueOf(reserva.getDataCheckout()));
            stmt.setDouble(5, reserva.getValorTotal());
            stmt.setBoolean(6, reserva.isReservaAtiva());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro na tabela reservas pelo ID.
     *
     * @param id ID do registro a ser buscado.
     * @return Objeto Reservas encontrado ou null caso não exista.
     */
    public Reservas pesquisar(int id) {
        String sql = "SELECT * FROM reservas WHERE reservas_id = ?";
        Reservas reserva = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Quartos quarto = new QuartosDAO().pesquisar(rs.getInt("reservas_quarto_id"));
                Hospedes hospede = new HospedesDAO().pesquisar(rs.getInt("reservas_hospedes_id"));
                reserva = new Reservas(quarto, hospede, rs.getDate("data_checkin").toLocalDate(), rs.getDate("data_checkout").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    /**
     * Atualiza um registro na tabela reservas.
     *
     * @param reserva Objeto Reservas a ser atualizado.
     */
    public void atualizar(Reservas reserva) {
        reserva.calcularValorTotal(); // Calcula o valor total antes de atualizar
        String sql = "UPDATE reservas SET reservas_quarto_id = ?, reservas_hospedes_id = ?, data_checkin = ?, data_checkout = ?, valor_total = ?, reserva_ativa = ? WHERE reservas_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getQuarto().getQuartosId());
            stmt.setInt(2, reserva.getHospede().getHospedesId());
            stmt.setDate(3, java.sql.Date.valueOf(reserva.getDataCheckin()));
            stmt.setDate(4, java.sql.Date.valueOf(reserva.getDataCheckout()));
            stmt.setDouble(5, reserva.getValorTotal());
            stmt.setBoolean(6, reserva.isReservaAtiva());
            stmt.setInt(7, reserva.getReservasId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro na tabela reservas.
     *
     * @param id ID do registro a ser deletado.
     */
    public void apagar(int id) {
        String sql = "DELETE FROM reservas WHERE reservas_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finaliza uma reserva.
     *
     * @param id ID da reserva a ser finalizada.
     */
    public void finalizarReserva(int id) {
        Reservas reserva = pesquisar(id);
        if (reserva != null && reserva.finalizarReserva()) {
            String sql = "UPDATE reservas SET reserva_ativa = false WHERE reservas_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retorna uma lista com todos os registros da tabela reservas.
     *
     * @return Lista de objetos Reservas.
     */
    public List<Reservas> listarTudo() {
        String sql = "SELECT * FROM reservas";
        List<Reservas> reservasList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Quartos quarto = new QuartosDAO().pesquisar(rs.getInt("reservas_quarto_id"));
                Hospedes hospede = new HospedesDAO().pesquisar(rs.getInt("reservas_hospedes_id"));
                Reservas reserva = new Reservas(quarto, hospede, rs.getDate("data_checkin").toLocalDate(), rs.getDate("data_checkout").toLocalDate());
                reservasList.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservasList;
    }
}
