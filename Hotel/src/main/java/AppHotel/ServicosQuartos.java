package AppHotel;

import DAO.QuartosDAO;
import DAO.TipoQuartosDAO;
import SistemaHotel.Quartos;
import SistemaHotel.TipoQuartos;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por realizar operações de CRUD na tabela quartos do banco de dados.
 */
public class ServicosQuartos {

    private QuartosDAO quartosDAO;

    /**
     * Construtor da classe ServicosQuartos.
     */
    public ServicosQuartos() {
        this.quartosDAO = new QuartosDAO();
    }

    /**
     * Método que cadastra um novo quarto no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void cadastrarQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Cadastrar Quarto - \n");
            System.out.print("Número: ");
            int numero = entrada.nextInt();
            entrada.nextLine();
            System.out.print("Disponível (true/false): ");
            boolean disponivel = entrada.nextBoolean();
            entrada.nextLine();
            System.out.print("ID do Tipo de Quarto: ");
            int tipoQuartoId = entrada.nextInt();
            entrada.nextLine();

            TipoQuartos tipoQuarto = new TipoQuartosDAO().pesquisar(tipoQuartoId);
            Quartos quarto = new Quartos(numero, tipoQuarto);
            if (disponivel) {
                quarto.setQuartoDisponivel();
            } else {
                quarto.setQuartoOcupado();
            }
            quartosDAO.inserir(quarto);
            System.out.println("\n - Quarto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao cadastrar quarto: " + e.getMessage());
        }
    }

    /**
     * Método que pesquisa um quarto no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void pesquisarQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Pesquisar Quarto - \n");
            System.out.print("ID do Quarto: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            Quartos quarto = quartosDAO.pesquisar(id);
            if (quarto != null) {
                System.out.println(quarto);
            } else {
                System.out.println("\n - Quarto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao pesquisar quarto: " + e.getMessage());
        }
    }

    /**
     * Método que atualiza um quarto no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void atualizarQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Atualizar Quarto - \n");
            System.out.print("ID do Quarto: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            Quartos quarto = quartosDAO.pesquisar(id);
            if (quarto != null) {
                System.out.print("\nNovo Número: ");
                int numero = entrada.nextInt();
                entrada.nextLine();
                System.out.print("Disponível (true/false): ");
                boolean disponivel = entrada.nextBoolean();
                entrada.nextLine();
                System.out.print("ID do Tipo de Quarto: ");
                int tipoQuartoId = entrada.nextInt();
                entrada.nextLine();

                TipoQuartos tipoQuarto = new TipoQuartosDAO().pesquisar(tipoQuartoId);
                quarto.setNumero(numero);
                if (disponivel) {
                    quarto.setQuartoDisponivel();
                } else {
                    quarto.setQuartoOcupado();
                }
                quarto.setTipoQuarto(tipoQuarto);

                quartosDAO.atualizar(quarto);
                System.out.println("\n - Quarto atualizado com sucesso!");
            } else {
                System.out.println("\n - Quarto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao atualizar quarto: " + e.getMessage());
        }
    }

    /**
     * Método que exclui um quarto do banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void excluirQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Excluir Quarto - \n");
            System.out.print("ID do Quarto: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            quartosDAO.apagar(id);
            System.out.println("\n - Quarto excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao excluir quarto: " + e.getMessage());
        }
    }

    /**
     * Método que lista todos os quartos cadastrados no banco de dados.
     */
    public void listarQuartos() {
        try {
            System.out.println("\n - Listar Quartos - ");
            List<Quartos> quartosList = quartosDAO.listarTudo();
            for (Quartos quarto : quartosList) {
                System.out.println(quarto);
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao listar quartos: " + e.getMessage());
        }
    }
} 
}
