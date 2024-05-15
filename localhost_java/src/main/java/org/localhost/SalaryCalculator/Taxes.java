package org.localhost.SalaryCalculator;

import java.util.Map;

public enum Taxes {
    PL_TAXES(Map.of(
            "incomeTax", 0.12,
            "healthInsuranceContribution", 0.09,
            "pensionInsurance", 0.0976,
            "disabilityInsurance", 0.015,
            "sicknessInsurance", 0.0245
    )),
    GER_TAXES(Map.of(
            "incomeTax", 0.3,
            "healthInsuranceContribution", 0.2,
            "pensionInsurance", 0.03,
            "disabilityInsurance", 0.03,
            "sicknessInsurance", 0.03
    ));

    private final Map<String, Double> taxes;

    Taxes(Map<String, Double> taxes) {
        this.taxes = taxes;
    }

    public Map<String, Double> getTaxes() {
        return this.taxes;
    }
}
