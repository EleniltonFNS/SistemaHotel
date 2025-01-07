package AppHotel;

import DAO.HospedesDAO;
import SistemaHotel.Hospedes;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por realizar operações de CRUD na tabela hospedes do banco de dados.
 */
public class ServicosHospedes {

    private HospedesDAO hospedesDAO;

    /**
     * Construtor da classe ServicosHospedes.
     */
    public ServicosHospedes() {
        this.hospedesDAO = new HospedesDAO();
    }

    /**
     * Método que cadastra um novo hóspede no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void cadastrarHospede(Scanner entrada) {
        try {
            System.out.println("\n - Cadastrar Hóspede - \n");
            System.out.print("Nome: ");
            String nome = entrada.nextLine();
            System.out.print("CPF: ");
            String cpf = entrada.nextLine();
            System.out.print("Telefone: ");
            String telefone = entrada.nextLine();
            System.out.print("Email: ");
            String email = entrada.nextLine();

            Hospedes hospede = new Hospedes(nome, cpf, telefone, email);
            hospedesDAO.inserir(hospede);
            System.out.println("\n - Hóspede cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao cadastrar hóspede: " + e.getMessage());
        }
    }

    /**
     * Método que pesquisa um hóspede no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void pesquisarHospede(Scanner entrada) {
        try {
            System.out.println("\n - Pesquisar Cadastro - \n");
            System.out.print("ID do Hóspede: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            Hospedes hospede = hospedesDAO.pesquisar(id);
            if (hospede != null) {
                System.out.println(hospede);
            } else {
                System.out.println("\n - Hóspede não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao pesquisar hóspede: " + e.getMessage());
        }
    }

    /**
     * Método que atualiza um hóspede no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void atualizarHospede(Scanner entrada) {
        try {
            System.out.println("\n - Atualizar Cadastro - \n");
            System.out.print("ID do Hóspede: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            Hospedes hospede = hospedesDAO.pesquisar(id);
            if (hospede != null) {
                System.out.print("\nNovo Nome: ");
                String nome = entrada.nextLine();
                System.out.print("Novo CPF: ");
                String cpf = entrada.nextLine();
                System.out.print("Novo Telefone: ");
                String telefone = entrada.nextLine();
                System.out.print("Novo Email: ");
                String email = entrada.nextLine();

                hospede.setNome(nome);
                hospede.setCpf(cpf);
                hospede.setTelefone(telefone);
                hospede.setEmail(email);

                hospedesDAO.atualizar(hospede);
                System.out.println("\n - Hóspede atualizado com sucesso!");
            } else {
                System.out.println("\n - Hóspede não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao atualizar hóspede: " + e.getMessage());
        }
    }

    /**
     * Método que exclui um hóspede do banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void excluirHospede(Scanner entrada) {
        try {
            System.out.println("\n - Excluir Cadastro - \n");
            System.out.print("ID do Hóspede: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            hospedesDAO.apagar(id);
            System.out.println("\n - Hóspede excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao excluir hóspede: " + e.getMessage());
        }
    }

    /**
     * Método que lista todos os hóspedes cadastrados no banco de dados.
     */
    public void listarHospedes() {
        try {
            System.out.println("\n - Listar Hóspedes - \n");
            List<Hospedes> hospedesList = hospedesDAO.listarTudo();
            for (Hospedes hospede : hospedesList) {
                System.out.println(hospede);
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao listar hóspedes: " + e.getMessage());
        }
    }
}