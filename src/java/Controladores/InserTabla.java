/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ServiciosEsquema;
import DAO.ServiciosTabla;
import VO.Esquema;
import VO.Tabla;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Index;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Manuel
 */
public class InserTabla extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

   
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher rq = request.getRequestDispatcher("InserTabla");
        ServiciosEsquema ser = new ServiciosEsquema();
        ArrayList<Esquema> lis = null;
        lis = (ArrayList<Esquema>) ser.listarEs();
        if (lis.size() > 0) {

            request.setAttribute("lis", lis);
        } else {
            request.setAttribute("lis", null);
        }
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        boolean resultado = false;

        ServiciosEsquema ser = new ServiciosEsquema();

        String id = request.getParameter("idTabla");
        String nombre = request.getParameter("name");
        String nombreES = request.getParameter("nombreEsquema");

        int id_tabla = Integer.parseInt(id);
        int id_Esquema = Integer.parseInt(nombreES);
        if (id.trim().length() > 0 && nombre.trim().length() > 0 && nombreES.trim().length() > 0) {

            resultado = true;

            Esquema es = new Esquema();

            ServiciosTabla st = new ServiciosTabla();

            es = ser.extraerEsquema(nombreES);
            Tabla t = new Tabla(id_tabla, es.getId_esquema(), nombre);
            st.agragarTabla(t);

            RequestDispatcher rq = request.getRequestDispatcher("InsertarTabla.jsp");

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
