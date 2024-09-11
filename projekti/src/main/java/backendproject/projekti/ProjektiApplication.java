package backendproject.projekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import backendproject.projekti.domain.Book;
import backendproject.projekti.domain.BookRepository;
import backendproject.projekti.domain.Category;
import backendproject.projekti.domain.CategoryRepository;

@SpringBootApplication
public class ProjektiApplication {
	private static final Logger log = LoggerFactory.getLogger(ProjektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjektiApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookData(BookRepository bookRepository, CategoryRepository crepository){
		return(args) -> {
			log.info("save a couple of students");
			log.info("Save couple categories");
			Category category1 = new Category("Fantasia");
			Category category2 = new Category("Komedia");
			Category category3 = new Category("Draama");
			Category category4 = new Category("Tieteis");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);
			crepository.save(category4);

			bookRepository.save(new Book("Harry Potter", "J.K Rowling", 1995, 1690, 10));
			bookRepository.save(new Book("Lord of the Rings", "J.R.R. Tolkien", 1500, 1700, 20000));	
			bookRepository.save(new Book("Rimakauhua ja rakkautta", "Herran haltuun", 2000, 12546, 20));
			bookRepository.save(new Book("Tekoälyn perusteet", "en muista", 1996, 32566, 12));
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
		}
	};
	/*public CommandLineRunner categoryData(CategoryRepository CategoryRepository){
		return (args) ->{
			log.info("Save couple categories");
			Category category1 = new Category("Fantasia");
			Category category2 = new Category("Komedia");
			Category category3 = new Category("Draama");
			Category category4 = new Category("Tieteis");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);
			crepository.save(category4);

			bookRepository.save(new Book("Uskomatonta mutta totta", "jeremias", 1243, 43546, 45, category1));
			bookRepository.save(new Book("halusin tai en", "jeremias", 1243, 43546, 45, category2));
			bookRepository.save(new Book("Voiko olla näin", "jeremias", 1243, 43546, 45, category3));
			bookRepository.save(new Book("Mutta missä", "jeremias", 1243, 43546, 45, category1));
			
			log.info("hae kirjat");
			for(Book book : crepository.findAll()){
				log.info(book.toString());
			}

		}
	};*/

}
}