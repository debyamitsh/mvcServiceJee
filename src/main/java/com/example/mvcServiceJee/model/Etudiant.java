package com.example.mvcServiceJee.model;

public class Etudiant extends Personne{
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    private String matricule;
}
