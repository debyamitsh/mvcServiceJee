<%@ page import="java.util.List" %>
<%@ page import="com.example.mvcServiceJee.model.Etudiant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste-Etudiants</title>
</head>
<body>
<table>
    <tr>
        <th>NOM</th>
        <th>PRENOM</th>
        <th>GENRE</th>
        <th>MATRICULE</th>
    </tr>

    <%
        List<Etudiant> etudiants = (ArrayList<Etudiant>) request.getAttribute("listEtudiant");
        for (Etudiant e: etudiants){
    %>
    <tr>
        <td><%= e.getNom()%></td>
        <td><%= e.getPrenom()%></td>
        <td><%= e.getGenre()%></td>
        <td><%= e.getMatricule()%></td>
    </tr>
    <% } %>
</table>
</body>
</html>