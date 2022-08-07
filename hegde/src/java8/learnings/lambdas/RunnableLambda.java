package java8.learnings.lambdas;

import java.util.Comparator;

public class RunnableLambda {

    public static void main(String[] args) {

        //Before Java8 --- runnable interface was defined this way
        Runnable beforeJava8 = new Runnable() { //create anonymous class
            @Override
            public void run() {
                System.out.println("Runnable old style legacy coding");
            }
        };

        new Thread(beforeJava8).start(); //before Java8 is a Runnable Interface instance

        //Using Java 8 lambda syntax
        // () -> {};

        //using java 8 style
        Runnable runnableL = () -> System.out.println("Runnable new java 8 style - simple and concise");
        new Thread(runnableL).start();

        //even better!!
        new Thread(() -> System.out.println("Check concise way")).start();
    }
}
