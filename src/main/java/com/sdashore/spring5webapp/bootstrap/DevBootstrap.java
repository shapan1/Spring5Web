package com.sdashore.spring5webapp.bootstrap;

import com.sdashore.spring5webapp.model.Author;
import com.sdashore.spring5webapp.model.Book;
import com.sdashore.spring5webapp.model.repositories.AuthorRepository;
import com.sdashore.spring5webapp.model.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Shapan
        Author shapan = new Author("Dashore", "Shapan");
        Book tdd = new Book("Test Driven Dev", "1234", "Penguin");
        shapan.getBooks().add(tdd);
        tdd.getAuthors().add(shapan);

        authorRepository.save(shapan);
        bookRepository.save(tdd);

        //Katie
        Author katie = new Author("Charb", "Katie");
        Book sw = new Book("Social Work","2345", "Charb Pubs");
        katie.getBooks().add(sw);

        authorRepository.save(katie);
        bookRepository.save(sw);
    }


}
