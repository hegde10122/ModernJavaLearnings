package java8.learnings.functionalinterface;

import java.util.Locale;
import java.util.function.Function;

public class FunctionFI {


    //Function takes input parameter here as a String and returns Integer (length of string) as the output.
   private static final Function<String,Integer> function = (address) -> address.length();

   //Function SAM interface takes input parameter as String and returns output as a String
    private static final Function<String,String> function2 = (address) -> address.toLowerCase(Locale.ROOT);

    private static final Function<String,String> function3 = (name) -> name.concat("concats");

    public static void main(String[] args) {

        //12 characters --- hence returned output is 12. Check in the console after running this program.
        System.out.println("Result :: "+function.apply("GANESH HEGDE"));

        //lowercase value is returned
        System.out.println("Result :: "+function2.apply("GANESH R HEGDE"));

        //And then method
        System.out.println("Chaining function is "+function3.andThen(function2).apply("USA UK SCOT "));

        //compose method ---- function2 work first, then function acts on tha result produced
        System.out.println("---- compose function is "+function.compose(function2).apply("USA UK SCOT "));

    }
}
