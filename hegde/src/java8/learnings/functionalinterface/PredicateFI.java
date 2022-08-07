package java8.learnings.functionalinterface;

import java.util.function.Predicate;

public class PredicateFI {

    private static final Predicate<Integer> p1 = (i) -> i % 2 == 1;
    private static final Predicate<Integer> p2 = (i) -> i % 5 == 0;


    public static void main(String[] args) {

        //predicate interface accepts an input and returns true if the condition is satisfied
        //in the below example predicate p1 accepts integer and returns true if it is odd integer or else returns false

        //use case 1
        System.out.println(p1.test(8)); //test() method accepts the integer input parameter
        System.out.println(p1.test(11)); //test() method accepts input -- we have to use this method while using predicate

        predicateChainingAnd(); //predicate chaining concept using AND
        predicateChainingOr(); //predicate chaining concept using OR
        predicateNegate(); //predicate chaining concept using negate()

    }

    //use case 4 ---- we will test for negation predicate
    private static void predicateNegate() {

        //40 --- even but divisible by 5 --- one predicate fails --- hence output is false --
        // but this result is negated -- final result is true
        System.out.println("Chaining predicates NEGATE "+p1.and(p2).negate().test(40));

        //45 --- odd and divisible by 5 also --- result true --- but due to negate() the final result is false
        System.out.println("Chaining predicates NEGATE "+p1.or(p2).negate().test(45));

    }

    //use case 3 --- we will test integer if it is odd but at the same time divisible by 5
    private static void predicateChainingOr() {

        //15 --- odd and divisble by 5 --- true ---- since both predicates are true
        System.out.println("Chaining predicates AND "+p1.and(p2).test(15));

        //20 --- even but divisible by 5 --- one predicate fails --- hence output is false
        System.out.println("Chaining predicates AND "+p1.and(p2).test(20));
    }

    //use case 2 --- we will test integer if it is odd or divisible or 5
    private static void predicateChainingAnd(){

        //25 is odd and also divisible by 5 --- true since at least one condition is satisfied.
        System.out.println("Chaining predicates OR "+p1.or(p2).test(25));

        //32 is neither odd nor divisible by 5 --- false is returned
        System.out.println("Chaining predicates OR "+p1.or(p2).test(32));

    }




}
