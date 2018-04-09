package service;

import domain.Mortgage;
import domain.TypeOfInstallment;
import org.junit.Test;

import javax.ejb.EJB;
import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MortgageServiceTest {

@Inject
private MortgageServiceLocal mortgageService;
    @Test
    public void checkFirstInstallment() {
        Mortgage mortgage = new Mortgage(TypeOfInstallment.DECREASE, 300000.00, 360, 0.06, 0.015, 0.005);
        assertThat(mortgageService.getFirstInstallment(mortgage.getAmount(), mortgage.getInterest() ,mortgage.getRepaymentPeriod()), is(1798.6515754582326));
    }

}
