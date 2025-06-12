package br.com.apoiodesk.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import br.com.apoiodesk.model.LoginModel;

@WebServlet(urlPatterns = {"/principal/ServletLogin"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		HttpSession session = request.getSession();
		
		 // Usuário já logado? Redireciona
        if (session.getAttribute("usuario") != null) {
            if (url != null && !url.isEmpty()) {
                response.sendRedirect(url);
            } else {
                response.sendRedirect("/apoiodesk/principal/home.jsp");
            }
            return;
        }
		
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			
			LoginModel usuario = new LoginModel();		
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			if(usuario.getLogin().equalsIgnoreCase("admin") && usuario.getSenha().equalsIgnoreCase("1234")) {
				
				
				request.getSession().setAttribute("usuario", usuario.getLogin());
				RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/home.jsp");
				redirecionar.forward(request, response);
				
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Informe o login e senha corretamente!");
				redirecionar.forward(request, response);
			}
			
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe o login e senha corretamente!");
			redirecionar.forward(request, response);
		}
		
		
		
		
		
	}

}
