package model;

public class Enquete {
    private int id;
    private String titulo;
    private String descricao;
    private int criadorId;

    public Enquete(int id, String titulo, String descricao, int criadorId){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.criadorId = criadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCriadorId() {
        return criadorId;
    }

    public void setCriadorId(int criadorId) {
        this.criadorId = criadorId;
    }


    @Override
    public String toString() {
        return "Enquete{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", criadorId=" + criadorId +
                '}';
    }
}
