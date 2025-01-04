package SistemaHotel;

/**
 * Classe que representa os quartos do hotel.
 * Possui os atributos quartosID, numero, quartoDisponivel e tipoQuartos.
 * Além de métodos getters e setters.
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
     * Sobrescrita que retorna uma string com os dados do quarto.
     * @return String com os dados do quarto.
     */
    @Override
    public String toString() {
        return " Quarto: " + numero + "\'"
                + " ID: " + quartosId + "\'"
                + " Disponível: " + quartoDisponivel + "\'"
                + " Tipo: " + tipoQuarto + "\'";}
}
