package com.ups.poo.domain;

import jakarta.persistence.*;
import com.ups.poo.domain.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String lastname;
    @OneToMany(mappedBy = "author")
    private List<Book> BookList = new ArrayList<Book>();

    public Author() {
    }

    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Author(String name, String lastname, List<Book> bookList) {
        this.name = name;
        this.lastname = lastname;
        BookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Book> getBookList() {
        return BookList;
    }

    public void setBookList(List<Book> bookList) {
        BookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(Id, author.Id) && Objects.equals(name, author.name) && Objects.equals(lastname, author.lastname) && Objects.equals(BookList, author.BookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

