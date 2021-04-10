package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher("Ramu","Splitsvilla","Mumbai","Maharashtra",600000);
        publisherRepository.save(publisher1);
        Author author1 = new Author("Chetan","Bhagat");
        Book book1 = new Book("Half Girlfriend","10001010");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisher1.getBooks().add(book1);
        publisherRepository.save(publisher1);

        Author author2 = new Author("Amish","Pandey");
        Book book2 = new Book("Oath of Vayuputhras","20001010");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        publisher1.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());


    }
}
