/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/helloworld")
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
        String msg = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String msg = "";
        
        String lang = request.getParameter("lang");
        if(lang == null)
            lang = "pt";

        switch(lang){
            case "pt":
                msg = "Olá, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
            case "de":
                msg = "Hallo, ";
                break;
            case "es":
                msg = "Hola, ";
                break;
            case "it":
                msg = "Ciao, ";
                break;
        }
        
        String voct = request.getParameter("voct");
        if(voct == null)
            voct = "";
        
        switch(voct){
            case "Sr.":
                msg = msg + "Sr. ";
                break;
            case "Sra.":
                msg = msg + "Sra. ";
                break;
        }
        
        String nome = request.getParameter("name");
        if (nome == null)
            nome = "XPTO";
        
        msg = msg + nome + ", ";
        
        LocalTime now = LocalTime.now();
        if (now.getHour() >= 0 && now.getHour() <= 11){
            switch(lang){
                case "pt":
                    msg = msg + "Bom Dia!";
                    break;
                case "en":
                    msg = msg + "Good Morning!";
                    break;
                case "fr":
                    msg = msg + "Bon Matin!";
                    break;
                case "de":
                    msg = msg + "Guten Morgen!";
                    break;
                case "es":
                    msg = msg + "Buen día!";
                    break;
                case "it":
                    msg = msg + "Buongiorno!";
                    break;
            }
        } else if (now.getHour() >= 12 && now.getHour() <= 18) {
            switch(lang){
                case "pt":
                    msg = msg + "Bom Tarde!";
                    break;
                case "en":
                    msg = msg + "Good Afternoon!";
                    break;
                case "fr":
                    msg = msg + "Bon Après-midi!";
                    break;
                case "de":
                    msg = msg + "Guten Tag!";
                    break;
                case "es":
                    msg = msg + "Buenas Tardes!";
                    break;
                case "it":
                    msg = msg + "Buon Pomeriggio!";
                    break;
            }
        } else {
            switch(lang){
                case "pt":
                    msg = msg + "Bom Noite!";
                    break;
                case "en":
                    msg = msg + "Good Night!";
                    break;
                case "fr":
                    msg = msg + "Bonne Nuit!";
                    break;
                case "de":
                    msg = msg + "Gute Nacht!";
                    break;
                case "es":
                    msg = msg + "Buenas Noches!";
                    break;
                case "it":
                    msg = msg + "Buona Notte!";
                    break;
            }
        }
        
        String st = "d";
        String estilo = request.getParameter("style");
        if (estilo == null)
            estilo = "Normal";
        
        switch (estilo) {
            case "Normal":
                st = "d";
                break;
            case "Moderno":
                st = "n";
                break;
            case "Antigo":
                st = "o";
                break;
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(
                "<!DOCTYPE html>" +
                "<html>" +
                "   <head>" +
                "       <title>Desenvolvimento de Aplicações Corporativas</title>" +
                "       <meta charset=\"UTF-8\">" +
                "       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "       <link rel=\"stylesheet\" href=\"Bootstrap/css/bootstrap.min.css\">" +
                "       <link rel=\"stylesheet\" href=\"FontAwesome/css/all.css\">" +
                "       <link rel=\"stylesheet\" href=\"styles/helloworld.css\">" +
                "   </head>" +
                "   <body class=\"hello-world-body-" + st + "\">" +
                "       <div class=\"hello-world-div-" + st + "\">" +
                "           <p class=\"h1 hello-world-text-" + st + "\">" +
                "               " + msg +
                "           </p>" +
                "       </div>" +
                "   </body>" +
                "</html>"
            );
        }
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
