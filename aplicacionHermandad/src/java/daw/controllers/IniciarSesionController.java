package daw.controllers;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Servlet para manejar el inicio de sesión
 */
@WebServlet(name = "IniciarSesionController", urlPatterns = {"/inicio"})
public class IniciarSesionController extends HttpServlet {

    @PersistenceContext(unitName = "aplicacionHermandadPU")
    private EntityManager em;

    @Resource
    private jakarta.transaction.UserTransaction utx;

    private static final Logger Log = Logger.getLogger(IniciarSesionController.class.getName());

    // Credenciales predeterminadas
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cargar el formulario de inicio de sesión
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/inicio.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Leer los parámetros del formulario de inicio de sesión
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validar las credenciales del usuario
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Inicio de sesión exitoso: crear una sesión y redirigir a la página de bienvenida
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirigir al dashboard o página principal
            response.sendRedirect(request.getContextPath() + "WEB-INF/views/hermanos.jsp");
        } else {
            // Si las credenciales son incorrectas, redirigir al formulario de nuevo con un mensaje de error
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/inicio.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Controlador de inicio de sesión";
    }
}
