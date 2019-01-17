<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 17.01.19
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Dodawanie do koszyka</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
<body>
<%@include file="header.jsp" %>

<h1>Dodawanie do koszyka</h1>

<div class="container">
    <h3>Lista dostępnych produktów:</h3>
    <c:if test="${not empty products}">
        <p>Wyszukaj w tabeli:</p>
        <input class="form-control" id="searchPhrase" type="text" placeholder="szukana fraza..">
        <br>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th> ID</th>
                <th> Nazwa</th>
                <th> Cena</th>
                <th> Dodawanie produktów do koszyka</th>
            </tr>
            </thead>
            <tbody id="customersTab">
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}zł</td>
                    <td>
                        <form class="form" action="/addToCart" method="post">
                            <div class="form-group">
                                <input type="hidden" name="id" id="id" value="${product.id}">
                                Podaj liczbę szt:
                                <input type="number" name="quantity" id="quantity" min="1" step="1" value="1">
                                <button type="submit" class="btn btn-info">Dodaj do koszyka</button>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty products}">
        <h4>brak produktów</h4>
    </c:if>
</div>

<script>
    $(document).ready(function () {
        $("#searchPhrase").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#vehiclesTab tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>

</body>
</html>
