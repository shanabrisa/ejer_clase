package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOContacto;
import modelos.Contacto;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String telefono=request.getParameter("telefono");
		
		DAOContacto dao=new DAOContacto();
		
		if(nombre!=null && telefono!=null){
			nombre=nombre.trim();
			telefono=telefono.trim();
			if(!nombre.equals("") && !telefono.equals("")){
				Contacto c=new Contacto(nombre,telefono);
				
				dao.crear(c);
			}
		}
		
		ArrayList<Contacto> l=dao.getListado();
		request.setAttribute("listado",l);
		
		ServletContext contexto=request.getServletContext();
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/principal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
