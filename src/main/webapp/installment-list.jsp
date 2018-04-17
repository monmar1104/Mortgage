<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<br>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/fontello/css/fontello.css" type="text/css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center">Harmonogram spłaty kredytu hipotecznego</h3></body></br>
<p>Całkowity koszt kredytu: <fmt:formatNumber value="${totalMortgageCost}" type="currency"/> </p>
<c:set var="lp" value="0"/>

<table class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th>L.p.</th>
        <th>Kwota raty</th>
        <th>Kwota pozostała</th>
    </tr>
    </thead>
    <c:forEach var="entry" items="${installmentmap}">
        <c:set var="lp" value="${lp+1}"/>
        <tr>
            <th scope="row">${lp}</th>
            <td><fmt:formatNumber value="${entry.value}" type="currency"/></td>
            <td><fmt:formatNumber value="${entry.key}" type="currency"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>