package com.example.Blignaut_Juanita_PRG381_Project.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    
    @Query("SELECT u FROM Admin u WHERE u.email = ?1")
    public Admin findByEmail(String email);
}
