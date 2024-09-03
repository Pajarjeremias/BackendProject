package backendproject.projekti.web;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller

public class BookController {
    
    @RequestMapping("/index")
    public String showMainPage(){
        return "index";
    }
}
