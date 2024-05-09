package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method
        return students.containsKey(studentId);
    }

    public void showSummary()
    {
        //TODO implement
        System.out.println("---Student Summary ---\n");

        for(String student : this.students.keySet()){
            if(isSubscribed(student)){
                System.out.println("Name : " + this.students.get(student).getName());
                System.out.println("DOB : " + this.students.get(student).getBirthDate());
                System.out.println("ID : " + this.students.get(student).getId());
                System.out.println("Email  : " + this.students.get(student).getEmail());
                System.out.println("Enrolled Courses : " + this.students.get(student).getApprovedCourses().size());

                for(Course course : this.students.get(student).getApprovedCourses()){
                    System.out.println(course.toString());
                }

                System.out.println("Passed Courses : " + this.students.get(student).passedCourses.size());

                for(Course course : this.students.get(student).passedCourses){
                    System.out.println(course.toString());
                }

                System.out.println("Average Credits : " + this.students.get(student).getAverage());
            }

            System.out.println("--------------------------------------");
            System.out.println();
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }


}
