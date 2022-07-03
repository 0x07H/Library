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
}



