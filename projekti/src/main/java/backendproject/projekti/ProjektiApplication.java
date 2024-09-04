package backendproject.projekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import backendproject.projekti.domain.Book;
import backendproject.projekti.domain.BookRepository;

@SpringBootApplication
public class ProjektiApplication {
	private static final Logger log = LoggerFactory.getLogger(ProjektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjektiApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookData(BookRepository bookRepository){
		return(args) -> {
			log.info("save a couple of students");
			bookRepository.save(new Book("Harry Potter", "J.K Rowling", 1995, 1690, 10));
			bookRepository.save(new Book("Lord of the Rings", "J.R.R. Tolkien", 1500, 1700, 20000));	
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
		}
	};

}
}