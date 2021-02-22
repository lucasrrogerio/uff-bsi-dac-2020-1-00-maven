/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getParameters(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getParameters(request, response);
    }

    private void getParameters(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String lang = request.getParameter("lang");
        String msg = validateMessage(lang);

        String nome = request.getParameter("nome");
        nome = validateUsername(nome);

        String email = request.getParameter("email");
        email = validadeEmail(email);

        String idade = request.getParameter("idade");
        idade = validateAge(idade);

        String genero = request.getParameter("genero");
        genero = validateGender(genero);

        createPage(response, msg, nome, email, idade, genero);
    }

    private void createPage(HttpServletResponse response, String msg, String nome, String email, String idade, String genero)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + nome + "!</p>");
            out.println("<p> Seu email é "+ email + ".</p>");
            out.println("<p> Você tem "+ idade + " anos.</p>");
            out.println("<p> Seu gênero é " + genero + ".</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String validateMessage(String lang) {
        if(lang == null)
            lang = "pt";
        switch(lang){
            case "en":
                return "Hello, ";
            case "fr":
                return "Bonjour, ";
            case "de":
                return "Hallo, ";
            default:
                return "Alô, ";
        }
    }

    private String validateUsername(String nome) {
        if (nome == null) {
            nome = "Fulano";
        }
        return nome;
    }

    private String validadeEmail(String email) {
        if (email == null) {
            email = "fulano@gmail.com";
        }
        return email;
    }

    private String validateAge(String idade) {
        if (idade == null) {
            idade = "50";
        }
        return idade;
    }

    private String validateGender(String genero) {
        if (genero == null) {
            genero = "outro";
        }
        return genero;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
