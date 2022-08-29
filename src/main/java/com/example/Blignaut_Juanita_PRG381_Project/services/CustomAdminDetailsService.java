package com.example.Blignaut_Juanita_PRG381_Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Blignaut_Juanita_PRG381_Project.Admin.Admin;
import com.example.Blignaut_Juanita_PRG381_Project.Admin.AdminRepository;

public class CustomAdminDetailsService implements UserDetailsService{
    @Autowired
    private AdminRepository adminRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin= adminRepo.findByEmail(username);
        if (admin == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomAdminDetails(admin);
    }
}
