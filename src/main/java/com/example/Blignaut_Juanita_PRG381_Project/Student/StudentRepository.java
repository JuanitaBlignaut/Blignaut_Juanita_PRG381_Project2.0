package com.example.Blignaut_Juanita_PRG381_Project.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
    @Query("SELECT u FROM Student u WHERE u.email = ?1")
    public Student findByEmail(String email);
    
}
