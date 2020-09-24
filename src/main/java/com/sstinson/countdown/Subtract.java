package com.sstinson.countdown;

public class Subtract extends BinaryOperation {
    public OperationType type = OperationType.SUBTRACT;
    public double calculate(double x, double y){
        return x - y;
    }
    public String toString(){
        return type.toString();
    }
}
