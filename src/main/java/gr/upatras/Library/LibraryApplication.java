package gr.upatras.Library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		
		Book  book1 = new Book("123-123-123-123", "Title7", "Author2", 80, 5);
		Book  book2 = new Book("123-123-123-123", "Title7", "Author3", 80, 5);
//		Student mitsos = new Student(1234,"Mi Tsos", 1232);
		System.out.println(book2.getId());
		System.out.println(book2);
//		System.out.println(mitsos.getName());
//		SpringApplication.run
	}

}
