package AppHotel;

import DAO.TipoQuartosDAO;
import SistemaHotel.TipoQuartos;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por realizar operações de CRUD na tabela tipo_quartos do banco de dados.
 */
public class ServicosTipoQuartos {

    private TipoQuartosDAO tipoQuartosDAO;

    /**
     * Construtor da classe ServicosTipoQuartos.
     */
    public ServicosTipoQuartos() {
        this.tipoQuartosDAO = new TipoQuartosDAO();
    }

    /**
     * Método que cadastra um novo tipo de quarto no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void cadastrarTipoQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Cadastrar Tipo de Quarto - \n");
            System.out.print("Nome: ");
            String nome = entrada.nextLine();
            System.out.print("Capacidade de Pessoas: ");
            int capacidadePessoas = entrada.nextInt();
            entrada.nextLine();
            System.out.print("Preço da Diária: ");
            double precoDiaria = entrada.nextDouble();
            entrada.nextLine();
            System.out.print("Descrição: ");
            String descricao = entrada.nextLine();

            TipoQuartos tipoQuarto = new TipoQuartos(nome, capacidadePessoas, precoDiaria, descricao);
            tipoQuartosDAO.inserir(tipoQuarto);
            System.out.println("\n - Tipo de Quarto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao cadastrar Tipo de Quarto: " + e.getMessage());
        }
    }

    /**
     * Método que pesquisa um tipo de quarto no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void pesquisarTipoQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Pesquisar Tipo de Quarto - \n");
            System.out.print("ID do Tipo de Quarto: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            TipoQuartos tipoQuarto = tipoQuartosDAO.pesquisar(id);
            if (tipoQuarto != null) {
                System.out.println(tipoQuarto);
            } else {
                System.out.println("\n - Tipo de Quarto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao pesquisar Tipo de Quarto: " + e.getMessage());
        }
    }

    /**
     * Método que atualiza um tipo de quarto no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void atualizarTipoQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Atualizar Tipo de Quarto - \n");
            System.out.print("ID do Tipo de Quarto: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            TipoQuartos tipoQuarto = tipoQuartosDAO.pesquisar(id);
            if (tipoQuarto != null) {
                System.out.print("\nNovo Nome: ");
                String nome = entrada.nextLine();
                System.out.print("Nova Capacidade de Pessoas: ");
                int capacidadePessoas = entrada.nextInt();
                entrada.nextLine();
                System.out.print("Novo Preço da Diária: ");
                double precoDiaria = entrada.nextDouble();
                entrada.nextLine();
                System.out.print("Nova Descrição: ");
                String descricao = entrada.nextLine();

                tipoQuarto.setNome(nome);
                tipoQuarto.setCapacidadePessoas(capacidadePessoas);
                tipoQuarto.setPrecoDiaria(precoDiaria);
                tipoQuarto.setDescricao(descricao);

                tipoQuartosDAO.atualizar(tipoQuarto);
                System.out.println("\n - Tipo de Quarto atualizado com sucesso!");
            } else {
                System.out.println("\n - Tipo de Quarto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao atualizar Tipo de Quarto: " + e.getMessage());
        }
    }

    /**
     * Método que exclui um tipo de quarto do banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void excluirTipoQuarto(Scanner entrada) {
        try {
            System.out.println("\n - Excluir Tipo de Quarto - \n");
            System.out.print("ID do Tipo de Quarto: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            TipoQuartos tipoQuarto = tipoQuartosDAO.pesquisar(id);
            if (tipoQuarto != null) {
                tipoQuartosDAO.apagar(id);
                System.out.println("\n - Tipo de Quarto excluído com sucesso!");
            } else {
                System.out.println("\n - Tipo de Quarto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao excluir Tipo de Quarto: " + e.getMessage());
        }
    }

    /**
     * Método que lista todos os tipos de quarto cadastrados no banco de dados.
     */
    public void listarTiposQuarto() {
        try {
            System.out.println("\n - Listar Tipos de Quarto - \n");
            List<TipoQuartos> tipoQuartosList = tipoQuartosDAO.listarTudo();
            for (TipoQuartos tipoQuarto : tipoQuartosList) {
                System.out.println(tipoQuarto);
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao listar Tipos de Quarto: " + e.getMessage());
        }
    }
}