package java8.learnings.interfaces;

import java.util.List;

public class MultiplierClass implements IMultiply{


    @Override
    public Double multiplication(List<Double> doubleList) {
       return doubleList.stream().reduce(1.0,(a,b) -> a * 0.01 * b);
    }

    public long size(List<Double> doubleList){
        System.out.println("Multiplierclass");

        return doubleList.size();
    }
}
