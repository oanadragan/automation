package curs03.tema1.calculator;

public class Calculator {
    public static void main(String[] args) {
        if (args.length == 3) {
            float a = Float.parseFloat(args[0]);
            float b = Float.parseFloat(args[2]);
            String operator = args[1];

            switch (operator) {

                case "+": {
                    float result = a + b;
                    System.out.println(a + " + " + b + " = " + result);
                    break;
                }
                case "-": {
                    float result = a - b;
                    System.out.println(a + " - " + b + " = " + result);
                    break;
                }
                case "*": {
                    float result = a * b;
                    System.out.println(a + " - " + b + " = " + result);
                    break;
                }
                case "/": {
                    float result = a / b;
                    System.out.println(a + " - " + b + " = " + result);
                    break;
                }
                default: {
                    System.out.println("Invalid operator!");
                    break;
                }
            }
        }
        else {
            System.err.println("3 args are needed!");
        }
    }
}
