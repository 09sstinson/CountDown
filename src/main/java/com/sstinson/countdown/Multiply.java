package com.sstinson.countdown;

public class Multiply extends BinaryOperation{
    public OperationType type = OperationType.MULTIPLY;
    public double calculate(double x, double y){
        return x * y;
    }
    public String toString(){
        return type.toString();
    }
}
