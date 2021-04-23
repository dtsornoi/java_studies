package com.homework.generics.task1;

import java.util.Arrays;
import java.util.function.Predicate;

//Task 1
public class Pair <T, S>{
    private T first;
    private S second;

    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    //task2
    public <T> long countIf(T[] array, Predicate<T> predicate){
        return Arrays.stream(array)
                .filter(predicate)
                .count();
    }

    //Task 3
    public <T> void swap(T[] array, int index, int newValue){
        var temp = array[index];
        array[index] = array[newValue];
        array[newValue] = temp;
    }

}
