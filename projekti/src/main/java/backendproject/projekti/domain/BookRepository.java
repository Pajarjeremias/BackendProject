package backendproject.projekti.domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
List<Book> findByTitle(@Param("title") String title);
List<Book> findByAuthor(@Param("author") String author);
List<Book> findByPublicationYear(@Param("publicationYear") Long publicationYear);
List<Book> findByIsbn(@Param("isbn") Long isbn);
List<Book> findByPrice(@Param("price") Long price);
}
