package com.proj.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CarroDAO;
import entidadesCarros.Carro;

/**
 * Servlet implementation class ServletBase
 */
@WebServlet("/ServletBase")
public class ServletBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	 private CarroDAO dao;
	   
	    public ServletBase() {
	        super();
	        dao = new CarroDAO(); 
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
			String id = request.getParameter("id");
			String modelo = request.getParameter("modelo");
			String ano = request.getParameter("ano");
			
			String option = request.getParameter("option");
			
			
			if(option.equals("insertForm")) {
				InsertForm(request, response);
				
			}else if (option.equals("updateForm")) {
				UpdateForm(request, response);
				
			} else if (option.equals("update")) {
				Update(request, response); 
				
			} else if (option.equals("delete")) {
				Delete(request, response);
			
			} else if (option.equals("insert")) {
				if ((modelo != null) && (ano!= null)) {
					if (!modelo.equals("")){
						 dao = new CarroDAO();
						 Carro user = new Carro(modelo, Integer.parseInt(ano));
						 dao.addUser(user);
					}
				}
				
			}				
			request.setAttribute("lista", dao.getListUser());
			
			request.getRequestDispatcher("/").forward(request, response);			
		}
		
		
		protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("Cadastro.jsp").forward(request, response);		
		}
		
		
		
		protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			
			Integer id1 = Integer.parseInt(id);
			Carro userBuscar=  dao.buscarUser(id1);
			request.setAttribute("user", userBuscar);
			request.getRequestDispatcher("Cadastro.jsp").forward(request, response);		
		}
		
		protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			String modelo = request.getParameter("modelo");
			String ano = request.getParameter("ano");
			
			
			
			if ((modelo != null) && (ano != null)) {
				if (!modelo.equals("")){
					dao = new CarroDAO();
					Integer id1 = Integer.parseInt(id);
					Carro user1 = new Carro(modelo, Integer.parseInt(ano));
					user1.setId(id1);
					dao.updateUser(user1);		
				}
			} 		
		}
		
		
		
		protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			if (id != null) {
				Integer id1 = Integer.parseInt(id);
				dao = new CarroDAO();
				dao.removeUser(id1);
			}		
		}
		
		
		protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String modelo = request.getParameter("modelo");
			String ano = request.getParameter("ano");
			
			if ((modelo != null) && (ano!= null)) {
				if (!modelo.equals("")){
					 dao = new CarroDAO();
					 Carro user = new Carro(modelo, Integer.parseInt(ano));
					 dao.addUser(user);
				}
			}	
		}
		
	}