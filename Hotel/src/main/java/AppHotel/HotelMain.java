package AppHotel;
import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ServicosHospedes servicosHospedes = new ServicosHospedes();
        ServicosQuartos servicosQuartos = new ServicosQuartos();
        ServicosReservas servicosReservas = new ServicosReservas();
        ServicosTipoQuartos servicosTipoQuartos = new ServicosTipoQuartos();

        int menuPrincipal = 0; // Variável para armazenar a opção do menu principal.

        do{
            System.out.println("\n -=-=-=- Sistema de Hotel -=-=-=-");
            System.out.println("\n | 1 - Gerenciar Hóspedes");
            System.out.println(" | 2 - Gerenciar Quartos");
            System.out.println(" | 3 - Gerenciar Reservas");
            System.out.println(" | 4 - Gerenciar Tipos de Quarto");
            System.out.println(" | 5 - Sair");

            System.out.print(" -> ");
            while (!entrada.hasNextInt()) { // Tratamento e validação da entrada do menu principal.
                System.out.println(" - Digite um número válido. ");
                System.out.print(" -> ");
                entrada.next();
            }
            menuPrincipal = entrada.nextInt();
            entrada.nextLine();

//----------------------------------------------------------------------------------------------------------------------
            switch (menuPrincipal){
                case 1: // Gerenciamento de Hóspedes
                    System.out.println("\n -=-=-=- Gerenciamento de Hóspedes -=-=-=-");
                    int menuHospede = 0; // Variável para armazenar a opção do menu de hóspedes.
                    do {
                        System.out.println("\n | 1 - Cadastrar Hóspede");
                        System.out.println(" | 2 - Pesquisar Cadastro");
                        System.out.println(" | 3 - Atualizar Cadastro");
                        System.out.println(" | 4 - Excluir Cadastro");
                        System.out.println(" | 5 - Listar Hóspedes");
                        System.out.println(" | 6 - Voltar");

                        System.out.print(" -> ");
                        while (!entrada.hasNextInt()) { // Tratamento e validação da entrada do menu de hóspedes.
                            System.out.println(" - Digite um número válido. ");
                            System.out.print(" -> ");
                            entrada.next();
                        }
                        menuHospede = entrada.nextInt();
                        entrada.nextLine();

                        switch (menuHospede) {
                            case 1:
                                servicosHospedes.cadastrarHospede(entrada);
                                break;
                            case 2:
                                servicosHospedes.pesquisarHospede(entrada);
                                break;
                            case 3:
                                servicosHospedes.atualizarHospede(entrada);
                                break;
                            case 4:
                                servicosHospedes.excluirHospede(entrada);
                                break;
                            case 5:
                                servicosHospedes.listarHospedes();
                                break;
                            case 6:
                                // Voltar
                                break;
                            default:
                                System.out.println(" - Opção inválida.");
                                break;
                        }
                    } while (menuHospede != 6);
                    break;

//----------------------------------------------------------------------------------------------------------------------
                case 2: // Gerenciamento de Quartos
                    System.out.println("\n -=-=-=- Gerenciamento de Quartos -=-=-=-");
                    int menuQuarto = 0; // Variável para armazenar a opção do menu de quartos.
                    do {
                        System.out.println("\n | 1 - Cadastrar Quarto");
                        System.out.println(" | 2 - Pesquisar Quarto");
                        System.out.println(" | 3 - Atualizar Quarto");
                        System.out.println(" | 4 - Excluir Quarto");
                        System.out.println(" | 5 - Listar Quartos");
                        System.out.println(" | 6 - Voltar");

                        System.out.print(" -> ");
                        while (!entrada.hasNextInt()) { // Tratamento e validação da entrada do menu de quartos.
                            System.out.println(" - Digite um número válido. ");
                            System.out.print(" -> ");
                            entrada.next();
                        }
                        menuQuarto = entrada.nextInt();
                        entrada.nextLine();

                        switch (menuQuarto) {
                            case 1:
                                servicosQuartos.cadastrarQuarto(entrada);
                                break;
                            case 2:
                                servicosQuartos.pesquisarQuarto(entrada);
                                break;
                            case 3:
                                servicosQuartos.atualizarQuarto(entrada);
                                break;
                            case 4:
                                servicosQuartos.excluirQuarto(entrada);
                                break;
                            case 5:
                                servicosQuartos.listarQuartos();
                                break;
                            case 6:
                                // Voltar
                                break;
                            default:
                                System.out.println(" - Opção inválida.");
                                break;
                        }
                    } while (menuQuarto != 6);
                    break;

//----------------------------------------------------------------------------------------------------------------------
                case 3: // Gerenciamento de Reservas
                    System.out.println("\n -=-=-=- Gerenciamento de Reservas -=-=-=-");
                    int menuReserva = 0; // Variável para armazenar a opção do menu de reservas.
                    do {
                        System.out.println("\n | 1 - Registar Reserva");
                        System.out.println(" | 2 - Finalizar Reserva");
                        System.out.println(" | 3 - Pesquisar Reserva");
                        System.out.println(" | 4 - Atualizar Reserva");
                        System.out.println(" | 5 - Excluir Reserva");
                        System.out.println(" | 6 - Listar Reservas");
                        System.out.println(" | 7 - Simular Reserva");
                        System.out.println(" | 8 - Voltar");

                        System.out.print(" -> ");
                        while (!entrada.hasNextInt()) { // Tratamento e validação da entrada do menu de reservas.
                            System.out.println(" - Digite um número válido. ");
                            System.out.print(" -> ");
                            entrada.next();
                        }
                        menuReserva = entrada.nextInt();
                        entrada.nextLine();

                        switch (menuReserva) {
                            case 1:
                                servicosReservas.registrarReserva(entrada);
                                break;
                            case 2:
                                servicosReservas.finalizarReserva(entrada);
                                break;
                            case 3:
                                servicosReservas.pesquisarReserva(entrada);
                                break;
                            case 4:
                                servicosReservas.atualizarReserva(entrada);
                                break;
                            case 5:
                                servicosReservas.excluirReserva(entrada);
                                break;
                            case 6:
                                servicosReservas.listarReservas();
                                break;
                            case 7:
                                servicosReservas.simularReserva(entrada);
                                break;
                            case 8:
                                // Voltar
                                break;
                            default:
                                System.out.println(" - Opção inválida.");
                                break;
                        }
                    } while (menuReserva != 8);
                    break;

//----------------------------------------------------------------------------------------------------------------------
                case 4: // Gerenciamento de Tipos de Quarto
                    System.out.println("\n -=-=-=- Gerenciamento de Tipos de Quarto -=-=-=-");
                    int menuTipoQuarto = 0; // Variável para armazenar a opção do menu de tipos de quarto.
                    do {
                        System.out.println("\n | 1 - Cadastrar Tipo de Quarto");
                        System.out.println(" | 2 - Pesquisar Tipo de Quarto");
                        System.out.println(" | 3 - Atualizar Tipo de Quarto");
                        System.out.println(" | 4 - Excluir Tipo de Quarto");
                        System.out.println(" | 5 - Listar Tipos de Quarto");
                        System.out.println(" | 6 - Voltar");

                        System.out.print(" -> ");
                        while (!entrada.hasNextInt()) { // Tratamento e validação da entrada do menu de tipos de quarto.
                            System.out.println(" - Digite um número válido. ");
                            System.out.print(" -> ");
                            entrada.next();
                        }
                        menuTipoQuarto = entrada.nextInt();
                        entrada.nextLine();

                        switch (menuTipoQuarto) {
                            case 1:
                                servicosTipoQuartos.cadastrarTipoQuarto(entrada);
                                break;
                            case 2:
                                servicosTipoQuartos.pesquisarTipoQuarto(entrada);
                                break;
                            case 3:
                                servicosTipoQuartos.atualizarTipoQuarto(entrada);
                                break;
                            case 4:
                                servicosTipoQuartos.excluirTipoQuarto(entrada);
                                break;
                            case 5:
                                servicosTipoQuartos.listarTiposQuarto();
                                break;
                            case 6:
                                // Voltar
                                break;
                            default:
                                System.out.println(" - Opção inválida.");
                                break;
                        }
                    } while (menuTipoQuarto != 6);
                    break;

//----------------------------------------------------------------------------------------------------------------------
                case 5: // Sair
                    System.out.println(" - Saindo do sistema...");
                    break;

//----------------------------------------------------------------------------------------------------------------------
                default: // Opção inválida
                    System.out.println(" - Opção inválida.");
                    break;
            }
        } while (menuPrincipal != 5);
    }
}
