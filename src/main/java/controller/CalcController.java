package src.main.java.controller;

import src.main.java.service.CalcService;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CalcController {
    Scanner sc = new Scanner(System.in);

    CalcService calcService = new CalcService();

    public void runCalculatorConsoleApp() {
        while(true) {
            showMenu();
            String userAction = getUserAction("Enter the Action number you want to perform ");
            completeUserAction(userAction);
        }
    }

    private Double[] getUserInputs(String s) {
        printCalculatorResult(s);
        double num1 = getNum();
        double num2 = getNum();
        return new Double[]{num1, num2};
    }


    private void completeUserAction(String userAction) {
        switch (userAction) {
            case "1":
                addition();
                break;
            case "2":
                subtraction();
                break;
            case "3":
                multiplication();
                break;
            case "4":
                divide();
                break;
            case "5":
                modulus();
                break;
            case "6":
                factorial();
                break;
            case "7":
                root();
                break;
            case "8":
                exponential();
                break;
            case "9":
                logMethod();
                break;
            case "10":
                sine();
                break;
            case "11":
                cosine();
                break;
            case "12":
                percentage();
                break;
            case "13":
                conversion();
                break;
            case "14":
                showHistory();
                break;
            case "15":
                System.exit(200);
                break;
            default:
                System.out.println("Enter the valid input!!");

        }
    }

    private void conversion() {
        double num = getNum();
        System.out.println("Enter Unit of quantity :");
        String presentUnit = sc.nextLine();
        System.out.println("Enter New Unit of quantity :");
        String newUnit = sc.nextLine();
        double res= calcService.conversion(num, presentUnit, newUnit);
        printCalculatorResult("Result is : " + res +" "+ newUnit);
    }

    private void percentage() {
        Double[] nums = getUserInputs("Enter numbers : " );
        double res= calcService.percentage(nums[0], nums[1]);
        printCalculatorResult("Result is : " + res);
    }

    private void cosine() {
        double num = getNum();
        double res = calcService.cosine(num);
        printCalculatorResult("Result is : " + res);
    }

    private void sine() {
        double num = getNum();
        double res = calcService.sine(num);
        printCalculatorResult("Result is : " + res);
    }

    private void logMethod() {
        double num = getNum();
        double res = calcService.logMethod(num);
        printCalculatorResult("Result is : " + res);
    }

    private void exponential() {
        double num = getNum();
        double res = calcService.exponential(num);
        printCalculatorResult("Result is : " + res);
    }

    private void printCalculatorResult(String res) {
        System.out.println(res);
    }

    private double getNum() {
        return Double.parseDouble(sc.nextLine());
    }

    private void root() {
        double num = getNum();
        double res = calcService.squareRoot(num);
        printCalculatorResult("Result is : " + res);
    }

    private void showHistory() {
        Stack<String> result = calcService.showHistory();
        for(String s : result){
            printCalculatorResult(s);
        }
    }

    private void factorial() {
        double num = getNum();
        double res = calcService.factorial(num);
        printCalculatorResult("Result is : " + res);
    }

    private void modulus() {
        Double[] nums = getUserInputs("Enter numbers : " );
        double res = calcService.modulus(nums[0], nums[1]);
        printCalculatorResult("Result is : " + res);
    }

    private void divide() {
        Double[] nums = getUserInputs("Enter numbers : " );
        double res= calcService.divide(nums[0], nums[1]);
        printCalculatorResult("Result is : " + res);
    }

    private void multiplication() {
        Double[] nums = getUserInputs("Enter numbers : " );
        double res = calcService.multiplication(nums[0], nums[1]);
        printCalculatorResult("Result is : " + res);
    }

    private void subtraction() {
        Double[] nums = getUserInputs("Enter numbers : " );
        double res = calcService.subtract(nums[0], nums[1]);
        printCalculatorResult("Result is : " + res);
    }

    private void addition() {
        Double[] nums = getUserInputs("Enter numbers : " );
        double res = calcService.add(nums[0], nums[1]);
        printCalculatorResult("Result is : " + res);
    }

    private String getUserAction(String userAction){
            System.out.print(userAction + " : ");
            return sc.nextLine();
    }

    private void showMenu(){
        printCalculatorResult("Welcome to the Calculator Console App!!");
        printCalculatorResult("Pick the action items : ");
        printCalculatorResult("1. Addition");
        printCalculatorResult("2. Subtraction");
        printCalculatorResult("3. Multiply");
        printCalculatorResult("4. Divide");
        printCalculatorResult("5. Modulus");
        printCalculatorResult("6. Factorial");
        printCalculatorResult("7. Root");
        printCalculatorResult("8. Exponential");
        printCalculatorResult("9. Log");
        printCalculatorResult("10. Sine");
        printCalculatorResult("11. Cosine");
        printCalculatorResult("12. Percentage");
        printCalculatorResult("13. Conversion");
        printCalculatorResult("14. Show History");
        printCalculatorResult("15. Exit!!");
    }

}

