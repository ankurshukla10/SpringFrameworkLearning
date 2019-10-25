package guru.springframework.Spring5webapp.bootstrap;

import guru.springframework.Spring5webapp.model.Author;
import guru.springframework.Spring5webapp.model.Book;
import guru.springframework.Spring5webapp.model.Publisher;
import guru.springframework.Spring5webapp.repositories.AuthorRepository;
import guru.springframework.Spring5webapp.repositories.BookRepository;
import guru.springframework.Spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(final AuthorRepository authorRepository, final BookRepository bookRepository, final PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent)
    {
        initData();
    }

    private void initData()
    {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "123 St", "Downtown", "NY", 123434);
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harperCollins);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("Wrox", "123 St", "Downtown", "NY", 123434);

        Book noEJB = new Book("J2EE Development without EJB", "2344", wrox);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(wrox);
        bookRepository.save(noEJB);


    }

}
