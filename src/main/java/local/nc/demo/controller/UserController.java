/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.nc.demo.controller;

import java.security.Principal;
import local.nc.demo.model.UserDtls;
import local.nc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jose
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepo;
    
    @ModelAttribute
    private void userDetails(Model m, Principal p){
        String email = p.getName();
        UserDtls user = userRepo.findByEmail(email);
        
        m.addAttribute("user", user);
    }
    
    @GetMapping("/")
    public String home(){
        return "user/home";
    }
}
