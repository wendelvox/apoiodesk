package br.com.apoiodesk.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import br.com.apoiodesk.model.Venda;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RelatorioServlet
 */
@WebServlet("/relatorio")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public RelatorioServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Venda> vendas = Arrays.asList(
	            new Venda(1, "Notebook", 2, 4000.0),
	            new Venda(2, "Mouse", 10, 50.0),
	            new Venda(3, "Teclado", 5, 150.0)
	        );

	        request.setAttribute("vendas", vendas);
	        request.getRequestDispatcher("relatorio.jsp").forward(request, response);
		
		
		
	}

}
