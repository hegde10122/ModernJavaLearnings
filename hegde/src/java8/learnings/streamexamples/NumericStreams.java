package java8.learnings.streamexamples;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreams {
    
    //Here we will code various examples ---- problem1,problem2 etc
    
    
    public static void main(String[] args) {

        System.out.println(problem1());
        System.out.println(problem2().isPresent() ? problem2().getAsDouble() : "Nothing to average");
        System.out.println(problem3().isPresent() ? problem3().getAsInt() : "No minima found");
    }

    private static OptionalInt problem3() {

        //problem statement --- find minimum value in the range 50 to 100.
        //change the range to 200-50...What will be the minima? Check the answer in the console
        return IntStream.rangeClosed(50,100).min();

    }

    private static OptionalDouble problem2() {

        //problem statement --- find average of all odd integers between 1 and 100.
        //since 100 is an even number we can exclude that----so we use range() method here
        //OptionalDouble is used because the stream could contain 0 elements ---  In that case average cannot be calculated
      return   IntStream.range(1,100).
                filter( i -> i % 2 == 1). // we filter out the odd integers using this predicate
                average();

    }

    private static Integer problem1() {

        //problem statement ---- find sum of all even integers between 1 and 50 ---- i.e. 2,4,6,...50

        //Here we consider closed range for 1 to 25...both numbers are included...then we multiply each number by 2
        //to get --- all even numbers between 1 and 50....then we perform the sum which is the final result.
       return IntStream.rangeClosed(1,25).map( x -> x * 2).sum();
    }

}
