package org.localhost.SalaryCalculator.model;

import java.math.BigDecimal;
import java.util.Map;

public interface Calculator {

      BigDecimal calculateSalary(BigDecimal salary);
      BigDecimal calculateSalary(BigDecimal salary, Map<String, Double> taxes);
}

