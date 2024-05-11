package org.localhost.SalaryCalculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Map;

public class SalaryCalculator implements Calculator{
    private Locale defaultLocale = Locale.getDefault();
    private final String PL_ID = "pl_PL";
    private final String GER_ID = "ger_Ger";
    private final BigDecimal INIT_TAX = BigDecimal.valueOf(0);
    private Map<String, Double> taxes;

    public SalaryCalculator() {
    }



    @Override
    public BigDecimal calculateSalary(BigDecimal salary) {
        BigDecimal totalTax = INIT_TAX;

        if (String.valueOf(defaultLocale).equals(PL_ID)) {
            this.taxes = Taxes.PL_TAXES;

        }
        if (String.valueOf(defaultLocale).equals(GER_ID)) {
            this.taxes = Taxes.GER_TAXES;
        }

        for (double taxValue: taxes.values()) {
            BigDecimal tax = this.calculateTax(taxValue, salary);
            totalTax = totalTax.add(tax);
        }
        BigDecimal formatedSalary = salary.subtract(totalTax).setScale(2, RoundingMode.HALF_UP);
        return formatedSalary;
    }

    @Override
    public BigDecimal calculateSalary(BigDecimal salary, Map<String, Double> taxes) {
        BigDecimal totalTax = INIT_TAX;

        for (double taxValue: taxes.values()) {
            BigDecimal tax = this.calculateTax(taxValue, salary);
            totalTax = totalTax.add(tax);
        }

        BigDecimal formatedSalary = salary.subtract(totalTax).setScale(2, RoundingMode.HALF_UP);
        return formatedSalary;
    }

    private BigDecimal calculateTax(double taxRate, BigDecimal salary) {
        return salary.multiply(new BigDecimal(taxRate));
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }


    public Map<String, Double> getTaxes() {
        return taxes;
    }



    private static class Taxes {
        static public final Map<String, Double> PL_TAXES = Map.of(
                "incomeTax", 0.12,
                "healthInsuranceContribution", 0.09,
                "pensionInsuracne", 0.0976,
                "disabilityInsurance", 0.015,
                "sicknessInsurance", 0.0245);

        static public final Map<String, Double> GER_TAXES = Map.of(
                "incomeTax", 0.3,
                "healthInsuranceContribution", 0.2,
                "pensionInsuracne", 0.03,
                "disabilityInsurance", 0.03,
                "sicknessInsurance", 0.03);
    }

}
