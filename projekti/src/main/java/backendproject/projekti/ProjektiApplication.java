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
import backendproject.projekti.domain.AppUser;
import backendproject.projekti.domain.AppUserRepository;

@SpringBootApplication
public class ProjektiApplication {
	private static final Logger log = LoggerFactory.getLogger(ProjektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjektiApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookData(BookRepository bookRepository, CategoryRepository crepository, AppUserRepository urepository){
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

			bookRepository.save(new Book("Harry Potter", "J.K Rowling", 1995, 1690, 10, crepository.findByName("Fantasia").get(0)));
			bookRepository.save(new Book("Lord of the Rings", "J.R.R. Tolkien", 1500, 1700, 20000, crepository.findByName("Fantasia").get(0)));	
			bookRepository.save(new Book("Rimakauhua ja rakkautta", "Herran haltuun", 2000, 12546, 20, crepository.findByName("Komedia").get(0)));
			bookRepository.save(new Book("Tekoälyn perusteet", "en muista", 1996, 32566, 12, crepository.findByName("Draama").get(0)));
			
			AppUser user1 = new AppUser("jukka", "$2a$10$bqeWuUoDJkMs07mVq9sFtO7.4.pzT6MsfbT4iG/ZJvob669JU.H3u", "USER");
			AppUser user2 = new AppUser("jeremias", "$2a$10$Y.Pd7jlYfx.CXlBO9A9TPu.tJUMyfYyq8cj3irKYGFvqIk6Xt3fEu", "ADMIN");
			AppUser user3 = new AppUser("USER", "$2a$10$yorU92/JIj2bfxDJzcwK8uQV7F1asYwu6l4605vyu0f/8.CH9.5/W", "USER");
			AppUser user4 = new AppUser("ADMIN", "$2a$10$SZ/5p/0NykSduBUN8Krijeq.aWbTPSzwkorEvUHJEKDMxVqEuhXFi", "ADMIN");

			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			
			
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