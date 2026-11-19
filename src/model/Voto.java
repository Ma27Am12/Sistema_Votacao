package model;

public class Voto {
    private int id;
    private int usuarioId;
    private int opcaoid;

    public Voto(int id, int usuarioId, int opcaoid) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.opcaoid = opcaoid;
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

    public int getOpcaoid() {
        return opcaoid;
    }

    public void setOpcaoid(int opcaoid) {
        this.opcaoid = opcaoid;
    }
}
