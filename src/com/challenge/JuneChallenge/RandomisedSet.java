package com.challenge.JuneChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Maintain an arrayList and a hashMap.
 * 1. Insert: get arrlist size and add val to it and put val as key and size as index in haashMap
 * 2. Delete: swap last and val in array. remove arr[size-1] and remove from hashMap and update last's index
 */
public class RandomisedSet {
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> hash;
    /** Initialize your data structure here. */
    public RandomisedSet() {
        arr = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hash.containsKey(val))
            return false;
           else {
               int arrSize = arr.size();
               arr.add(val);
               hash.put(val, arrSize);
               return true;
           }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hash.containsKey(val)) return false;
        else {
            int arrSize = arr.size();
            int lastVal = arr.get(arrSize -1);
            int valIndex = hash.get(val);
            if(lastVal!=val){
                Collections.swap(arr, valIndex,  arrSize -1); // swap last index with index to remove
                hash.put(lastVal, valIndex);// update the change in map
            }
            hash.remove(val);
            arr.remove(arrSize-1);

            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }

    public static void main(String[] args){
        //["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
        //[[],[0],[0],[0],[],[0],[0]]
        RandomisedSet obj = new RandomisedSet();
        obj.insert(1);
        obj.remove(2);
        obj.insert(2);
        System.out.println(obj.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

