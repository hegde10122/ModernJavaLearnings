package java8.learnings.lambdas;

import java.util.Comparator;

public class ComparatorLambda {

    public static void main(String[] args) {
        //Before Java 8 came on the scenes--- this was the old way of writing a compartor interface
        Comparator<Integer> comparator = new Comparator<Integer>(){

            @Override
            public int compare(Integer num1, Integer num2) {
                return num1.compareTo(num2); //0 num1==num2, 1 if num1> num2, -1 if num1 < num2
            }

            //The above method compare takes two integer objects and compares them for equality
            // if equal value 0 is returned, if first integer less than the second then -1 is returned
            // if first integer greater than the second then 1 is returned
        };

        System.out.println("Result old style "+comparator.compare(12,13));
        System.out.println("Result old style "+comparator.compare(14,13));
        System.out.println("Result old style "+comparator.compare(13,13));

        //This is the lambda expression for the above compartor interface
        Comparator<Integer> newComparator  = (Integer a,Integer b) -> a.compareTo(b);

        System.out.println("Result new style "+ newComparator.compare(12,13));
        System.out.println("Result new style "+newComparator.compare(14,13));
        System.out.println("Result new style "+newComparator.compare(13,13));

        //In the above snippet, we can remove Integer and the compiler will automatically gauge the variables to be compared
        Comparator<Integer> newComparator2  = (a, b) -> a.compareTo(b);
        System.out.println("Result new style short "+ newComparator2.compare(12,13));
        System.out.println("Result new style short "+newComparator2.compare(14,13));
        System.out.println("Result new style short "+newComparator2.compare(13,13));

    }
}
