/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package daw.controllers;

import daw.model.Hermano;
import jakarta.annotation.*;
import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author rafael
 */
@WebServlet(name = "HermanoController", urlPatterns = {"/hermanos", "/hermano/*"})
public class HermanoController extends HttpServlet {

    @PersistenceContext(unitName = "aplicacionHermandadPU")
    private EntityManager em;
    @Resource
    private UserTransaction utx;
    private static final Logger Log = Logger.getLogger(HermanoController.class.getName());

    Date fechaNac = null;
    Date fechaAlta = null;
    Date fechaJura = null;
    int numTelefono = 0;

    private int NumeroDeHermanos = 0;
    private int cuota = 6;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vista;
        String accion = "/hermanos";
        if (request.getServletPath().equals("/hermano")) {
            if (request.getPathInfo() != null) {
                accion = request.getPathInfo();
            } else {
                accion = "error";
            }
        }
        switch (accion) {
            case "/hermanos" -> {
                List<Hermano> lb;
                TypedQuery<Hermano> q = em.createNamedQuery("Hermano.findAll", Hermano.class);
                lb = q.getResultList();
                request.setAttribute("hermano", lb);
                vista = "hermanos";
            }
            case "/new" -> {
                vista = "formHermano";
            }
            default -> {
                vista = "error";
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/" + vista + ".jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getPathInfo();
        if (accion.equals("/save")) {

            //Lectura del Formulario
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String DNI = request.getParameter("dni");
            String fechaNacStr = request.getParameter("fechaNac");
            String direccion = request.getParameter("direccion");
            String numTelefonoStr = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String fechaAltaStr = request.getParameter("fechaAlta");
            String fechaJuraStr = request.getParameter("fechaJura");
            String opcCobro = request.getParameter("opcCobro");
            String numCuenta = request.getParameter("numCuenta");

            Parseado(fechaNacStr, fechaAltaStr, fechaJuraStr, DNI);

            try {
                if (nombre.isEmpty() || apellidos.isEmpty() || fechaNacStr.isEmpty() || direccion.isEmpty() || numTelefonoStr.isEmpty() || opcCobro.isEmpty()) {
                    throw new NullPointerException();
                }
                NumeroDeHermanos++;
                Hermano h = new Hermano(NumeroDeHermanos, nombre, apellidos, DNI, fechaNac, direccion, numTelefono, correo, fechaAlta, fechaJura, cuota, opcCobro, numCuenta);
                save(h);
                response.sendRedirect("http://localhost:28238/aplicacionHermandad/hermanos");
            } catch (Exception e) {
                request.setAttribute("msg", "Error: datos no válidos");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void save(Hermano h) {
        Long id = h.getId();
        try {
            utx.begin();
            if (id == null) {
                em.persist(h);
                Log.log(Level.INFO, "Nuevo Hermano añadido");
            } else {
                Log.log(Level.INFO, "Hermano {0} updated", id);
                em.merge(h);
            }
            utx.commit();
        } catch (Exception e) {
            Log.log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public void Parseado(String fechanac, String fechaalta, String fechajura, String tlfn) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Ajusta el formato según lo que necesites

        try {
            if (fechanac != null) {
                fechaNac = dateFormat.parse(fechanac);
            }
            if (fechaalta != null) {
                fechaAlta = dateFormat.parse(fechaalta);
            }
            if (fechajura != null) {
                fechaJura = dateFormat.parse(fechajura);
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Manejar el error de conversión
        }

        // Convertir String a int (teléfono)
        if (tlfn != null) {
            try {
                numTelefono = Integer.parseInt(tlfn);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Manejar el error de conversión
            }
        }
    }

}
