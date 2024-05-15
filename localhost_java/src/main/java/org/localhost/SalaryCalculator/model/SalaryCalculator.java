package org.localhost.SalaryCalculator.model;

import org.localhost.SalaryCalculator.Taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Map;

// POJO -> plain old java object
// SalaryCalculatorBase
public class SalaryCalculator implements Calculator{
    private static final String PL_ID = "pl_PL";
    private static final String GER_ID = "ger_Ger";
    private static final BigDecimal INIT_TAX = BigDecimal.valueOf(0);
    private static final BigDecimal MIN_SALARY = new BigDecimal("1.00");
    private final Locale defaultLocale = Locale.getDefault();
    private Map<String, Double> taxes;

    @Override
    public BigDecimal calculateSalary(BigDecimal salary) {
        validateSalary(salary);

        if (String.valueOf(defaultLocale).equals(PL_ID)) {
            this.taxes = Taxes.PL_TAXES.getTaxes();

        }
        if (String.valueOf(defaultLocale).equals(GER_ID)) {
            this.taxes = Taxes.GER_TAXES.getTaxes();
        }
        return calculateNetSalary(salary);
    }



    @Override
    public BigDecimal calculateSalary(BigDecimal salary, Map<String, Double> taxes) {
        validateSalary(salary);
        validateTaxes(taxes);

        this.taxes = taxes;
        return calculateNetSalary(salary);
    }

    private BigDecimal calculateNetSalary(BigDecimal salary) {
        BigDecimal totalTax = INIT_TAX;
        for ( Map.Entry<String, Double> tax : taxes.entrySet()) {
            totalTax = totalTax.add(calculateTax(tax.getValue(), salary));
        }
        return salary.subtract(totalTax).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTax(double taxRate, BigDecimal salary) {
        return salary.multiply(new BigDecimal(taxRate));
    }

    private Exception validateSalary(BigDecimal salary) {
        if (salary.compareTo(MIN_SALARY) == -1) {
            throw new ArithmeticException("Provided salary is too low!");
        }
        return null;
    }

    private Exception validateTaxes(Map<String, Double> taxes) {
        if(taxes.isEmpty()) {
            throw new InputMismatchException("Provided taxes do not contain any info");
        }
        return null;
    }
}
