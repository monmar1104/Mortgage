package service;

import javax.ejb.Local;

@Local
public interface MortgageServiceLocal {
    double getFirstInstallment(double amount, double interest, int repaymentPeriod);
}
