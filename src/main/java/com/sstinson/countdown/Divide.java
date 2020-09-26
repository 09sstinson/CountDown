package com.sstinson.countdown;

public class Divide extends BinaryOperation {
    //TODO: need a nice way of dealing with x/0 that doesn't break code
    public OperationType type = OperationType.DIVIDE;
    public double calculate(double x, double y){
        return x / y;
    }

    public String toString(){
        return "\u00F7";
    }
}
