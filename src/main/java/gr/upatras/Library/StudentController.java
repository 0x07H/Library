package gr.upatras.Library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public void createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@RequestBody int id){
		log.info("Delete student by ID students");
		studentService.deleteStudent(id);
	}
	
	@PatchMapping("/updateStudentFirst/{id}/{first}/")
	public void updateFirstName(@PathVariable  int id, @PathVariable String first) {
		log.info("Update Firstname of student by ID students");
		studentService.updateStudentFirstName(id, first);
	}
	
	@PatchMapping("/updateStudentFirst/{id}/{last}/")
	public void updateLastName(@PathVariable  int id, @PathVariable String last) {
		log.info("Update Lastname of student by ID students");
		studentService.updateStudentFirstName(id, last);
	}
	
	@PatchMapping("/updateStudentAllowance/{id}/{allowance}")
	public void updateAllowance(@PathVariable  int id, @PathVariable int allowance) {
		log.info("Update Lastname of student by ID students");
		studentService.updateStudentAllowance(id, allowance);
	}
}
