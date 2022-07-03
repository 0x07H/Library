package gr.upatras.Library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		log.info("Get all students");
		return studentService.getAllStudents();
	}
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
		return student;
	}
}
