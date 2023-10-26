package projeto.sprint.restauranteAplication.Entity;

public class HistoricoDeNavegacao {

    private String url;
    private String data;

    public HistoricoDeNavegacao(String url, String data) {
        this.url = url;
        this.data = data;
    }

    // Getters - Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
