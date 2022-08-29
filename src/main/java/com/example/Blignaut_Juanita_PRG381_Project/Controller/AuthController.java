package com.example.Blignaut_Juanita_PRG381_Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Blignaut_Juanita_PRG381_Project.Student.Student;
import com.example.Blignaut_Juanita_PRG381_Project.Student.StudentRepository;

@Controller
public class AuthController {
    
    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/index")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @GetMapping("/adminlogin")
    public String showAdminLogin(){
        return "adminlogin";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
         
        return "register";
    }

    @PostMapping("/register/save")
    public String processRegister(Student student) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        
        studentRepo.save(student);
        
        return "register_success";
    }

    @GetMapping("/students")
    public String listStudents(Model mod){
        List<Student> listStudents = studentRepo.findAll();
        mod.addAttribute("listStudents", listStudents);

        return "students";
        
    }

    @GetMapping("/adminstudents")
    public String listStudent(Model mod){
        List<Student> listStudents = studentRepo.findAll();
        mod.addAttribute("listStudent", listStudents);

        return "students";
        
    }
}
