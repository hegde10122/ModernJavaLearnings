package java8.learnings.interfaces;

import java.util.List;

public interface IMultiply {

Double multiplication(List<Double> doubleList);

default long size(List<Double> doubleList){
    return doubleList.size();
}

static boolean isEmpty(List<Double> doubleList){

    return doubleList!=null && doubleList.size() > 0;
}

}
