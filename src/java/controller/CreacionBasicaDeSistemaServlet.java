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
import model.bd.SistemaPlanetario;

/**
 *
 * @author dumbo
 */
@WebServlet(name = "CreacionBasicaDeSistemaServlet", urlPatterns = {"/creacionBasicaDeSistema.do"})
public class CreacionBasicaDeSistemaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Data d = new Data();

            SistemaPlanetario nuevoSistemaPlanetario = new SistemaPlanetario();
            Estrella nuevaEstrella = new Estrella();
            Planeta nuevoPlaneta = new Planeta();

            nuevoSistemaPlanetario.setNombre(request.getParameter("txtSistemaPlanetario"));
            nuevaEstrella.setNombre(request.getParameter("txtEstrella"));

            nuevoPlaneta.setNombre(request.getParameter("txtNombrePlaneta"));
            nuevoPlaneta.setSimbologia(request.getParameter("txtSimbologiaPlaneta"));
            
            nuevoPlaneta.setDiametroEcuatorial(Float.parseFloat(request.getParameter("txtDiametroEcuatorialPlaneta")));
            nuevoPlaneta.setMasa(Float.parseFloat(request.getParameter("txtMasaPlaneta")));
            nuevoPlaneta.setRadioOrbital(Float.parseFloat(request.getParameter("txtRadioOrbitalPlaneta")));

            nuevoPlaneta.setPeriodoOrbital(Float.parseFloat(request.getParameter("txtPeriodoOrbitalPlaneta")));
            nuevoPlaneta.setPeriodoDeRotacion(Float.parseFloat(request.getParameter("txtPeriodoDeRotacionPlaneta")));

            nuevoPlaneta.setComposicionAtmosfera(request.getParameter("txtComposiciónAtmosferaPlaneta"));
            
            System.out.println();

            nuevoPlaneta.setIdTipoDePlanetaFK(Integer.parseInt(request.getParameter("cboTipoDePlaneta")));

            d.creacionBasica(nuevoSistemaPlanetario, nuevaEstrella, nuevoPlaneta);
            response.sendRedirect("menu.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(CreacionBasicaDeSistemaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreacionBasicaDeSistemaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
