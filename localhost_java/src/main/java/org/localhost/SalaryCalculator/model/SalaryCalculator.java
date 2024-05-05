package org.localhost.SalaryCalculator.model;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;

public class SalaryCalculator implements Calculator{
    private Locale defaultLocale = Locale.getDefault();
    private BigDecimal salary;
    private Map<String, Double> taxes;

    public SalaryCalculator(BigDecimal salary) {
        this.salary = salary;
        System.out.println(defaultLocale);
    }

    public SalaryCalculator(BigDecimal salary, Map<String, Double> taxes) {
        this.salary = salary;
        this.taxes = taxes;
    }

    @Override
    public BigDecimal calculateSalary(BigDecimal salary) {
        return null;
    }

    @Override
    public BigDecimal calculateSalary(BigDecimal salary, Map<String, Double> taxes) {
        return null;
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Map<String, Double> getTaxes() {
        return taxes;
    }


    class Option {
        localValues()
    }
}
