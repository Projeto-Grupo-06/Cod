package BiteQuest.ProjetoSprint.Entity;

public class Endereco {
    private int id;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String complemento;
    private String cep;
    private String numero;

    public Endereco(int id, String logradouro, String cidade, String bairro, String complemento, String cep, String numero) {
        this.id = id;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", logradouro=" + logradouro + ", cidade=" + cidade + ", bairro=" + bairro +
                ", complemento=" + complemento + ", cep=" + cep + ", numero=" + numero + "]";
    }
}

