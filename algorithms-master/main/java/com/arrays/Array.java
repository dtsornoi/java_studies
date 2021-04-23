package com.arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public void print() {
//        for(int i = 0; i < count; i++){
//            System.out.println(items[i]);
//        }

        for (int item : items) {
            System.out.println(item);
        }
    }

    public int indexOf(int item) {
        //O(n)
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (items[i] < items[i + 1]) {
                max = items[i + 1];
            }
        }
        return max;
    }

    public void intersect(int[] arr) {
        System.out.println("Intersected numberes are: ");
        for (int i : items) {
            for (int j : arr) {
                if (i == j) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public void reverse() {
        int itemsArrayLength = items.length;
        int[] newArr = new int[itemsArrayLength];
        for (int i = 0; i < itemsArrayLength; i++) {
            newArr[itemsArrayLength - 1] = items[i];
            itemsArrayLength = itemsArrayLength - 1;
        }
        items = newArr;
    }

    public void insertAt(int item, int index) {

        int[] newArr = new int[items.length+1];
        int i;

        for (i = 0; i<items.length+1; i++){
            if (i < index){
                newArr[i] = items[i];
            }else if(i == index){
                newArr[i] = item;
            }else {
                newArr[i] = items[i-1];
            }
        }
        items = newArr;
    }
}
