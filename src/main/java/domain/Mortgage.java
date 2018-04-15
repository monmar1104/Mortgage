package domain;

import java.math.BigDecimal;

public class Mortgage {
    private TypeOfInstallment typeOfInstallment;
    private double amount;
    private int repaymentPeriod;
    private double interest;
    private double margin;
    private double provision;

    public Mortgage() {
    }

    public Mortgage(TypeOfInstallment typeOfInstallment, double amount, int repaymentPeriod, double interest, double margin, double provision) {
        this.typeOfInstallment = typeOfInstallment;
        this.amount = amount;
        this.repaymentPeriod = repaymentPeriod;
        this.interest = interest;
        this.margin = margin;
        this.provision = provision;
    }


    public TypeOfInstallment getTypeOfInstallment() {
        return typeOfInstallment;
    }

    public void setTypeOfInstallment(TypeOfInstallment typeOfInstallment) {
        this.typeOfInstallment = typeOfInstallment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getProvision() {
        return provision;
    }

    public void setProvision(double provision) {
        this.provision = provision;
    }


}
