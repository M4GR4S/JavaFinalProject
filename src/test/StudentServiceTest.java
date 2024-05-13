package test;

import com.generation.model.Student;
import com.generation.service.StudentService;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testSubscribeStudent() {
        StudentService studentService = new StudentService();

        // Create a new student with a birthdate
        String studentId = "S12345";
        String studentName = "John Doe";
        String studentEmail = "john.doe@example.com";
        Date birthDate = new Date(1990, 02, 10);
        Student newStudent = new Student(studentId, studentName, studentEmail, birthDate);

        // Subscribe the student
        studentService.subscribeStudent(newStudent);

        // Find the student by ID
        Student retrievedStudent = studentService.findStudent(studentId);

        // Assert that the retrieved student is not null and has the expected attributes
        assertNotNull(retrievedStudent);
        assertEquals(studentId, retrievedStudent.getId());
        assertEquals(studentName, retrievedStudent.getName());
        assertEquals(studentEmail, retrievedStudent.getEmail());
    }


    @Test
    public void testFindStudent_ExistingStudent() {
        StudentService studentService = new StudentService();

        // Student is already subscribed
        String existingStudentId = "12345";

        // Find the student by ID
        Student retrievedStudent = studentService.findStudent(existingStudentId);
    }

    @Test
    public void testFindStudent_NonexistentStudent() {
        StudentService studentService = new StudentService();

        // Find a non-existent student by ID
        String nonExistentStudentId = "99999";

        // Find the student by ID
        Student retrievedStudent = studentService.findStudent(nonExistentStudentId);
    }
}