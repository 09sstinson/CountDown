package com.sstinson.countdown;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

    //public ArrayList<Double> results = new ArrayList<>();
    public Set<Double> results = new LinkedHashSet<>(20000);
    public CombinatoricsUtil obj = new CombinatoricsUtil();
    public Add adder = new Add();
    public Subtract subtracter = new Subtract();
    public Divide divider = new Divide();
    public Multiply multiplier = new Multiply();
    public double target = 744.0;
    public boolean targetReached = false;
    public ArrayList<BinaryOperation> targetOperations;
    public ArrayList<Integer> orderOfOperations;
    public ArrayList<Double> targetPermutation;


    public static void main(String[] args){

    }

    public void printOutput(){
        if(targetReached){
            String output = "";
            ArrayList<Double> copy = new ArrayList<>(targetPermutation);
            ArrayList<BinaryOperation> operations = targetOperations;
            ArrayList<Integer> order =  orderOfOperations;
            int i = 0;
            for(int j: order){
                //int first = order.get(i) -1;
                //System.out.println(first);
                //int second = order.get(i+1) -1;
                //System.out.println(copy);
                output = output + copy.get(j-1) + " " + operations.get(i).toString() + " " + copy.get(j);
                copy = operations.get(i).calculateAtIndex(copy,j-1);
                i++;
                output = output + " " + "=" + " " + copy.get(j-1) + "\n";
                if(copy.get(j-1)==target){
                    break;
                }
            }
            System.out.println(output);
        }else{
            System.out.println("No solution");
        }
    }

    public void calculateEveryForPermutation(){
        for(ArrayList<Double> perm : obj.permutations){
            calculateEvery(perm);
            if(targetReached){
                return;
            }
        }
    }

    public void calculateEvery(ArrayList<Double> array){
        for(ArrayList<BinaryOperation> operations: obj.opCombs){
            calculateAll(array, operations);
            if(targetReached){
                return;
            }
        }
    }

    public void calculateAll(ArrayList<Double> array, ArrayList<BinaryOperation> operations){
        ArrayList<BinaryOperation> copy = new ArrayList<>(operations);

        ArrayList<Double> temp = new ArrayList<>(array);


        int i = 0;

        for(ArrayList<Integer> order: obj.factorialCombs){

            for(int j : order){


                temp = operations.get(i).calculateAtIndex(temp,j-1);

                i++;

                if(temp.contains(target) ){
                    targetReached = true;
                    targetOperations = operations;
                    orderOfOperations = order;
                    targetPermutation = array;
                    return;
                }

            }
            i=0;

//            results.add(temp.get(0));
//            if(temp.get(0) == target){
//                targetReached = true;
//                targetOperations = operations;
//                orderOfOperations = order;
//                targetPermutation = array;
//                return;
//            }
            temp = new ArrayList<>(array);
        }

        }




    public int indexOfNthOccurrence(String string, String regex, int n){
        if(n> string.length()){
            return -1;
        }
        int tempIndex = -1;
        for(int i = 0; i < n ; i++ ){
            tempIndex = string.indexOf(regex, tempIndex + 1 );
        }
        return tempIndex;
    }

    public String replaceCharAtIndexWithString(String string, String replacement, int index){
        return string.substring(0,index) + replacement + string.substring(index+1);
    }

    public boolean checkBinaryBrackets(String s){
        if(!checkBalancedBrackets(s)){
            return false;
        }
        String temp = s;

        while(temp != temp.replaceAll("\\(..\\)","x") ){
            temp = temp.replaceAll("\\(..\\)","x");
        }

        return temp.equals("x") || temp.equals("xx");
    }

    public ArrayList<String> generateAllBinaryBrackets(){
        ArrayList<String> binaryBrackets = new ArrayList<String>();
        return null;
    }

    public ArrayList<String>  generateAllPossibleReplacements(String string, String orig, String regex){
        int n=1;
        ArrayList<String> replacements = new ArrayList<String>();
        int index;
        while( (index = indexOfNthOccurrence(string, orig,n++)) != -1){
            replacements.add(replaceCharAtIndexWithString(string,regex,index));

        }
        return replacements;
    }

    public ArrayList<String> generateAllPossibleReplacements(ArrayList<String> strings, String orig, String regex){
        ArrayList<String> replacements = new ArrayList<String>();
        for(String s : strings){
            replacements.addAll(generateAllPossibleReplacements(s, orig, regex));
        }
        return replacements;
    }

    public ArrayList<String> removeDuplicates(ArrayList<String> list)
    {

        // Create a new LinkedHashSet
        Set<String> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(list);

        // Clear the list
        list.clear();

        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);

        // return the list
        return list;
    }



    public ArrayList<String> generateAllBinaryBrackets(int length){
        if(length<=2){
            return null;
        }
        String s = "xx";
        ArrayList<String> list;
        list = generateAllPossibleReplacements(s,"x","(xx)");
        list = removeDuplicates(list);
        for(int i = 3; i < length; i++){

            list = generateAllPossibleReplacements(list,"x","(xx)");
            list = removeDuplicates(list);
        }

        return list;
    }

    public boolean checkBalancedBrackets(String s){
        Stack a = new Stack();
        char top;
        for(int i =0; i < s.length(); i++){

            if(s.charAt(i) == '('){
                a.push('(');
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
