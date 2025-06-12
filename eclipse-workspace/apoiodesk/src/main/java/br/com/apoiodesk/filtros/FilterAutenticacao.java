package br.com.apoiodesk.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.apoiodesk.connection.Conexao;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Intercepta todas as requisições que vierem do projeto ou mapeamento
 */

@WebFilter("/principal/*")
public class FilterAutenticacao extends HttpFilter implements Filter {

	private static Connection connection;

	public FilterAutenticacao() {
		super();

	}

	/* Encerras os processos quando o servidor é parado */
	public void destroy() {

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Intercepta as requisições e as repostas do sistema */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			String usuarioLogado = (String) session.getAttribute("usuario");

			String urlParaAutentica = req.getServletPath();

			/* Validar se está logado */
			if (usuarioLogado == null && !urlParaAutentica.contains("/principal/ServletLogin")) {

				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutentica);
				request.setAttribute("msg", "Por favor realize o login!");
				redireciona.forward(request, response);
				return;

			} else {
				chain.doFilter(request, response);
			}
				connection.commit();
		    } catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/* Inicia os processos */
	public void init(FilterConfig fConfig) throws ServletException {

		connection = Conexao.getConnection();
	}

}
