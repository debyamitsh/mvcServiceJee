package com.example.mvcServiceJee.model;

import java.sql.*;

public class EtudiantDAO {
    static final String user="root";
    static final String pwd="";
    static final String url="jdbc:mysql://127.0.0.1:3306/db_etudiant?useSSL=false";

    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(url, user, pwd);
    }

    // Etablir la connexion
    public static int save() throws SQLException {
        Etudiant et = new Etudiant();
        //1. Creation de la connexion
        Connection connection = getConnexion();

        //2. Statement requete sql
        String requete = "INSERT INTO" +
                "etudiant values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(requete);
        ps.setString(1,et.getMatricule());
        ps.setString(2,et.getNom());
        ps.setString(3,et.getPrenom());
        ps.setString(4,et.getGenre());

        //3. ResultSet represente par une valeur entiere
        return ps.executeUpdate();
    }
}
