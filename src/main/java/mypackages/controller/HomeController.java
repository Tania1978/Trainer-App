
package mypackages.controller;


import mypackages.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private HomeService hservice;
    
    @RequestMapping("/")
    public String showHome(Model model){
        String message = hservice.showWelcomeMessage();
        model.addAttribute("message" , message);
        return "home";
    }
    
}
