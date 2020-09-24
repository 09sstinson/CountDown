package com.sstinson.countdown;

public class Add extends BinaryOperation {
    public OperationType type = OperationType.ADD;
    public double calculate(double x, double y){
        return x + y;
    }
    public String toString(){
        return type.toString();
    }
}
