package AppHotel;

import DAO.ReservasDAO;
import SistemaHotel.Quartos;
import DAO.QuartosDAO;
import SistemaHotel.Reservas;
import SistemaHotel.Hospedes;
import DAO.HospedesDAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por realizar operações de CRUD na tabela reservas do banco de dados.
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
     * Método que registra uma nova reserva no banco de dados.
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

            if (quarto != null && hospede != null) {
                Reservas reserva = new Reservas(quarto, hospede, dataCheckin, dataCheckout, 1);
                reservasDAO.inserir(reserva);
                System.out.println("\n - Reserva registrada com sucesso!");
            } else {
                System.out.println("\n - Quarto ou Hóspede não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao registrar reserva: " + e.getMessage());
        }
    }

    /**
     * Método que finaliza uma reserva no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
public void finalizarReserva(Scanner entrada) {
    try {
        System.out.println("\n - Finalizar Reserva - \n");
        System.out.print("ID da Reserva: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Reservas reserva = reservasDAO.pesquisar(id);
        if (reserva.isReservaAtiva()) {
            reservasDAO.finalizarReserva(id);
            System.out.println("\n - Reserva finalizada com sucesso!");
        } else if (reserva != null) {
            System.out.println("\n - Reserva com ID " + id + " já está finalizada.");
        } else {
            System.out.println("\n - Reserva não encontrada.");
        }
    } catch (Exception e) {
        System.out.println("\n - Erro ao finalizar reserva: " + e.getMessage());
    }
}

    /**
     * Método que simula uma reserva no banco de dados.
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
     * Método que pesquisa uma reserva no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void pesquisarReserva(Scanner entrada) {

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

    }

    /**
     * Método que atualiza uma reserva no banco de dados.
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
     * Método que exclui uma reserva no banco de dados.
     *
     * @param entrada Scanner para entrada de dados.
     */
    public void excluirReserva(Scanner entrada) {
        try {
            System.out.println("\n - Excluir Reserva - \n");
            System.out.print("ID da Reserva: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            Reservas reserva = reservasDAO.pesquisar(id);
            if(reserva!=null) {
                if (reserva.isReservaAtiva()) {
                    System.out.println("\n - Reserva ativa, finalize-a antes de excluí-la.");
                } else {
                    reservasDAO.apagar(id);
                    System.out.println("\n - Reserva excluída com sucesso!");
                }
            } else {
                System.out.println("\n - Reserva não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("\n - Erro ao excluir reserva: " + e.getMessage());
        }
    }

    /**
     * Método que lista todas as reservas no banco de dados.
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