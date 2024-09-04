package backendproject.projekti.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backendproject.projekti.domain.Book;
import backendproject.projekti.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;






@Controller

public class BookController {
        @Autowired
        private BookRepository repository;
    
    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    @GetMapping("/mainpage")
    public String ShowMeTheMainPage(Model model) {
        return "main";
    }
    
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
      @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book){
        repository.save(book);
        return "redirect:booklist";
    } 
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editBook", repository.findById(id));
        return "editBook";
    }
    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
}
