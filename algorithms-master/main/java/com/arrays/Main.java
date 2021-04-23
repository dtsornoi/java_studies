package com.arrays;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);

//        array.reverse();

        array.insertAt(66,2);

        array.print();

//        int[] anotherArray = {10, 70, 30, 100, 90};
//        array.intersect(anotherArray);

//        array.removeAt(0);
//        array.print();
//        System.out.println(array.indexOf(20));
//        System.out.println(array.indexOf(100));
//        System.out.println(array.max());

    }
}
