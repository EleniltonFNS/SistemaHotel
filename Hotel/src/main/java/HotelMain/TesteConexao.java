package HotelMain;

import Conexao.ConexaoSysHotel;

/**
 * Classe de teste para verificar a conexão com o banco de dados.
 */
public class TesteConexao {
    public static void main(String[] args) {
        ConexaoSysHotel conexaoSysHotel = new ConexaoSysHotel();

        // Teste de conexão
        if (conexaoSysHotel.getConexao() != null) {
            System.out.println("Conexão bem-sucedida!");
        } else {
            System.err.println("Falha na conexão.");
        }
    }
}
