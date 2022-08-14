package java8.learnings.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiplyExe {

    public static void main(String[] args) {

        IMultiply multiply = new MultiplierClass();

        List<Double> integerList = IntStream.rangeClosed(200,299).
                mapToDouble(num -> (double) num).boxed().
                collect(Collectors.toList());

        System.out.println("Result : "+multiply.multiplication(integerList));
        System.out.println("Size : " + multiply.size(integerList));

        //Access static method
        System.out.println(IMultiply.isEmpty(integerList));

    }
}
