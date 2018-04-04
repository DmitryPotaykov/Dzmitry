package Servelet.kursy;

import by.kursy.model.logic.ByKursyDimapotyakovJDBC;
import by.kursy.model.logic.LogicService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//

@WebServlet(name = "MyServelet", urlPatterns = {"/MyServelet"})
public class MyServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("command");

        if (command == null) {

            String result = ByKursyDimapotyakovJDBC.test();

            request.setAttribute("list", result);

//        String cmd = request.getParameter("command");
//        
//        String page = "error.jsp";
//        
//        switch(cmd){
//            case "sum": page = LogicService.sum(request); break;
//            case "sub": page = LogicService.sub(request); break;
//        }
//         
            request.getRequestDispatcher("newjsp.jsp").forward(request, response);
        } else {

            switch (command) {
                case "find":
                    String name = request.getParameter("Name");
                    String pass = request.getParameter("Passport");
                    String ph = request.getParameter("Phone");
                    String pr = request.getParameter("Cost");
                    String colors = request.getParameter("colors");

                    response.setContentType("text/html;charset=UTF-8");

                    PrintWriter out = response.getWriter();
                    out.println("<h3>Аренда автомобилей</h3>");
                    out.println("Color: " + colors + "<br>");
                    out.println("Name: " + name + "<br>");
                    out.println("Passport: " + pass + "<br>");
                    out.println("Price: " + pr + "<br>");
                    out.println("Phone: " + ph + "<br>");
                    out.close();
                    break;
                case "show":
                    break;
            }

        }
//        response.sendRedirect(page);
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
        processRequest(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

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
