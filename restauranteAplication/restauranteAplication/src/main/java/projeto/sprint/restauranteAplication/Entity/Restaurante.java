package projeto.sprint.restauranteAplication.Entity;

public class Restaurante {

    private String cnpj;
    private String descricao;
    private String horarioFuncionamento;
    private Endereco endereco;

    // Construtor, getters e setters


    public Restaurante(String cnpj, String descricao, String horarioFuncionamento, Endereco endereco) {
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.horarioFuncionamento = horarioFuncionamento;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
