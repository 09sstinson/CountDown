package com.sstinson.countdown;

import java.util.Stack;

public class Main {

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push("(");
        stack.push(")");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.get(0));
    }

    public boolean checkBalancedBrackets(String s){
        Stack a = new Stack();
        char top = '0';
        //boolean flag = false;
        for(int i =0; i < s.length(); i++){

            if(s.charAt(i) == '('){
                a.push('(');
                //flag = true;
                continue;
            }

            if(s.charAt(i) == ')'){
                if(!a.empty()) {
                    if (a.peek() instanceof Character) {
                        top = (Character) a.peek();
                        if (top == '(') {
                            a.pop();
                        } else {
                            System.out.println("here" + i);
                            break;
                        }
                    }
                } else{
                    return false;
                }
            }
        }
        return a.empty();
    }
}
