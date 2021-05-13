package com.example.mvcServiceJee.controller;

import com.example.mvcServiceJee.model.Etudiant;
import com.example.mvcServiceJee.model.EtudiantIO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "saveStudentServlet", value = "/saveEtudiant.html")
public class saveStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String chemin = this.getServletContext().getRealPath("/WEB-INF/dataSource.txt");
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(req.getParameter("name"));
        etudiant.setPrenom(req.getParameter("lastName"));
        etudiant.setGenre(req.getParameter("genre"));
        etudiant.setMatricule(req.getParameter("matricule"));

        //Ecriture dans le fichier
        EtudiantIO.save(etudiant, chemin);
        //Lecture dans le fichier
        List<Etudiant> etudiants = EtudiantIO.read(chemin);
        //Ajout des attributs supplementaires a la requete
        req.setAttribute("listEtudiant", etudiants);
        String url = "/WEB-INF/liste.jsp";
        RequestDispatcher requestDispatcher = this.getServletContext()
                .getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }
}
