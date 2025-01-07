package AppHotel;

import DAO.ReservasDAO;
import DAO.QuartosDAO;
import DAO.HospedesDAO;
import SistemaHotel.Reservas;
import SistemaHotel.Quartos;
import SistemaHotel.Hospedes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que contém métodos para realizar operações de CRUD na tabela reservas do banco de dados.
 */
public class ServicosReservas {

    private ReservasDAO reservasDAO;

    /**
     * Construtor da classe ServicosReservas.
     */
    public ServicosReservas() {
        this.reservasDAO = new ReservasDAO();
    }

    /**
     * Registra uma nova reserva no sistema.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void registrarReserva(Scanner entrada) {
        try {
            System.out.println("\n - Registrar Reserva - \n");
            System.out.print("ID do Quarto: ");
            int quartoId = entrada.nextInt();
            entrada.nextLine();
            System.out.print("ID do Hóspede: ");
            int hospedeId = entrada.nextInt();
            entrada.nextLine();
            System.out.print("Data de Check-in (AAAA-MM-DD): ");
            LocalDate dataCheckin = LocalDate.parse(entrada.nextLine());
            System.out.print("Data de Check-out (AAAA-MM-DD): ");
            LocalDate dataCheckout = LocalDate.parse(entrada.nextLine());

            Quartos quarto = new QuartosDAO().pesquisar(quartoId);
            Hospedes hospede = new HospedesDAO().pesquisar(hospedeId);
            Reservas reserva = new Reservas(quarto, hospede, dataCheckin, dataCheckout);
            reservasDAO.inserir(reserva);
            System.out.println("\n - Reserva registrada com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao registrar reserva: " + e.getMessage());
        }
    }

    /**
     * Finaliza uma reserva, tornando o quarto disponível novamente.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void finalizarReserva(Scanner entrada) {
        try {
            System.out.println("\n - Finalizar Reserva - \n");
            System.out.print("ID da Reserva: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            reservasDAO.finalizarReserva(id);
            System.out.println("\n - Reserva finalizada com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao finalizar reserva: " + e.getMessage());
        }
    }

    /**
     * Simula uma reserva, calculando o valor total da estadia.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void simularReserva(Scanner entrada) {
        try {
            System.out.println("\n - Simular Reserva - \n");
            System.out.print("ID do Quarto: ");
            int quartoId = entrada.nextInt();
            entrada.nextLine();
            System.out.print("Data de Check-in (AAAA-MM-DD): ");
            LocalDate dataCheckin = LocalDate.parse(entrada.nextLine());
            System.out.print("Data de Check-out (AAAA-MM-DD): ");
            LocalDate dataCheckout = LocalDate.parse(entrada.nextLine());

            Quartos quarto = new QuartosDAO().pesquisar(quartoId);
            if (quarto != null) {
                long diasDeEstadias = ChronoUnit.DAYS.between(dataCheckin, dataCheckout);
                double precoDiaria = quarto.getTipoQuarto().getPrecoDiaria();
                double valorTotal = diasDeEstadias * precoDiaria;
                System.out.println("\n - Valor total da estadia: R$ " + valorTotal);
            } else {
                System.out.println("\n - Quarto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao simular reserva: " + e.getMessage());
        }
    }

    /**
     * Pesquisa uma reserva pelo ID.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void pesquisarReserva(Scanner entrada) {
        try {
            System.out.println("\n - Pesquisar Reserva - \n");
            System.out.print("ID da Reserva: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            Reservas reserva = reservasDAO.pesquisar(id);
            if (reserva != null) {
                System.out.println(reserva);
            } else {
                System.out.println("\n - Reserva não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao pesquisar reserva: " + e.getMessage());
        }
    }

    /**
     * Atualiza uma reserva no sistema.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void atualizarReserva(Scanner entrada) {
        try {
            System.out.println("\n - Atualizar Reserva - \n");
            System.out.print("ID da Reserva: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            Reservas reserva = reservasDAO.pesquisar(id);
            if (reserva != null) {
                System.out.print("\nNova Data de Check-in (AAAA-MM-DD): ");
                LocalDate dataCheckin = LocalDate.parse(entrada.nextLine());
                System.out.print("Nova Data de Check-out (AAAA-MM-DD): ");
                LocalDate dataCheckout = LocalDate.parse(entrada.nextLine());

                reserva.setDataCheckin(dataCheckin);
                reserva.setDataCheckout(dataCheckout);
                reserva.calcularValorTotal();

                reservasDAO.atualizar(reserva);
                System.out.println("\n - Reserva atualizada com sucesso!");
            } else {
                System.out.println("\n - Reserva não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao atualizar reserva: " + e.getMessage());
        }
    }

    /**
     * Exclui uma reserva do sistema.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void excluirReserva(Scanner entrada) {
        try {
            System.out.println("\n - Excluir Reserva - \n");
            System.out.print("ID da Reserva: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            reservasDAO.apagar(id);
            System.out.println("\n - Reserva excluída com sucesso!");
        } catch (Exception e) {
            System.out.println("\n - Erro ao excluir reserva: " + e.getMessage());
        }
    }

    /**
     * Lista todas as reservas registradas no sistema.
     */
    public void listarReservas() {
        try {
            System.out.println("\n - Listar Reservas - \n");
            List<Reservas> reservasList = reservasDAO.listarTudo();
            for (Reservas reserva : reservasList) {
                System.out.println(reserva);
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao listar reservas: " + e.getMessage());
        }
    }
}