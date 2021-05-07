package com.example.mvcServiceJee.model;


import java.io.FileWriter;
import java.io.IOException;

public class EtudiantIO {
    public static void save(Etudiant et, String path) throws IOException {
        FileWriter fichier = new FileWriter(path);
        fichier.write(et.getNom()+ "," +et.getPrenom()
                                + ","+et.getGenre()+","+et.getMatricule());
        fichier.close();
    }
}
