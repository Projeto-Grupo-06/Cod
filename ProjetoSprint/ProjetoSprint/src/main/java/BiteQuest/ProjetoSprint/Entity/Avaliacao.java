package BiteQuest.ProjetoSprint.Entity;

public class Avaliacao {
    private int id;
    private int idCliente;
    private int nota;
    private String comentario;

    public Avaliacao(int id, int idCliente, int nota, String comentario) {
        this.id = id;
        this.idCliente = idCliente;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao [id=" + id + ", idCliente=" + idCliente + ", nota=" + nota + ", comentario=" + comentario + "]";
    }
}

