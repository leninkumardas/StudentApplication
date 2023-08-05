package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudentMarks(@PathVariable Long id,
                                                     @RequestBody Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            // Validate and update marks
            if (validateMarks(updatedStudent.getMarks1())
                    && validateMarks(updatedStudent.getMarks2())
                    && validateMarks(updatedStudent.getMarks3())) {
                student.setMarks1(updatedStudent.getMarks1());
                student.setMarks2(updatedStudent.getMarks2());
                student.setMarks3(updatedStudent.getMarks3());
                
             // Calculate Total, Average, and Result
                int total = student.getMarks1() + student.getMarks2() + student.getMarks3();
                double average = total / 3.0;
                String result = average >= 40 ? "Pass" : "Fail";

                student.setTotal(total);
                student.setAverage(average);
                student.setResult(result);

                studentRepository.save(student);

                return ResponseEntity.ok("Student marks updated successfully.");
            } else {
                return ResponseEntity.badRequest().body("Invalid marks. Marks should be between 0 and 100.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
 // Helper method to validate marks range
    private boolean validateMarks(Integer marks) {
        return marks >= 0 && marks <= 100;
    }
}
