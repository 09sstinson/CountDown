package com.sstinson.countdown;

import java.util.ArrayList;

public abstract class BinaryOperation {
    public abstract double calculate(double x, double y);
    public OperationType type;

    public abstract String toString();

    public ArrayList<Double> calculateAtIndex(ArrayList<Double> array, int index ){
        if(index < 0 || index >= array.size() - 1){
            System.out.println("ERROR out of bounds index");
            return null;
        }
        double result = calculate(array.get(index) , array.get(index +1));
        ArrayList<Double> copy = new ArrayList<>(array);
        copy.remove(index);
        copy.set(index,result);
        return copy;
    }
}
