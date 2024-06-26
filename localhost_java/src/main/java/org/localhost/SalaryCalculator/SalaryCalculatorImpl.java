package org.localhost.SalaryCalculator;

import org.localhost.SalaryCalculator.model.SalaryCalculator;

import java.math.BigDecimal;
import java.util.Map;

public class SalaryCalculatorImpl {
    public static void main(String[] args) {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        BigDecimal salary = new BigDecimal( "10.00");
        Map<String, Double> taxes= Map.of(
                "incomeTax", 0.12,
                "healthInsuranceContribution", 0.09,
                "pensionInsuracne", 0.0976,
                "disabilityInsurance", 0.015,
                "sicknessInsurance", 0.0245);
        Map<String, Double> emptyTaxes = Map.of();
        System.out.println(salaryCalculator.calculateSalary(salary, emptyTaxes));
//        salaryCalculator.calculateSalary(salary);
//        salaryCalculator.calculateSalary(salary, taxes);
//        System.out.println(salaryCalculator.calculateSalary(salary, taxes));
    }
}
