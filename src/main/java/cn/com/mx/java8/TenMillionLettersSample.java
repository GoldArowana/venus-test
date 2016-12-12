package cn.com.mx.java8;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TenMillionLettersSample {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        String letters = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> "" + (char)c)
                .collect(Collectors.joining());

        String repeated = Collections.nCopies(10000000, letters)
                .parallelStream()
                .collect(Collectors.joining());

        Map<String, Long> result = repeated.chars()
                .parallel()
                .mapToObj(c -> "" + (char)c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        long endTime=System.currentTimeMillis();
        System.out.println(result);
        System.out.println("" + (endTime - startTime) / 1000.0 + "s");
    }
}
