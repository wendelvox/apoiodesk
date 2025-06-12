<%@ page import="br.com.apoiodesk.connection.Conexao" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Teste de Conexão</title></head>
<body>
<%
    try {
        Connection conn = Conexao.getConnection();
        out.println("Conectado ao banco de dados com sucesso!");
    } catch (Exception e) {
        out.println("Erro ao conectar: " + e.getMessage());
    }
%>
</body>
</html>