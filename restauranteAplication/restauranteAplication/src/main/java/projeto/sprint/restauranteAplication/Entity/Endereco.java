package projeto.sprint.restauranteAplication.Entity;

public class Endereco {

    private String logradouro;
    private String cidade;
    private String bairro;
    private String complemento;
    private String cep;
    private int numero;

    // Construtor, getters e setters


    public Endereco(String logradouro, String cidade, String bairro, String complemento, String cep, int numero) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
