package com.hashtables;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "Dima");
//        map.put(2,"Liza");
//        map.put(2, "Veronika");
//        map.put(3, "Joshua");
//        map.put(null, null);
////        map.remove(null);
////        map.containsValue("Dima");
//        System.out.println(map.get(3));

        String sentence = "a green apple";
        CharFinder charFinder = new CharFinder();
        System.out.println(charFinder.findFirstNonRepeatingChar(sentence));
    }
}
