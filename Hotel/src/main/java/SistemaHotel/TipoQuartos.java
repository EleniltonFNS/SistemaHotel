package SistemaHotel;

/**
 * Classe que representa um tipo de quarto no sistema de hotel.
 * Contém informações sobre a descrição, capacidade de pessoas e preço da diária.
 * <p>
 * Atributos:
 *  <ul>
 *     <li>{@code tipoQuartosId}: ID único de cada tipo de quarto.</li>
 *     <li>{@code nome}: Nome do tipo de quarto.</li>
 *     <li>{@code capacidadePessoas}: Capacidade de pessoas do tipo de quarto.</li>
 *     <li>{@code precoDiaria}: Preço da diária do tipo de quarto.</li>
 *     <li>{@code descricao}: Descrição do tipo de quarto.</li>
 *  </ul>
 */
public class TipoQuartos {
    private int tipoQuartosId;
    private String nome;
    private int capacidadePessoas;
    private double precoDiaria;
    private String descricao;


    // Constructor

    /**
     * Construtor da classe TipoQuartos.
     * <p>
     * Os campos obrigatórios são verificados e devem ser preenchidos corretamente.
     * @param nome              Nome do tipo de quarto.
     * @param capacidadePessoas Capacidade de pessoas do tipo de quarto.
     * @param precoDiaria       Preço da diária do tipo de quarto.
     * @param descricao         Descrição do tipo de quarto.
     */
    public TipoQuartos(String nome, int capacidadePessoas, double precoDiaria, String descricao) {
        // Verifica se os campos obrigatórios foram preenchidos.
        if (nome == null || descricao == null || capacidadePessoas <= 0 || precoDiaria <= 0) {
            throw new IllegalArgumentException(" - Todos os campos são obrigatórios.");
        }

        this.nome = nome;
        this.capacidadePessoas = capacidadePessoas;
        this.precoDiaria = precoDiaria;
        this.descricao = descricao;
    }

    // Getters and Setters
    /**
     * Método que retorna o ID do tipo de quarto.
     * @return ID do tipo de quarto.
     */
    public int getTipoQuartosId() {
        return tipoQuartosId;
    }

    /**
     * Método que retorna o nome do tipo de quarto.
     * @return Nome do tipo de quarto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome do tipo de quarto.
     * @param nome Novo nome do tipo de quarto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna a descrição do tipo de quarto.
     * @return Descrição do tipo de quarto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método que altera a descrição do tipo de quarto.
     * @param descricao Nova descrição do tipo de quarto.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método que retorna a capacidade de pessoas do tipo de quarto.
     * @return Capacidade de pessoas do tipo de quarto.
     */
    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    /**
     * Método que altera a capacidade de pessoas do tipo de quarto.
     * @param capacidadePessoas Nova capacidade de pessoas do tipo de quarto.
     */
    public void setCapacidadePessoas(int capacidadePessoas) {
        this.capacidadePessoas = capacidadePessoas;
    }

    /**
     * Método que retorna o preço da diária do tipo de quarto.
     * @return Preço da diária do tipo de quarto.
     */
    public double getPrecoDiaria() {
        return precoDiaria;
    }

    /**
     * Método que altera o preço da diária do tipo de quarto.
     * @param precoDiaria Novo preço da diária do tipo de quarto.
     */
    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    /**
     * Sobrescrita do método {@code toString} para retornar os dados do tipo de quarto.
     * A string retornada contém o nome do tipo de quarto, o ID do tipo de quarto, a capacidade de pessoas,
     * o preço da diária e a descrição do tipo de quarto.
     * @return String com os dados do tipo de quarto.
     */
    @Override
    public String toString() {
        return "Tipo de Quarto: " + nome + "\n"
                + "ID: " + tipoQuartosId + "\n"
                + "Capacidade de Pessoas: " + capacidadePessoas + "\n"
                + "Preço da Diária: R$ " + precoDiaria + "\n"
                + "Descrição: " + descricao;
    }
}

