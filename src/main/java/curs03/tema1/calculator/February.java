package curs03.tema1.calculator;
import java.util.Scanner;
public class February {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a year: ");
        int year = input.nextInt();
        if (year >= 1900 && year <= 2016) {
            if (((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 != 0))) {
                System.out.println("In " + year + " February had 29 days");
            } else {
                System.out.println("In " + year + " February had 28 days");
            }
        } else {
            System.out.println("Please enter a year between 1900 and 2016");
        }
    }
}

