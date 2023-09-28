/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.nc.demo.repository;

import local.nc.demo.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jose
 */
public interface UserRepository extends JpaRepository<UserDtls, Integer> {
    
    public boolean existsByEmail(String email);
    
    public UserDtls findByEmail(String email); 
    
}
