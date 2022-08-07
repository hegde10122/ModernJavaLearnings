package java8.learnings.functionalinterface;

import java.util.function.Consumer;

//FI -- short form for Functional Interface
public class ConsumerFI {

    public static void main(String[] args) {

        //We are creating a consumer functional interface that accepts an integer input and prints twice of that integer
        Consumer<Integer> c1 = (num) -> System.out.println(num * 2);

        //pass an input to this consumer variable and run this program to see the ouput in the console--u will see 200 !!
        c1.accept(100);
    }
}
