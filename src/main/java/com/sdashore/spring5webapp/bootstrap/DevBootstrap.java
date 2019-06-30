package com.sdashore.spring5webapp.bootstrap;

import com.sdashore.spring5webapp.model.Author;
import com.sdashore.spring5webapp.model.Book;
import com.sdashore.spring5webapp.model.Publisher;
import com.sdashore.spring5webapp.model.repositories.AuthorRepository;
import com.sdashore.spring5webapp.model.repositories.BookRepository;
import com.sdashore.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setAddress("Dahntahn");

        publisherRepository.save(publisher);

        //Shapan
        Author shapan = new Author("Dashore", "Shapan");
        Book tdd = new Book("Test Driven Dev", "1234", publisher);
        shapan.getBooks().add(tdd);
        tdd.getAuthors().add(shapan);

        authorRepository.save(shapan);
        bookRepository.save(tdd);

        Publisher pub2 = new Publisher();
        publisher.setName("Charb Pubs");
        publisher.setAddress("hyland hills");

        publisherRepository.save(pub2);

        //Katie
        Author katie = new Author("Charb", "Katie");
        Book sw = new Book("Social Work","2345", pub2);
        katie.getBooks().add(sw);

        authorRepository.save(katie);
        bookRepository.save(sw);
    }


}
