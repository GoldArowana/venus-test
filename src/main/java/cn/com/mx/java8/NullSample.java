package cn.com.mx.java8;

public class NullSample {
    private static void printUpperCase(String str) {
        if (null == str) {
            System.out.println("-[NONE]-");
        } else {
            System.out.println(str.toUpperCase());
        }
    }

    public static void main(String[] args) {
        String javaAuthor = "James Gosling";
        String nothing = null;
        printUpperCase(javaAuthor);
        printUpperCase(nothing);
    }
}
