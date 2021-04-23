package com.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Balancer {
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');

    public boolean isBalance(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : input.toCharArray()) {
            if (isLeftBracket(c)) {
                stack.push(c);
            }

            if (isRightBracket(c)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (bracketsMatch(top, c)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isRightBracket(char c) {
        return rightBrackets.contains(c);
    }

    private boolean isLeftBracket(char c) {
        return leftBrackets.contains(c);
    }

    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
