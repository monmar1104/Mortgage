package service;

import javax.ejb.Stateless;
import java.util.Map;

@Stateless
public class MortgageService implements MortgageServiceLocal {
    @Override
    public double getInstallment(double amount, double interest, int repaymentPeriod) {
        double q = (1+interest/12);
        double pow = Math.pow(q, (double) repaymentPeriod);
        return amount * pow *(q-1)/(pow-1);

    }

    @Override
    public double getRemainedAmount(double startAmount, Map<Double, Double> installments) {
        double sumOfInstallment = installments.values().stream().reduce(0.0,Double::sum);
        return startAmount-sumOfInstallment;
    }


}
