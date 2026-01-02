package com.test.bootrestbook.services;

import com.test.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        }catch(Exception e){

        }
        return book;
    }

    public void addBook(Book b){
        list.add(b);
    }

    public List<Book> deleteBook(int id){
        list = list.stream().filter(book->book.id != id).collect(Collectors.toList());
        return list;
    }

    public void updateBook(Book book, int id){
        list = list.stream().map(b->{
            if(b.getId() == id){
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
