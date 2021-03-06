package service;

import domain.Mortgage;
import domain.TypeOfInstallment;
import org.junit.Test;

import javax.ejb.EJB;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MortgageServiceTest {

@EJB
private MortgageServiceLocal mortgageService = new MortgageService();
    @Test
    public void checkFirstInstallment() {
        Mortgage mortgage = new Mortgage(TypeOfInstallment.DECREASE, 300000.00, 360, 0.06, 0.015, 0.005);
        assertThat(mortgageService.getInstallment(mortgage.getAmount(), mortgage.getInterest() ,mortgage.getRepaymentPeriod()), is(1798.6515754582326));
    }

    @Test
    public void checkMortgageListSize(){
        Mortgage mortgage = new Mortgage(TypeOfInstallment.DECREASE, 300000.00, 360, 0.06, 0.015, 0.005);
        int installmentStatementSize = mortgageService.createInstallmentStatement(mortgage).size();
        assertThat(installmentStatementSize, is(360));
    }

    @Test
    public void checkFirstInstallmentFromList(){
        Mortgage mortgage = new Mortgage(TypeOfInstallment.DECREASE, 300000.00, 360, 0.06, 0.015, 0.005);
        Double secondInstallment = mortgageService.createInstallmentStatement(mortgage).get(300000.00);
        assertThat(secondInstallment, is(1798.6515754582326));
    }

    @Test
    public void checkRemainingAmount(){
        Map<Double,Double> installments = new LinkedHashMap<>();
        installments.put(300000.00,1500.00);
        installments.put(298500.00,1500.00);
        installments.put(297000.00,1500.00);

        assertThat(mortgageService.getRemainedAmount(300000.00, installments),is(295500.00));
    }

}
