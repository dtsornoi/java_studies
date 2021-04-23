package com.stack;

public class Main {
    public static void main(String[] args) {
        StringReverser stringReverser = new StringReverser();
        var result = stringReverser.reverse("abcd");

        System.out.println(result);
    }
}
