package SistemaHotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe que representa uma reserva no sistema de hotel.
 * Contém informações sobre o número do quarto, disponibilidade e tipo.
 * <p>
 * Atributos:
 *  <ul>
 *     <li>{@code reservasId}: ID único de cada reserva.</li>
 *     <li>{@code quarto}: Objeto da classe {@link Quartos}, que representa o quarto reservado.</li>
 *     <li>{@code hospede}: Objeto da classe {@link Hospedes}, representando o hóspede que fez a reserva.</li>
 *     <li>{@code dataCheckin}: Data de check-in da reserva.</li>
 *     <li>{@code dataCheckout}: Data de check-out da reserva.</li>
 *     <li>{@code valorTotal}: Valor total da reserva.</li>
 *     <li>{@code reservaAtiva}: Indica se a reserva está ativa ou não.</li>
 * </ul>
 */
public class Reservas {

    private int reservasId;
    private Quartos quarto;
    private Hospedes hospede;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;
    private double valorTotal;
    private boolean reservaAtiva;


    /**
     * Construtor da classe Reservas.
     * <p>
     * O atributo {@code reservaAtiva} é iniciado como {@code true}. <br>
     * O valor total da reserva é calculado com base na diária do quarto e na quantidade de dias.
     * @param quarto       Quarto reservado.
     * @param hospede      Hóspede que fez a reserva.
     * @param dataCheckin  Data de check-in.
     * @param dataCheckout Data de check-out.
     */
    public Reservas(Quartos quarto, Hospedes hospede, LocalDate dataCheckin, LocalDate dataCheckout, int reservasAtiva) {
        // Verifica se os campos obrigatórios foram preenchidos.
        if (hospede == null || quarto == null || dataCheckin == null || dataCheckout == null) {
            throw new IllegalArgumentException(" - Todos os campos são obrigatórios.");}
        // Verifica se a data de check-out é anterior à data de check-in.
        if (dataCheckout.isBefore(dataCheckin)) {
            throw new IllegalArgumentException(" - A data de check-out não pode ser anterior à data de check-in.");}
        // Verifica se a data de check-in é anterior à data atual.
        if (dataCheckin.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(" - A data de check-in não pode ser anterior à data atual.");}


        this.quarto = quarto;
        this.quarto.setQuartoOcupado();
        this.hospede = hospede;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.reservaAtiva = reservasAtiva == 1;
        calcularValorTotal();}

    /**
     * Método que calcula o valor total da reserva com base na diária do quarto e na quantidade de dias.
     */
    public void calcularValorTotal() {
        try{
            // Calcula a quantidade de dias entre o check-in e o check-out.
            long diasDeEstadias = ChronoUnit.DAYS.between(dataCheckin, dataCheckout);
            // Pega o preço da diária do quarto.
            double precoDiaria = quarto.getTipoQuarto().getPrecoDiaria();
            // Calcula o valor total da reserva.
            valorTotal = diasDeEstadias * precoDiaria;
        } catch (Exception e){
            throw new IllegalArgumentException(" - Erro ao calcular o valor total da reserva.");
        }
    }

    /**
     * Método que finaliza uma reserva, tornando o quarto disponível novamente.
     */
    public boolean finalizarReserva() {
        if (!reservaAtiva) {
            return false;
        } else {
            reservaAtiva = false;
            return true;
        }
    }

    /**
     * Método que retorna o ID da reserva.
     * @return ID da reserva.
     */
    public int getReservasId() {
        return reservasId;}

    /**
     * Método que altera o ID da reserva.
     * @param reservasId Novo ID da reserva.
     */
    public void setReservasId(int reservasId) {
        this.reservasId = reservasId;}

    /**
     * Método que retorna o quarto reservado.
     * @return Objeto da classe {@link Quartos} que representa o quarto reservado.
     */
    public Quartos getQuarto() {
        return quarto;}

    /**
     * Método que retorna o hóspede que fez a reserva.
     * @return Objeto da classe {@link Hospedes} que representa o hóspede que fez a reserva.
     */
    public Hospedes getHospede() {
        return hospede;}

    /**
     * Método que retorna a data de check-in da reserva.
     * @return Data de check-in da reserva.
     */
    public LocalDate getDataCheckin() {
        return dataCheckin;}

    /**
     * Método que altera a data de check-in da reserva.
     * @param dataCheckin Nova data de check-in da reserva.
     */
    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;}

    /**
     * Método que retorna a data de check-out da reserva.
     * @return Data de check-out da reserva.
     */
    public LocalDate getDataCheckout() {
        return dataCheckout;}

    /**
     * Método que altera a data de check-out da reserva.
     * @param dataCheckout Nova data de check-out da reserva.
     */
    public void setDataCheckout(LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;}

    /**
     * Método que retorna o valor total da reserva.
     * @return Valor total da reserva.
     */
    public double getValorTotal() {
        return valorTotal;}

    /**
     * Método que retorna o status atual da reserva (ativa ou finalizada).
     * @return {@code true} se a reserva estiver ativa, {@code false} caso esteja finalizada.
     */
    public boolean isReservaAtiva() {
        return reservaAtiva;}

    /**
     * Sobrescrita do método {@code toString} para retornar os dados da reserva.
     * A string retornada contém o ID da reserva, o número do quarto, o nome do hóspede,
     * as datas de check-in e check-out, o valor total da reserva e o status da reserva
     * ("Reserva Ativa" ou "Reserva Finalizada").
     * @return String com os dados da reserva.
     */
    @Override
    public String toString() {
        return "\n Reserva ID: " + reservasId + "\n" +
                " Quarto: " + quarto.getNumero() + "\n" +
                " Hóspede: " + hospede.getNome() + "\n" +
                " Data de Check-in: " + dataCheckin + "\n" +
                " Data de Check-out: " + dataCheckout + "\n" +
                " Valor Total da Reserva: R$ " + valorTotal + "\n" +
                " Reserva " + (reservaAtiva ? "Ativa" : "Finalizada") + "\n";
    }
}