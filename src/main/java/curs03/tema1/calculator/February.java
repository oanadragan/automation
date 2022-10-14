package curs03.tema1.calculator;

public class February {
    public static void main(String[] args) {

        for (int year = 1900; year <= 2016; year++) {
            if (((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 != 0)))
            {
                System.out.println("In " + year + " February had 29 days");
            }
            else {
                System.out.println("In " + year + " February had 28 days");
            }
        }
    }
}
