package gr.upatras.Library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private BookService bookService;

	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		log.info("Get all students");
		return studentService.getAllStudents();
	}

	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable int id) {
		log.info("Get Student by Id");
		return studentService.getStudentById(id);
	}

	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		log.info("Created NEW user");
		studentService.createStudent(student);
		return student;
	}

	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) {
		log.info("Delete student by ID students");
		studentService.deleteStudent(id);
	}

	@PatchMapping("/updateStudentFirstname/{id}/{first}/")
	public void updateFirstName(@PathVariable int id, @PathVariable String first) {
		log.info("Update Firstname of student by ID students");
		studentService.updateStudentFirstName(id, first);
	}

	@PatchMapping("/updateStudentLastname/{id}/{last}/")
	public void updateLastName(@PathVariable int id, @PathVariable String last) {
		log.info("Update Lastname of student by ID students");
		studentService.updateStudentFirstName(id, last);
	}

	@PatchMapping("/updateStudentAllowance/{id}/{allowance}")
	public void updateAllowance(@PathVariable int id, @PathVariable int allowance) {
		log.info("Update Lastname of student by ID students");
		studentService.updateStudentAllowance(id, allowance);
	}

	@PatchMapping("/lendBook/{bookId}/{studentId}")
	public ResponseEntity<Book> lendBook(@PathVariable int bookId, @PathVariable int studentId) {
		log.info("Lend book");
		// TODO
		Book book = bookService.getBook(bookId);
		log.info("Book = {}",book.getTitle());
		// Check if book is lended
		if (book.getBooklender() != null) {
			log.info("book lender");
			return new ResponseEntity<>(book, null, HttpStatus.CONFLICT);
		}
		Student student = studentService.getStudentById(studentId);
		log.info("Student name: {}",student.getFirstname());
		book.setBooklender(student);
		bookService.updateBook(book);
		return new ResponseEntity<Book>(book, null, HttpStatus.OK);
	}

	@PatchMapping("/returndBook/{bookId}/{studentId}")
	public ResponseEntity<Book> returnBook(@PathVariable int bookId, @PathVariable int studentId) {
		log.info("Return book");
		// TODO
		Book book = bookService.getBook(bookId);
		// Book is not lended
		if (book.getBooklender() == null) {
			return new ResponseEntity<Book>(book, null, HttpStatus.CONFLICT);
		}
		book.setBooklender(null);
		bookService.updateBook(book);
		return new ResponseEntity<Book>(book, null, HttpStatus.OK);
	}
}
