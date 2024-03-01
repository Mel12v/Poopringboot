package com.ups.poo.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String editorial;
    private String publisher;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)

    private Author author;

    public Book() {
    }

    public Book(String title, String editorial, String publisher) {
        this.title = title;
        this.editorial = editorial;
        this.publisher = publisher;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Author getAuthors() {
        return author;
    }

    public void setAuthors(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(Id, book.Id) && Objects.equals(title, book.title) && Objects.equals(editorial, book.editorial) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}
