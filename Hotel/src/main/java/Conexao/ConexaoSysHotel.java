package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 */
public class ConexaoSysHotel {

    public static final String SERVIDOR = "jdbc:mysql://127.0.0.1:3306/sys_hotel";
    public static final String USUARIO = "root";
    public static final String SENHA = "Elehinanis1";

    /**
     * Obtém uma nova conexão com o banco de dados.
     *
     * @return Objeto Connection para o banco de dados ou null em caso de erro.
     */
    public Connection getConexao() {
        try {
            return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer conexão: " + e.getMessage());
            return null;
        }
    }
}