package com.example.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.domain.Author;
import com.example.domain.Book;
import com.example.domain.Publisher;
import com.example.repositories.AuthorRepository;
import com.example.repositories.BookRepository;
import com.example.repositories.PublisherRepository;

/**
 * 
 * @author dcividin
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	/**
	 * 
	 * @param authorRepository
	 * @param bookRepository
	 * @param publisherRepository
	 */
	public BootStrapData(AuthorRepository authorRepository, 
			BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author evans = new Author("Eric", "Evans");
		Author oBrian = new Author("Patrick", "O'Brian");
		Author fowler = new Author("Martin", "Fowler");
		Author beck = new Author("Kent", "Beck");
		Book aor = new Book("The Art of Refactoring", "8850334834");
		Book patterns = new Book("Implementation Patterns", "0321413091");
		Book primoComando = new Book("Primo comando. Le avventure di Aubrey e Maturin", "885024925X");
		Book ddd = new Book("Domain-Driven Design", "B00794TAUG");
		Publisher wesley = new Publisher("Addison-Wesley Professional", "Boston", "USA");
		Publisher mondadory = new Publisher("Mondadory", "Ostiglia", "Italy");
		
		publisherRepository.save(wesley);
		publisherRepository.save(mondadory);
		
		ddd.setPublisher(wesley);
		ddd.getAuthors().add(evans);
		evans.getBooks().add(ddd);
		
		primoComando.setPublisher(mondadory);
		primoComando.getAuthors().add(oBrian);
		oBrian.getBooks().add(primoComando);
		
		patterns.setPublisher(wesley);
		patterns.getAuthors().add(beck);
		beck.getBooks().add(patterns);
		
		aor.setPublisher(wesley);
		aor.getAuthors().add(fowler);
		aor.getAuthors().add(beck);
		fowler.getBooks().add(aor);
		beck.getBooks().add(aor);
		
		authorRepository.save(evans);
		bookRepository.save(ddd);
		
		authorRepository.save(oBrian);
		bookRepository.save(primoComando);
		
		authorRepository.save(beck);
		authorRepository.save(fowler);
		bookRepository.save(patterns);
		bookRepository.save(aor);
		
		wesley.getBooks().add(patterns);
		wesley.getBooks().add(aor);
		wesley.getBooks().add(ddd);
		
		mondadory.getBooks().add(primoComando);
		
		System.out.println("Started in BootStrap");
		System.out.println("Number of Authors: "+authorRepository.count());
		System.out.println("Number of Books: "+bookRepository.count());
		System.out.println("Number of Publishers: "+publisherRepository.count());
	}

}
