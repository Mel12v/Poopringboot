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
    public void run(String... args)throws Exception{
        Book book1 = new Book("Los 4 chanchitos", "Coquito");
        book1.setTitle(book1.getTitle());
        book1.setEditorial(book1.getEditorial());

        Book book2 = new Book("Pinocho", "Coquito");
        book2.setTitle(book1.getTitle());
        book2.setEditorial(book1.getEditorial());

        Author author1 = new Author("Antonio", "Sucre");
        author1.getBookList().add(book1);
        author1.getBookList().add(book2);

        Book book3 = new Book("Los 3 mosqueteros", "Coquette");
        book3.setTitle(book3.getTitle());
        book3.setEditorial(book3.getEditorial());

        Book book4 = new Book("Barbie", "Mattel");
        book4.setTitle(book4.getTitle());
        book4.setEditorial(book4.getEditorial());

        Author author2 = new Author("Betty", "Maldonado");
        author2.getBookList().add(book3);
        author2.getBookList().add(book4);

        //Save objects in Entities
        bookRepository.save(book1);
        bookRepository.save(book2);
        authorRepository.save(author1);

        bookRepository.save(book3);
        bookRepository.save(book4);
        authorRepository.save(author2);

        System.out.println("-----------Started BookStrapData---------");
        System.out.println("number of Books:" + bookRepository.count());
        System.out.println("Number of Authors:" +authorRepository.count());

    }
}
