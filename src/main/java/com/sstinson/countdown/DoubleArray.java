package com.sstinson.countdown;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class DoubleArray {

    public Set<ArrayList<Double>> permutations = new LinkedHashSet<>();;

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

    public ArrayList<Double> heapPermutation(ArrayList<Double> elements, int size, int n ){

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

        return null;
    }
}
