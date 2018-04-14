package service;

import javax.ejb.Local;
import java.util.Map;

@Local
public interface MortgageServiceLocal {
    double getInstallment(double amount, double interest, int repaymentPeriod);
    double getRemainedAmount(double startAmount, Map<Double, Double> installments);
}
