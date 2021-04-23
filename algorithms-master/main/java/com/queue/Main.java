package com.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);

//        ArrayQueue arrayQueue = new ArrayQueue(5);
//        arrayQueue.enqueue(10);
//        arrayQueue.enqueue(20);
//        arrayQueue.enqueue(30);
//        System.out.println(arrayQueue.toString());


    }


    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }

}
