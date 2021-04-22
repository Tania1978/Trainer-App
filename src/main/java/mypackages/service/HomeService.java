/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    
    public String showWelcomeMessage(){
        
        String msg = "Welcome to our WebApp! ";
        return msg;
    }
    
}
