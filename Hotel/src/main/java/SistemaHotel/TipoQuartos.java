package SistemaHotel;

public class TipoQuartos {
    private int id;
    private String descricao;
    private int capacidadePessoas;
    private double precoDiaria;

    // Constructor
    public TipoQuartos(int id, String descricao, int capacidadePessoas, double precoDiaria) {
        this.id = id;
        this.descricao = descricao;
        this.capacidadePessoas = capacidadePessoas;
        this.precoDiaria = precoDiaria;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    public void setCapacidadePessoas(int capacidadePessoas) {
        this.capacidadePessoas = capacidadePessoas;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    @Override
    public String toString() {
        return "TipoQuartos{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", capacidadePessoas=" + capacidadePessoas +
                ", precoDiaria=" + precoDiaria +
                '}';
    }
}

