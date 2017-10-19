/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ServiciosContexto;
import DAO.ServiciosUnidadA;
import VO.Contexto;
import VO.UnidadAbstracta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LabingXEON
 */
public class InsertarunidadAstracta extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
    
            
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

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    

   boolean resultado = false;
        String respuesta = null;
        String idUni = request.getParameter("iduni");
        String id = request.getParameter("id");
        String idT=request.getParameter("idT");

        int id_c = Integer.parseInt(id);
        int id_m=Integer.parseInt(idUni);
        int id_T=Integer.parseInt(idUni);
        
        if (idUni.trim().length() > 0 && id.trim().length() > 0 && idT.trim().length()>0) {
            resultado = true;
            UnidadAbstracta con = new UnidadAbstracta(id_c, id_m, id_T);
            ServiciosUnidadA serC = new ServiciosUnidadA();
            serC.agregarUnidad(con);

            RequestDispatcher rq = request.getRequestDispatcher("");

            if (resultado == true) {
                request.setAttribute("resultado", true);
            } else {
                request.setAttribute("resultado", false);
            }

            rq.forward(request, response);
        } else {
            request.setAttribute("resultado", false);
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
