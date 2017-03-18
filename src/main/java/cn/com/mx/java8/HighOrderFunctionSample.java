package cn.com.mx.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HighOrderFunctionSample {
    public static void main(String[] args) {
        class Book {
            private String title;
            private int year;
            private Book(String title, int year) {
                this.title = title;
                this.year = year;
            }
        }

        List<Book> books =Arrays.asList(
                new Book("Java 8 Lambdas", 2014),
                new Book("Thinking in Java 3rd", 2002),
                new Book("Thinking in Java 4th", 2006),
                new Book("Java 8 in Action", 2014));

        String bookTitles0 = "";
        for (Book book: books) {
            if (book.year > 2010) {
                if (!bookTitles0.isEmpty())
                    bookTitles0 += ", ";
                bookTitles0 += book.title;
            }
        }
        System.out.println(bookTitles0);

        String bookTitles1 = books.stream()
                .filter(book -> book.year > 2010)
                .map(book -> book.title)
                .reduce("", (s1, s2) -> (s1.isEmpty())? s2: s1 + ", " + s2);
        System.out.println(bookTitles1);

        String bookTitles = books.stream()
                .filter(book -> book.year > 2010)
                .map(book -> book.title)
                .collect(Collectors.joining(", "));
        System.out.println(bookTitles);
    }
}
