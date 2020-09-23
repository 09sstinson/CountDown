package com.sstinson.countdown;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CombinatoricsUtil {

    public Set<ArrayList<Double>> permutations = new LinkedHashSet<>();
    public Set<ArrayList<Integer>> combinations = new LinkedHashSet<>();


    public ArrayList<Double> chosenNumbers = new ArrayList<Double>() {
        {
            add(100.0);
            add(75.0);
            add(2.0);
            add(5.0);
            add(7.0);
            add(9.0);
        }
    };

    public void generateCombinations(int n, int r){
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

    public ArrayList<Integer> resolveArray(ArrayList<Integer> array, int r){
        for(int i = array.size()-1; i >= 1; i--){
            if(array.get(i) == r + 1){
                array.set(i-1, array.get(i-1) + 1);
                array.set(i, 1);
                //System.out.println(array);
            }
        }
        return array;
    }

    public void heapPermutation(ArrayList<Double> elements, int size, int n ){

        if(size == 1){
            permutations.add(elements);

            System.out.println(elements);
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
