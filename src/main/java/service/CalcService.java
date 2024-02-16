package src.main.java.service;

import src.main.java.repository.CalcRepository;

import java.util.Stack;

public class CalcService {
    CalcRepository repository = new CalcRepository();
    private void operationHistory(Double num1, Double num2,String operation, double result) {
        String historyEntry = String.format("%f %s %f = %f", num1, operation, num2, result);
        repository.addHistory(historyEntry);
    }
    private void operationHistory(Double num1,String operation, double result) {
        String historyEntry = String.format("%f %s = %f", num1, operation, result);
        repository.addHistory(historyEntry);
    }

    public Stack<String> showHistory() {
        return repository.getHistory();
    }
    public double add(Double num1, Double num2) {
        double result = num1 + num2;
        operationHistory(num1, num2, "add", result);
        return result;

    }

    public double subtract(Double num, Double num1) {
        double result = num-num1;
        operationHistory(num, num1, "subtract", result);
        return result;
    }

    public double multiplication(Double num, Double num1) {
        double result = num*num1;
        operationHistory(num, num1, "multiply", result);
        return result;
    }

    public double divide(Double num, Double num1) {
        if (num1 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double result = num/num1;
        operationHistory(num, num1, "divide", result);
        return result;
    }

    public double modulus(Double num, Double num1) {
        if (num1 == 0) {
            throw new IllegalArgumentException("Cannot modulus by zero");
        }
        double result = num%num1;
        operationHistory(num, num1, "modulus", result);
        return result;
    }

    public double factorial(Double num) {
        double result = 1;
        if (!(num == 0 | num == 1)) {
            result = num * factorial(num - 1);
        }
        operationHistory(num,"Factorial", result );
        return result;
    }


    public double squareRoot(double num) {
        double result = Math.sqrt(num);
        operationHistory(num, "root", result);
        return result;

    }

    public double exponential(double num) {
        double result = Math.exp(num);
        operationHistory(num, "exponential", result);
        return result;
    }

    public double logMethod(double num) {
        double result = Math.log10(num);
        operationHistory(num, "log", result);
        return result;
    }

    public double sine(double num) {
        double result = Math.sin(num);
        operationHistory(num, "sine", result);
        return result;
    }

    public double cosine(double num) {
        double result = Math.cos(num);
        operationHistory(num, "cosine", result);
        return result;
    }

    public double percentage(double num, double num1) {
        double result = divide(multiplication(num,num1), 100.00);
        operationHistory(num, num1, "percentage", result);
        return result;
    }

    public double conversion(double num, String fromUnit, String toUnit) {
        double result= 0.0;
        if (fromUnit.equalsIgnoreCase("meters") && toUnit.equalsIgnoreCase("feet")) {
            result = num * 3.28084; // 1 meter = 3.28084 feet
        } else if (fromUnit.equalsIgnoreCase("feet") && toUnit.equalsIgnoreCase("meters")) {
            result = num / 3.28084; // 1 foot = 0.3048 meters
        } else {
            System.out.println("Conversion not supported");
        }
        operationHistory(num, "CONV", result);
        return result;
    }
}
