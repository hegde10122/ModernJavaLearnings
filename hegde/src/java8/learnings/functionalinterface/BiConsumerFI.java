package java8.learnings.functionalinterface;

import java.util.function.BiConsumer;

public class BiConsumerFI {

    public static void main(String[] args) {

        //this bi consumer takes two integer inputs and returns the power
        BiConsumer<Integer,Integer> biConsumer = (Integer a, Integer b) -> {
            System.out.printf("%d to the power of %d is %.2f",a,b,Math.pow(a,b));
        };

        //accept 2 and 4 to return the output 2 raised to power of 4 = 16...run the program and see the output in the console.
        biConsumer.accept(2,4);

        System.out.println();

        BiConsumer<Integer,Integer> biConsumerDiv = (a,b) -> System.out.printf("\nDivision of %d by %d is %.2f",a,b,(a/(b*1.0))); //.2f means return decimal places only
        //perform chaining of two bi consumers using andThen(0 method
        biConsumer.andThen(biConsumerDiv).accept(14,6);

    }
}
