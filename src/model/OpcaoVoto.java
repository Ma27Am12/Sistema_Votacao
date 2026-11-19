package model;

public class OpcaoVoto {
    private int id;
    private String texto;
    private int enqueteId;

    public OpcaoVoto(int id, String texto, int enqueteId) {
        this.id = id;
        this.texto = texto;
        this.enqueteId = enqueteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getEnqueteId() {
        return enqueteId;
    }

    public void setEnqueteId(int enqueteId) {
        this.enqueteId = enqueteId;
    }
}
