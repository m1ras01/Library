package kz.miras.spring.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min=3,max=20,message ="Name should be between 3 and 20 characters")
    private String Book;

    @Min(value = 0,message = "Age should be greater than 0")
    private int year;
    @NotEmpty(message = "Email should be not empty")
//    @Email(message = "Email should be valid")
    private String author;

    public Book(){}
    public Book(int id , String Book,int year,String author){
        this.id = id;
        this.Book = Book;
        this.year = year;
        this.author = author;
    }
    public void setBook(String Book) {
        this.Book = Book;
    }

    public String getBook() {
        return Book;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getYear(){return year;}
    public void setYear(int year){this.year = year;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;    }
}

