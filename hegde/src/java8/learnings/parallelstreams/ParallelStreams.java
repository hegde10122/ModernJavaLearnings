package java8.learnings.parallelstreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String[] args) {

        System.out.println(sumParallel());
        System.out.println(sumSequential());

        System.out.println(performanceTesting(ParallelStreams::sumParallel,1100));
        System.out.println(performanceTesting(ParallelStreams::sumSequential,1500));

    }

    private static long performanceTesting(Supplier<Integer> supplier,int numberOfTimes){

        long startTime = System.currentTimeMillis();
        int count = 0;

        //running the same loops a certain number of times for comparison purposes
        while(count < numberOfTimes){
            supplier.get();
            count++;
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private static int sumSequential(){

        return IntStream.rangeClosed(1,1077000).sum();
    }

    private static int sumParallel(){

        return IntStream.rangeClosed(1,1077000).parallel().sum();
    }
}
