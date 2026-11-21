package model;

public class Voto {
    private int id;
    private int usuarioId;
    private int enqueteId;
    private int opcaoId;

    public Voto(int id, int usuarioId, int enqueteId, int opcaoId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.enqueteId = enqueteId;
        this.opcaoId = opcaoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEnqueteId() {
        return enqueteId;
    }

    public void setEnqueteId(int enqueteId) {
        this.enqueteId = enqueteId;
    }

    public int getOpcaoId() {
        return opcaoId;
    }

    public void setOpcaoId(int opcaoid) {
        this.opcaoId = opcaoid;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", enqueteId=" + enqueteId +
                ", opcaoId=" + opcaoId +
                '}';
    }
}
