package backendproject.projekti.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backendproject.projekti.domain.CategoryRepository;
import backendproject.projekti.domain.Book;
import backendproject.projekti.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import backendproject.projekti.domain.CategoryRepository;
import backendproject.projekti.domain.Book;
import backendproject.projekti.domain.BookRepository;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/


@Controller

public class BookController {
        @Autowired
        private BookRepository repository;
        @Autowired
        private CategoryRepository crepository;


    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    @GetMapping("/mainpage")
    public String ShowMeTheMainPage(Model model) {
        return "main";
    }
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }
    @RequestMapping(value="book/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }
    
    
    
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
      @RequestMapping(value ="/savebook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book){
        repository.save(book);
        return "redirect:booklist";
    } 
   
    @GetMapping("/editBook/{id}")
    @PreAuthorize("hasAuthority('ADMIN')") 
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editBook", repository.findById(id));
        model.addAttribute("categories", crepository.findAll());
        return "editBook";
    }
    
    @PostMapping("/saveEditedBook")
    /*@PreAuthorize("hasAuthority('ADMIN')")*/
    public String saveEditedBook(Book book) {
        /*log.info("CONTROLLER: Save edited book: " + book);*/
        repository.save(book);
        return "redirect:/booklist";
    }
    
    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
}
