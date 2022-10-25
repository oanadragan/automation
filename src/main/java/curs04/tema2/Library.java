package curs04.tema2;

public class Library {

    public static void main(String[] args) {

        Author a1 = new Author("Gabor Mate", "gabor.mate@gmail.com");
        Book b1 = new Book("When the Body Says No ", 2003, a1, 30);

        b1.printBook();

    }
}
