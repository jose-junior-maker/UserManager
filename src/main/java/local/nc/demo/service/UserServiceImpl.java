/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.nc.demo.service;

import local.nc.demo.model.UserDtls;
import local.nc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public UserDtls createUser(UserDtls user) {
        
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        user.setRole("ROLE_USER");
        
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        
        return userRepo.existsByEmail(email);
    }
    
}
