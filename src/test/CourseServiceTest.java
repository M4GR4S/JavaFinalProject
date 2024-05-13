package test;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.service.CourseService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {

    @Test
    public void testRegisterCourse() {
        CourseService courseService = new CourseService();

        // Create a new course
        Module newModule = new Module("TEST-MODULE", "Test Module", "This is a test module");
        Course newCourse = new Course("TEST-COURSE", "Test Course", 10, newModule);

        // Register the new course
        courseService.registerCourse(newCourse);

        // Assert that the course is registered
        Course retrievedCourse = courseService.getCourse("TEST-COURSE");
        assertNotNull(retrievedCourse);
        assertEquals(newCourse, retrievedCourse);
    }

    @Test
    public void testGetCourse_ExistingCourse() {
        CourseService courseService = new CourseService();

        // Get an existing course by code
        String existingCourseCode = "INTRO-CS-1";
        Course retrievedCourse = courseService.getCourse(existingCourseCode);

        // Assert that the retrieved course is not null and has the expected code
        assertNotNull(retrievedCourse);
        assertEquals(existingCourseCode, retrievedCourse.getCode());
    }

    @Test
    public void testGetCourse_NonexistentCourse() {
        CourseService courseService = new CourseService();

        // Get a non-existent course by code
        String nonExistentCourseCode = "NON-EXISTENT-COURSE";
        Course retrievedCourse = courseService.getCourse(nonExistentCourseCode);

        // Assert that the retrieved course is null
        assertNull(retrievedCourse);
    }
}
