package service;

import domain.Mortgage;

import javax.ejb.Stateless;
import java.util.LinkedHashMap;
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

    @Override
    public Map<Double, Double> createInstallmentStatement(Mortgage mortgage) {
        Map<Double,Double> installmentStatement = new LinkedHashMap<>();
        for (int i = 0; i<mortgage.getRepaymentPeriod();i++){
            installmentStatement.put(
                    getRemainedAmount(mortgage.getAmount(),installmentStatement),
                    getInstallment(mortgage.getAmount(),mortgage.getInterest(),mortgage.getRepaymentPeriod()-installmentStatement.size()));
        }

        return installmentStatement;
    }


}
