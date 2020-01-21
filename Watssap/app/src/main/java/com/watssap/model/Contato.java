package com.watssap.model;

public class Contato {

    private long id;
    private long idUser;
    private long contactUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getContactUser() {
        return contactUser;
    }

    public void setContactUser(long contactUser) {
        this.contactUser = contactUser;
    }
}
