package gr.upatras.Library;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class StudentService {

	 @Autowired
	 private StudentRepository studentrepository;
	 
	 public List<Student> getAllStudents(){
		 List<Student> students =  new ArrayList<>();
		 studentrepository.findAll()
		 .forEach(students::add);
		 return students;
	 }
	 
	 public Student createStudent(Student student) {
		 this.studentrepository.save(student);
		 return student;
	 }
	 
	 public void deleteStudent(int id) {
		 this.studentrepository.deleteById(id);
	 }
	 
	 //UPDATE
	 public Student updateStudentFirstName(int id, String str) {
		 Student student = this.studentrepository.findById(id);
		 student.setFirstname(str);
		 this.studentrepository.save(student);
		 return student;
	 }
	 
	 public Student updateStudentLastName(int id, String str) {
		 Student student = this.studentrepository.findById(id);
		 student.setLastname(str);
		 this.studentrepository.save(student);
		 return student;
	 }
	 
	 public Student updateStudentAllowance(int id, int allowance) {
		 Student student = this.studentrepository.findById(id);
		 student.setAllowance(allowance);
		 this.studentrepository.save(student);
		 return student;
	 }
}



