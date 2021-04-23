package com.homework.generics.task1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var books = List.of("Batman", "Robin", "Superman");
        var magazines = List.of("Cosmopolitan", "playboy");
        var movies = List.of("Superman vs Batman", "Iron Man", "Man of Steel");

        Library <String, String, String> library = new Library<>(books, magazines, movies);

        library.listOfBooks();
        System.out.println("===============================");
        library.listOfNewsPapers();
        System.out.println("===============================");
        library.listOfMovies();
    }
}
