package gr.upatras.Library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LibraryApplication.class, args);
		Book  book1 = new Book("155-456-456-12","Title1","Author1",2022,10);
		Student mitsos = new Student(1234,"Name Full", 1232);
		
		System.out.println(book1.getAuthor());
		System.out.println(mitsos.getName());
	}

}
