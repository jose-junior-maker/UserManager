/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.nc.demo.service;

import local.nc.demo.model.UserDtls;

/**
 *
 * @author jose
 */
public interface UserService {
    
    public UserDtls createUser(UserDtls user);
    
    public boolean checkEmail(String email); 
    
}
