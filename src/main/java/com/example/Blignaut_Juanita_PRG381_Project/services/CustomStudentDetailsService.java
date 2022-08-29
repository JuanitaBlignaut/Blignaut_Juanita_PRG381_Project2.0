package com.example.Blignaut_Juanita_PRG381_Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Blignaut_Juanita_PRG381_Project.Student;
import com.example.Blignaut_Juanita_PRG381_Project.StudentRepository;

public class CustomStudentDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student= studentRepo.findByEmail(username);
        if (student == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomStudentDetails(student);
    }
}
