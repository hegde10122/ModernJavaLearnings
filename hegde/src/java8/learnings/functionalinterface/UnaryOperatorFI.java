package java8.learnings.functionalinterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorFI {

    //unary operator accepts integer and produces an integer multiple of 5 for the input in this use case
    static final UnaryOperator<Integer>  operator = (num) -> num * 5;

    //binary operator accepts two integers and produces an integer in this example
    static final BinaryOperator<Integer> biOperator = (num1,num2) -> num1 + num2;

    //maxBy and minBy methods are also available in the BinaryOperator Functional interface class
    //We define the comparator
    static final Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {

        //Unary Operator extends the Function Functional Interface.
        //Use this unary operator when the input and output are of the same data types.
        System.out.println(operator.apply(5));

        //Binary Operator extends the BiFunction Functional Interface.
        //Use this binary operator when the input and output are of the same data types.
        //here we are providing two integer input parameters which produces integer output
        System.out.println(biOperator.apply(4,5));

        //We use the maxBy method for the Binary operator
        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Result of maxBy is : "+maxBy.apply(8,10));

        //We use the  minBy method for the Binary operator
        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Result of minBy is : "+minBy.apply(18,22));

    }
}
