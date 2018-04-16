<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
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
<body>
<div class="container">
    <h4>Aby obliczyć kredyt wprowadź dane</h4>
    <div class="form-group">
        <form method="post" action="show-installments">
            <label for="amount">Kwota kredytu</label><input type="text" id="amount" name="amount"><br/>
            <label for="repaymentPeriod">Okres spłaty [mies.]</label> <input type="text" id="repaymentPeriod"
                                                                             name="repaymentPeriod"><br/>
            <label for="interest">Stopa procentowa</label> <input type="text" id="interest" name="interest"><br/>
            <label for="margin">Marża banku</label> <input type="text" id="margin" name="margin"><br/>
            <label for="provision">Prowizja</label> <input type="text" id="provision" name="provision"><br/>
            <input type="submit" name="show-installments" value="Show installment list">
        </form>
    </div>
</div>
</body>
</html>
