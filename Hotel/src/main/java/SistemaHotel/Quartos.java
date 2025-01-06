package SistemaHotel;

/**
 * Classe que representa um quarto no sistema de hotel.
 * Contém informações sobre o número do quarto, disponibilidade e tipo.
 * <p>
 * Atributos:
 *  <ul>
 *     <li>{@code quartosId}: ID único de cada quarto.</li>
 *     <li>{@code numero}: Número do quarto.</li>
 *     <li>{@code quartoDisponivel}: Indica se o quarto está disponível ou não.</li>
 *     <li>{@code tipoQuarto}: Objeto da classe {@link TipoQuartos}, que representa o tipo do quarto.</li>
 * </ul>
 */
public class Quartos {
    //Atributos
    private int quartosId;
    private int numero;
    private boolean quartoDisponivel;
    private TipoQuartos tipoQuarto;

    /**
     * Construtor da classe quartos.
     * Atributo {@code quartoDisponivel} iniciado como {@code true}.
     *
     * @param numero     Número do quarto.
     * @param tipoQuarto Tipo do quarto.
     */
    public Quartos (int numero, TipoQuartos tipoQuarto) {
        this.numero = numero;
        this.quartoDisponivel = true; // Objeto quarto iniciado como disponível.
        this.tipoQuarto = tipoQuarto;}

    /**
     * Método que retorna o ID do quarto.
     * @return ID do quarto.
     */
    public int getQuartosId() {
        return quartosId;}

    /**
     * Método que retorna o número do quarto.
     * @return Número do quarto.
     */
    public int getNumero() {
        return numero;}

    /**
     * Método que altera o número do quarto.
     * @param numero Novo número do quarto.
     */
    public void setNumero(int numero) {
        this.numero = numero;}

    /**
     * Método que retorna se o quarto está disponível.
     * @return Indica se o quarto está disponível.
     */
    public boolean isQuartoDisponivel() {
        return quartoDisponivel;}

    /**
     * Método que define o quarto como disponível.
     */
    public void setQuartoDisponivel(){
        this.quartoDisponivel = true;}

    /**
     * Método que define o quarto como ocupado.
     */
    public void setQuartoOcupado(){
        this.quartoDisponivel = false;}

    /**
     * Método que retorna o tipo do quarto.
     * @return Tipo do quarto.
     */
    public TipoQuartos getTipoQuarto() {
        return tipoQuarto;}

    /**
     * Método que altera o tipo do quarto.
     * @param tipoQuarto Novo tipo do quarto.
     */
    public void setTipoQuarto(TipoQuartos tipoQuarto) {
        this.tipoQuarto = tipoQuarto;}

    /**
     * Sobrescrita do método {@code toString} para retornar os dados do quarto.
     * A string retornada contém o número do quarto, o ID do quarto, o status de disponibilidade
     * ("Disponível" ou "Ocupado") e o tipo do quarto seguido pelo valor da diária
     * @return String com os dados do quarto, o qual pode varia a depender do status de disponibilidade.
     */
    @Override
    public String toString() {
        if(quartoDisponivel){
            return " Quarto: " + numero + "\'"
                    + " ID: " + quartosId + "\'"
                    + " Status Disponibilidade: Disponível \'"
                    + " Tipo: " + tipoQuarto + " | R$ " + tipoQuarto.getPrecoDiaria() + " a diária";
        } else {
            return " Quarto: " + numero + "\'"
                + " ID: " + quartosId + "\'"
                + " Status Disponibilidade: Ocupado \'"
                + " Tipo: " + tipoQuarto +  " | R$ " + tipoQuarto.getPrecoDiaria() + " a diária";
        }
    }
}