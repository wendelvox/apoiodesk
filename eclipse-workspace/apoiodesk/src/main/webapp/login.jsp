<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Recuperando os valores enviados pelo formulário
    String usuario = request.getParameter("usuario");
    String senha = request.getParameter("senha");

    // Simulação de autenticação simples
    if ("admin".equals(usuario) && "1234".equals(senha)) {
        session.setAttribute("usuarioLogado", usuario);
        response.sendRedirect("home.jsp"); // Redireciona para a tela inicial
    } else {
%>
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <title>Erro no Login</title>
        </head>
        <body>
            <h2 style="color:red;">Login ou senha inválidos.</h2>
            <a href="index.jsp">Voltar</a>
        </body>
        </html>
<%
    }
%>