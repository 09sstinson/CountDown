package com.sstinson.countdown;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class CombinatoricsUtil {

    public ArrayList<ArrayList<Double>> permutations = new ArrayList<>(720);
    public ArrayList<ArrayList<Integer>> combinations = new ArrayList<>(1024);
    public ArrayList<ArrayList<BinaryOperation>> opCombs = new ArrayList<>(1024);
    public ArrayList<ArrayList<Integer>> factorialCombs;

    public CombinatoricsUtil(){
        generateCombinations(5,4);

        parseOperations(combinations);
        factorialCombs = generateFactorialCombinations(5);
        heapPermutation(chosenNumbers,chosenNumbers.size(),chosenNumbers.size());
        permutations.add(chosenNumbers);

    }

    public ArrayList<Double> chosenNumbers = new ArrayList<Double>() {
        {
            add(9.0);
            add(4.0);
            add(10.0);
            add( 6.0);
            add(75.0);
            add(100.0);
        }
    };

    public void parseOperations(ArrayList<ArrayList<Integer>> combinations){

        for(ArrayList<Integer> array: combinations){
            ArrayList<BinaryOperation> newArray = new ArrayList<>();
            for(int i: array ){
                switch(i){
                    case 1:
                        newArray.add(new Add());
                        break;
                    case 2:
                        newArray.add(new Subtract());
                        break;
                    case 3:
                        newArray.add(new Multiply());
                        break;
                    case 4:
                        newArray.add(new Divide());
                        break;
                }
            }
            opCombs.add(newArray);
        }
    }



    public ArrayList<ArrayList<Integer>> generateFactorialCombinations(int n){
        ArrayList<ArrayList<Integer>> factorialCombs= new ArrayList<>(1000);

        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i<n ; i++){
            array.add(1);
        }

        while(array.get(0) != n + 1 ) {

            factorialCombs.add(new ArrayList<>(array));
            array.set(n - 1, array.get(n - 1) + 1);
            array = resolveArrayFactorial(array,n);

        }
        return factorialCombs;
    }

    private void generateCombinations(int n, int r){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i<n ; i++){
            array.add(1);
        }

        while(array.get(0) != r + 1 ) {

            combinations.add(new ArrayList<>(array));
            array.set(n - 1, array.get(n - 1) + 1);
            array = resolveArray(array,r);

        }
    }

    private ArrayList<Integer> resolveArray(ArrayList<Integer> array, int r){
        for(int i = array.size()-1; i >= 1; i--){
            if(array.get(i) == r + 1){
                array.set(i-1, array.get(i-1) + 1);
                array.set(i, 1);
                //System.out.println(array);
            }
        }
        return array;
    }

    private ArrayList<Integer> resolveArrayFactorial(ArrayList<Integer> array, int n){
        for(int i = array.size()-1; i >= 1; i--){
            if(array.get(i) == n +1 - i){
                array.set(i-1, array.get(i-1) + 1);
                array.set(i, 1);
                //System.out.println(array);
            }
        }
        return array;
    }

    private void generatePermutations(ArrayList<Double> array){
        ArrayList<ArrayList<Integer>> perms = generateFactorialCombinations(6);
        ArrayList<Double> copy = new ArrayList<>(chosenNumbers);
        for(ArrayList<Integer> perm: perms){

        }
    }


    private void heapPermutation(ArrayList<Double> elements, int size, int n ){

        if(size == 1){
            permutations.add(elements);
        }

        for(int i=0; i<size; i++){
            heapPermutation(elements, size-1,n);
            if(size % 2 == 1){
                double temp = elements.get(0);
                elements.set(0,elements.get(size-1));
                elements.set(size-1, temp);
            }

            else{
                double temp = elements.get(i);
                elements.set(i,elements.get(size-1));
                elements.set(size-1, temp);
            }
        }

    }
}
