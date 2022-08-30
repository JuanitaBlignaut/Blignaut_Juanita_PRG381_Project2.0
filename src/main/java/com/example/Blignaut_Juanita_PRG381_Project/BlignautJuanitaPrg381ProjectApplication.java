package com.example.Blignaut_Juanita_PRG381_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Blignaut_Juanita_PRG381_Project.Phase2_Admin.Admin;
import com.example.Blignaut_Juanita_PRG381_Project.Phase2_Admin.AdminRepository;


@SpringBootApplication
public class BlignautJuanitaPrg381ProjectApplication implements CommandLineRunner {

	@Autowired AdminRepository adminRepo;
	public static void main(String[] args) {
		SpringApplication.run(BlignautJuanitaPrg381ProjectApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception{
		Admin admin = new Admin("Juanita", "Blignaut","juanitab21@icloud.com", "Admin_22");

		adminRepo.save(admin);
	}

}
