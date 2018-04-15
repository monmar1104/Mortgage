package servlets;

import domain.Mortgage;
import domain.TypeOfInstallment;
import service.MortgageServiceLocal;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("show-installments")
public class ShowInstallmentsServlet extends HttpServlet {

    @Inject
    MortgageServiceLocal mortgageService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        double amount = Double.parseDouble(request.getParameter("amount"));
        int repaymentPeriod = Integer.parseInt(request.getParameter("repaymentPeriod"));
        double interest = Double.parseDouble(request.getParameter("interest"));
        double margin = Double.parseDouble(request.getParameter("margin"));
        double provision = Double.parseDouble(request.getParameter("provision"));


        Mortgage mortgage = new Mortgage(TypeOfInstallment.FIX, amount, repaymentPeriod, interest, margin, provision);
        Map<Double, Double> installmentStatement = mortgageService.createInstallmentStatement(mortgage);
        request.setAttribute("installmentmap", installmentStatement);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("installment-list.jsp");
        requestDispatcher.forward(request, response);
    }
}
