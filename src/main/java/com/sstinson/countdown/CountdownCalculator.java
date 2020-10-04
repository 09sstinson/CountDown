package com.sstinson.countdown;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class CountdownCalculator {

    public Set<Double> results = new LinkedHashSet<>(20000);
    public CombinatoricsUtil obj = new CombinatoricsUtil();
    public double target = 50101.0;
    public boolean targetReached = false;
    public ArrayList<BinaryOperation> targetOperations;
    public ArrayList<Integer> orderOfOperations;
    public ArrayList<Double> targetPermutation;


//    public static void main(String[] args){
//        GUI countdownGUI = new GUI();
//    }

    public void printOutput(){
        if(targetReached){

            ArrayList<String> output = new ArrayList<>();
            ArrayList<Long> intermediateResults = new ArrayList<>();
            ArrayList<Double> copy = new ArrayList<>(targetPermutation);
            ArrayList<BinaryOperation> operations = targetOperations;
            ArrayList<Integer> order =  orderOfOperations;
            int i = 0;
            for(int j: order){
                long first = (long) copy.get(j-1).doubleValue();
                long second = (long) copy.get(j).doubleValue();

                String temp = first + " " + operations.get(i)+ " " + second;
                copy = operations.get(i).calculateAtIndex(copy,j-1);

                long result = (long) copy.get(j-1).doubleValue();
                temp =  temp + " " + "=" + " " + result;
                output.add(i,temp);
                 if(result != target) intermediateResults.add(result);
                i++;
                if(copy.get(j-1)==target){
                    break;
                }
            }

            for(int k =0; k < intermediateResults.size() ; k++){

                int count = 0;
                for(String s:output){

                    if(s.contains(intermediateResults.get(k).toString() + " ")){
                        count++;
                    }
                }
                if(count == 0){
                    output.remove(k);
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
