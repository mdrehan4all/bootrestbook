package com.test.bootrestbook.services;

import com.test.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(1, "ABC", "ABC"));
        list.add(new Book(2, "DEF", "ABC"));
        list.add(new Book(3, "XYZ", "ABC"));
    }

    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBookById(int id){
        Book book = null;
        book = list.stream().filter(e->e.getId() == id).findFirst().get();
        return book;
    }

    public void addBook(Book b){
        list.add(b);
    }
}
