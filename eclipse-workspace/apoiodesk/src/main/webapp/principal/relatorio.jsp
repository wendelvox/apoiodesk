<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.apoiodesk.model.Venda" %>

<%
    // Verifica se o usuário quer exportar para Excel ou PDF
    String formato = request.getParameter("formato");

    if ("excel".equalsIgnoreCase(formato)) {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_vendas.xls");
    } else if ("pdf".equalsIgnoreCase(formato)) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=relatorio_vendas.pdf");
%>
        <!-- Conteúdo específico para PDF aqui -->
<%
        return;
    } else {
        response.setContentType("text/html;charset=UTF-8");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Relatório de Vendas</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #aaa;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Relatório de Vendas</h1>

    <% if (!"excel".equalsIgnoreCase(formato) && !"pdf".equalsIgnoreCase(formato)) { %>
        <p><a href="?formato=excel">Exportar para Excel</a> | <a href="?formato=pdf">Exportar para PDF</a></p>
    <% } %>

    <table>
        <tr>
            <th>ID</th>
            <th>Produto</th>
            <th>Quantidade</th>
            <th>Valor (R$)</th>
        </tr>
        <%
            List<Venda> vendas = (List<Venda>) request.getAttribute("vendas");
        	if (vendas == null) {
             out.println("<p style='color:red;'>Erro: Dados não encontrados. Certifique-se de acessar esta página através do servlet.</p>");
             } else {
            for (Venda venda : vendas) {
        %>
        <tr>
            <td><%= venda.getId() %></td>
            <td><%= venda.getProduto() %></td>
            <td><%= venda.getQuantidade() %></td>
            <td><%= String.format("%.2f", venda.getValor()) %></td>
        </tr>
        <% }} %>
    </table>
</body>
</html>