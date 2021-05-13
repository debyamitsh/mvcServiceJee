package com.example.mvcServiceJee.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EtudiantIO {
    public static void save(Etudiant et, String path) throws IOException {
        FileWriter fichier = new FileWriter(path, true);
        fichier.write(et.getNom()+ " " +et.getPrenom()
                                + " "+et.getGenre()+" "+et.getMatricule()+"\n");
        fichier.close();
    }

    public static List<Etudiant> read(String path) throws FileNotFoundException {
        List<Etudiant> listEtudiant = new ArrayList();

        File file = new File(path);
        Scanner in = new Scanner(file);
        Etudiant e = new Etudiant();
        while (in.hasNextLine()) {
            StringTokenizer token = new StringTokenizer(in.nextLine());
            System.out.println(token);
            e.setNom(token.nextToken());
            e.setPrenom(token.nextToken());
            e.setGenre(token.nextToken());
            e.setNom(token.nextToken());
            listEtudiant.add(e);
            e = new Etudiant();
        }
        in.close();
        return listEtudiant;
    }
}
