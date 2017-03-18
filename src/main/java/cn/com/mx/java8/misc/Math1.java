package cn.com.mx.java8.misc;

/**
 * @author Benjamin Winterberg
 */
public class Math1 {

    public static void main(String[] args) {
//        testMathExact();
        testUnsignedInt();
    }

    private static void testUnsignedInt() {
        try {
            int i = Integer.parseUnsignedInt("123", 10);//-123则报错
            System.err.println(i);
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage()+"111");
        }

        long maxUnsignedInt = (1l << 32) - 1;
        System.out.println(maxUnsignedInt);//4294967295

        String string = String.valueOf(maxUnsignedInt);//4294967295

        int unsignedInt = Integer.parseUnsignedInt(string, 10);//-1
        System.out.println(unsignedInt);

        String string2 = Integer.toUnsignedString(unsignedInt, 10);//4294967295
        System.out.println(string2);

        try {
            int parseInt = Integer.parseInt(string, 10);
            System.err.println(parseInt);
        }
        catch (NumberFormatException e) {
            System.err.println("could not parse signed int of " + maxUnsignedInt);
        }
    }

    private static void testMathExact() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);

        try {
            Math.addExact(Integer.MAX_VALUE, 1);
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage()+1);
        }

        try {
            Math.toIntExact(Long.MAX_VALUE);
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage()+2);
        }
    }
}
