package SistemaHotel;

/**
 * Classe que representa um hóspede no sistema de hotel.
 * Contém informações sobre o nome, CPF, telefone e e-mail do hóspede.
 * <p>
 * Atributos:
 *  <ul>
 *     <li>{@code hospedesId}: ID único de cada hóspede.</li>
 *     <li>{@code nome}: Nome do hóspede.</li>
 *     <li>{@code cpf}: CPF do hóspede.</li>
 *     <li>{@code telefone}: Telefone do hóspede.</li>
 *     <li>{@code email}: E-mail do hóspede.</li>
 * </ul>
 */
public class Hospedes {
    private int hospedesId;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    /**
     * Construtor da classe hóspedes.
     *
     * @param nome     Nome do hóspede.
     * @param cpf      CPF do hóspede.
     * @param telefone Telefone do hóspede.
     * @param email    E-mail do hóspede.
     */
    public Hospedes(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;}

    /**
     * Método que retorna o ID do hóspede.
     * @return ID do hóspede.
     */
    public int getHospedesId() {
        return hospedesId;}

    /**
     * Método que altera o ID do hóspede.
     * @param hospedesId Novo ID do hóspede.
     */
    public void setHospedesId(int hospedesId) {
        this.hospedesId = hospedesId;}

    /**
     * Método que retorna o nome do hóspede.
     * @return Nome do hóspede.
     */
    public String getNome() {
        return nome;}

    /**
     * Método que altera o nome do hóspede.
     * @param nome Novo nome do hóspede.
     */
    public void setNome(String nome) {
        this.nome = nome;}

    /**
     * Método que retorna o CPF do hóspede.
     * @return CPF do hóspede.
     */
    public String getCpf() {
        return cpf;}

    /**
     * Método que altera o CPF do hóspede.
     * @param cpf Novo CPF do hóspede.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;}

    /**
     * Método que retorna o telefone do hóspede.
     * @return Telefone do hóspede.
     */
    public String getTelefone() {
        return telefone;}

    /**
     * Método que altera o telefone do hóspede.
     * @param telefone Novo telefone do hóspede.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;}

    /**
     * Método que retorna o e-mail do hóspede.
     * @return E-mail do hóspede.
     */
    public String getEmail() {
        return email;}

    /**
     * Método que altera o e-mail do hóspede.
     * @param email Novo e-mail do hóspede.
     */
    public void setEmail(String email) {
        this.email = email;}

   /**
    * Sobrescrita do método {@code toString} para retornar os dados do hóspede.
    * A string retornada contém o nome do hóspede, o ID do hóspede, o CPF, o telefone e o e-mail.
    * @return String com os dados do hóspede.
    */
    @Override
    public String toString() {
        return "\n Hóspede: " + nome + '\n'
                + " ID: " + hospedesId + '\n'
                + " cpf: " + cpf + '\n'
                + " telefone: " + telefone + '\n'
                + " email: " + email + '\n'
                + "-----------------------------------------------------";}
}
