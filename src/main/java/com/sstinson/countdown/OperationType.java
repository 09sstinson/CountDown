package com.sstinson.countdown;

public enum OperationType {
    ADD, SUBTRACT, MULTIPLY,DIVIDE;

    public String toString(){
        switch(this){
            case ADD: return "Add";
            case DIVIDE: return "Divide";
            case MULTIPLY: return "Multiply";
            case SUBTRACT: return "Subtract";
            default: return "ERROR";
        }
    }
}
