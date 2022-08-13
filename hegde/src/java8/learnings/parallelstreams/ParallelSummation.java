package java8.learnings.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelSummation {

    public static void main(String[] args) {

        List<Long> integerList = LongStream.rangeClosed(1,99999999).boxed().collect(Collectors.toList());

        System.out.println("Sum of sequential operation is : "+ sequentialSum(integerList));
        System.out.println("Sum of parallel operation is : "+ parallelSum(integerList));
    }

    /*
     In this example we will consider a use case ----> generate a sequential stream of numbers and calculate the product.
     Log the timings of execution.
     Similarly create a parallel stream and log the timings of calculating the product.
    * check the two methods for their execution timings
    * */

    static double sequentialSum(List<Long> intList){

        double start = System.currentTimeMillis();
        //since
        double summation = intList.stream().mapToDouble(num -> num).reduce(0.0, Double::sum);
        double end = System.currentTimeMillis();

        double duration = end - start;

        System.out.println("Duration for sequential operation (ms) "+duration);

        return summation;
    }

    static double parallelSum(List<Long> intList){

        double start = System.currentTimeMillis();
        //we are using parallelstream()
        double summation = intList.parallelStream().mapToDouble(num -> num).reduce(0.0, Double::sum);
        double end = System.currentTimeMillis();

        double duration = end - start;

        System.out.println("Duration for parallel operation (ms) "+duration);

        return summation;
    }

}
