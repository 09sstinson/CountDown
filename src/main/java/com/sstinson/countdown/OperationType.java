package com.sstinson.countdown;

// Parent class for all operations: add, subtract, divide, multiply
public enum OperationType {
    ADD, SUBTRACT, MULTIPLY,DIVIDE;

    public String toString(){
        switch(this){
            case ADD: return "\u002B";
            case DIVIDE: return "\u00F7";
            case MULTIPLY: return "\u00D7";
            case SUBTRACT: return "\u2212";
            default: return "ERROR";
        }
    }
}
