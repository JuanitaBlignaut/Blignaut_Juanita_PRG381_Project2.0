package com.example.Blignaut_Juanita_PRG381_Project;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.Blignaut_Juanita_PRG381_Project.Student.Student;
import com.example.Blignaut_Juanita_PRG381_Project.Student.StudentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudentRepositoryTest {
    
    @Autowired
    private StudentRepository repo;

    @Autowired TestEntityManager entityManager;

    @Test
    public void testCreateStudent(){
        Student student = new Student();
        student.setFirstname("Juanita");
        student.setLastname("Blignaut");
        student.setEmail("juanitab20@icloud.com");
        student.setPassword("JB_2022");

        Student savedRepo =  repo.save(student);

        Student existStudent = entityManager.find(Student.class, savedRepo.getId());

        assertThat(existStudent.getEmail()).isEqualTo(student.getEmail());
    }
}
