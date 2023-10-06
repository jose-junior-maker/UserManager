/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.nc.demo.controller;

import javax.servlet.http.HttpSession;
import local.nc.demo.model.UserDtls;
import local.nc.demo.repository.UserRepository;
import local.nc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jose
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserDtls user, HttpSession session) {

        //System.out.println(user);
        boolean f = userService.checkEmail(user.getEmail());
        if (f) {
            session.setAttribute("msg", "Email Id already exists");
        } else {
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg", "Register Sucessfully");
            } else {
                session.setAttribute("msg", "Something wrong on server");
            }
        }

        return "redirect:/register";
    }
    
    @GetMapping("/loadForgotPassword")
    public String loadForgotPassword(){
        return "forgot_password";
    }
    
    @GetMapping("/loadResetPassword/{id}")
    public String loadResetPassword(@PathVariable int id, Model m){
        m.addAttribute("id", id);
        return "reset_password";
    }
    
    @PostMapping("/forgotPassword")
    public String forgotPassword(@RequestParam String email, @RequestParam String mobileNumber, HttpSession session){
        
        UserDtls user = userRepo.findByEmailAndMobileNumber(email, mobileNumber);
        
        if (user!=null){
            return "redirect:/loadResetPassword/" + user.getId();
        }else{
            session.setAttribute("msg", "Invalid email & mobile number");
            return "forgot_password";
        }
    }
    
    @PostMapping("/changePassword")
    public String resetPassword(@RequestParam String psw, @RequestParam Integer id, HttpSession session){
        
        UserDtls user = userRepo.findById(id).get();
        String encryptPsw = passwordEncoder.encode(psw);
        user.setSenha(encryptPsw);
        
        UserDtls updateUser = userRepo.save(user);
        
        if(updateUser != null){
            session.setAttribute("msg", "Password Change Succesfully");
        }
        
        return "redirect:/loadForgotPassword";
    }
}
