package model;

public class OpcaoVoto {
    private int id;
    private String descricao;
    private int enqueteId;

    public OpcaoVoto(int id, String descricao, int enqueteId) {
        this.id = id;
        this.descricao = descricao;
        this.enqueteId = enqueteId;
    }

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

    public int getEnqueteId() {
        return enqueteId;
    }

    public void setEnqueteId(int enqueteId) {
        this.enqueteId = enqueteId;
    }

    @Override
    public String toString() {
        return "Opcao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", enqueteId=" + enqueteId +
                '}';
    }
}
