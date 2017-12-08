package controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bd.Data;
import model.bd.Estrella;
import model.bd.Planeta;
import model.bd.Satelite;
import model.bd.SistemaPlanetario;

/**
 *
 * @author dumbo
 */
@WebServlet(name = "CrearSateliteServlet", urlPatterns = {"/crearSatelite.do"})
public class CrearSateliteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Data d = new Data();

            Satelite nuevoSatelite = new Satelite();
            
            nuevoSatelite.setNombre(request.getParameter("txtNombreDeSatelite"));
            nuevoSatelite.setDiametro(Float.parseFloat(request.getParameter("txtDiametroSatelite")));
            nuevoSatelite.setPeridoOrbitalDia(Float.parseFloat(request.getParameter("txtPeridoOrbitalDiaSatelite")));
            nuevoSatelite.setPeridoOrbitalHora(Float.parseFloat(request.getParameter("txtPeridoOrbitalHoraSatelite")));
            nuevoSatelite.setPeridoOrbitalMInuto(Float.parseFloat(request.getParameter("txtPeridoOrbitalMInutoSatelite")));
            
            nuevoSatelite.setIdPlanetaFK(Integer.parseInt(request.getParameter("cboPlaneta")));
            
            d.crearSatelite(nuevoSatelite);
            
            response.sendRedirect("menu.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(CrearSateliteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearSateliteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
