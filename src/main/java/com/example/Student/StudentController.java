package com.example.Student;
import com.example.Student.Student;
import com.example.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
	 @Autowired
	    private StudentService studentService;

	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @GetMapping("/{id}")
	    public Student getStudentById(@PathVariable Long id) {
	        return studentService.getStudentById(id);
	    }

	    @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return studentService.saveStudent(student);
	    }

	    @PutMapping("/{id}")
	    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
	        Student existingStudent = studentService.getStudentById(id);
	        if (existingStudent != null) {
	            existingStudent.setFirstName(student.getFirstName());
	            existingStudent.setLastName(student.getLastName());
	            existingStudent.setEmail(student.getEmail());
	            existingStudent.setDateOfBirth(student.getDateOfBirth());
	            existingStudent.setDepartment(student.getDepartment());
	            return studentService.saveStudent(existingStudent);
	        }
	        return null;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteStudent(@PathVariable Long id) {
	        studentService.deleteStudent(id);
	    }
}
