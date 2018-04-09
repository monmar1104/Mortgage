package service;

import javax.ejb.Stateless;

@Stateless
public class MortgageService implements MortgageServiceLocal {
    @Override
    public double getFirstInstallment(double amount, double interest, int repaymentPeriod) {
        double q = (1+interest/12);
        double pow = Math.pow(q, (double) repaymentPeriod);
        return amount * pow *(q-1)/(pow-1);

    }
}
