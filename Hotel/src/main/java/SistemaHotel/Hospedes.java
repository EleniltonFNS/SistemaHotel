package SistemaHotel;

/**
 * Classe que representa os hóspedes do hotel.
 * Possui os atributos hospedesID, nome, cpf, telefone e email.
 * Além de métodos getters e setters.
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
     * Sobrescrita que retorna uma string com os dados do hóspede.
     * @return String com os dados do hóspede.
     */
    @Override
    public String toString() {
        return " Hóspede: " + nome + '\''
                + " ID: " + hospedesId + '\''
                + " cpf: " + cpf + '\''
                + " telefone: " + telefone + '\''
                + " email: " + email + '\'';
    }
}
