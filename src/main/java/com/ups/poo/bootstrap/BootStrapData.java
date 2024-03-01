package com.ups.poo.bootstrap;

import com.ups.poo.domain.Author;
import com.ups.poo.domain.Book;
import com.ups.poo.repository.AuthorRepository;
import com.ups.poo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book();
        book1.setTitle ("Los 3 Mosquetores");
        book1.setEditorial("Pearson");
        book1.setPublisher("BM");
        bookRepository.save(book1);


        Book book2 = new Book();
        book2.setTitle ("Conde de Montecristo");
        book2.setEditorial("Pearson");
        book2.setPublisher("MV");
        bookRepository.save(book2);

        Author author1 = new Author("Alejandro", "Dunas");
        author1.getBookList().add(book1);
        author1. getBookList().add(book2);
        book1.setAuthor(author1);
        book2.setAuthor(author1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        bookRepository.save(book2);


        Book book3 = new Book();
        book3.setTitle("Buscando a Alaska");
        book3.setEditorial("E. P. Dutto");
        book3.setPublisher("MN");
        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setTitle("Bajo la misma estrella");
        book4.setEditorial("Dutton Books");
        book4.setPublisher("MBM");
        bookRepository.save(book4);

        Author author2 = new Author("John", "Green");
        author2.getBookList().add(book3);
        author2.getBookList().add(book4);
        book3.setAuthor(author2);
        book4.setAuthor(author2);
        book3.setAuthor(author2);
        book4.setAuthor(author2);
        authorRepository.save(author2);
        bookRepository.save(book3);
        bookRepository.save(book4);


        System.out.println("---------------------Started BootStrapData-----------");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());






    }
}
