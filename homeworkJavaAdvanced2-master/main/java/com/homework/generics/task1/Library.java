package com.homework.generics.task1;

import java.util.List;

public class Library<T, S, U> {
    private List<T> books;
    private List<S> newspapers;
    private List<U> movies;

    public Library(List<T> books, List<S> newspapers, List<U> movies) {
        this.books = books;
        this.newspapers = newspapers;
        this.movies = movies;
    }

    public void listOfMovies(){
        iterationOfItems(movies);
    }


    public void listOfBooks(){
        iterationOfItems(books);
    }

    public void listOfNewsPapers(){
        iterationOfItems(newspapers);
    }

    private <E> void iterationOfItems(List<E> items) {
        for (E item : items){
            System.out.println(item);
        }
    }
}
