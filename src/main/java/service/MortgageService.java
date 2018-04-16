package service;

import domain.Mortgage;

import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@Stateless
public class MortgageService implements MortgageServiceLocal {
    @Override
    public double getInstallment(double amount, double interest, int repaymentPeriod) {
        double q = 1+(interest/12);
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
        double remainedAmount = mortgage.getAmount();
        for (int i = 0; i<mortgage.getRepaymentPeriod();i++){
            double installment = getInstallment(remainedAmount, mortgage.getInterest(), mortgage.getRepaymentPeriod()-installmentStatement.size());
            installmentStatement.put(remainedAmount, installment);
            remainedAmount -= (installment-(remainedAmount*mortgage.getInterest()/12));
        }
        return installmentStatement;
    }


}
