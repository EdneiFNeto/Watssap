package com.watssap.model;

public class Chat {

    private int id;
    private int idUser;
    private int contectUser;
    private String message;
    private String nomeUser;

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getContectUser() {
        return contectUser;
    }

    public void setContectUser(int contectUser) {
        this.contectUser = contectUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
