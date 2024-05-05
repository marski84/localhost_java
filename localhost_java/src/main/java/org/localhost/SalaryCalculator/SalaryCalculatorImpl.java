package org.localhost.SalaryCalculator;

import org.localhost.SalaryCalculator.model.SalaryCalculator;

import java.math.BigDecimal;

public class SalaryCalculatorImpl {
    public static void main(String[] args) {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        BigDecimal salary = new BigDecimal( "5000.00");
        salaryCalculator.calculateSalary(salary);
    }
}
