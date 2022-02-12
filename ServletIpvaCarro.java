package com.proj.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IpvaDAO;
import entidadesCarros.Carro;

/**
 * Servlet implementation class IpvaServlets
 * @param <dao>
 */
@WebServlet("/ServletIpvaCarro")
public class ServletIpvaCarro<dao> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao.IpvaDAO dao;
   
	public ServletIpvaCarro() {
	    super();
	    dao = IpvaDAO1(); 
	    }

		private IpvaDAO IpvaDAO1() {
		// TODO Auto-generated method stub
		return null;
	}

		private dao IpvaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
			String id = request.getParameter("id");
		    String ano = request.getParameter("ano");
			
			String option = request.getParameter("option");
						
			if(option.equals("insertForm1")) {
				InsertForm(request, response);
				
			}else if (option.equals("updateForm1")) {
				UpdateForm(request, response);
				
			} else if (option.equals("update1")) {
				Update(request, response); 
			
			} else if (option.equals("insert1")) {
				if ((id != null) && (ano!= null)) {
					if (!id.equals("")){
						 dao = IpvaDAO1();
						 Carro user = new Carro(id, Integer.parseInt(ano));
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
			Integer userBuscar=  dao.buscarUser(id1);
			request.setAttribute("user", userBuscar);
			request.getRequestDispatcher("Cadastro.jsp").forward(request, response);		
		}
		
		protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			String ano = request.getParameter("ano");
			
			
			
			if ((id != null) && (ano != null)) {
				if (!id.equals("")){
					dao = new Dao.IpvaDAO();
					Integer id1 = Integer.parseInt(id);
					Carro user1 = new Carro(id, Integer.parseInt(ano));
					user1.setId(id1);
					dao.updateUser(user1);		
				}
			} 		
		}
		
		protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String modelo = request.getParameter("id");
			String ano = request.getParameter("ano");
			
			if ((modelo != null) && (ano!= null)) {
				if (!modelo.equals("")){
					 dao = new Dao.IpvaDAO();
					 Carro user = new Carro(modelo, Integer.parseInt(ano));
					 dao.addUser(user);
				}
			}	
		}
		
	}