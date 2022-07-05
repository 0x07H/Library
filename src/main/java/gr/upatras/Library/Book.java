package gr.upatras.Library;

import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(required = false, hidden = true)
	private int id;

	private String ISBN;
	private String title;
	private String Author;
	private int year;

	@OneToOne
	@ApiModelProperty(required = false, hidden = true)
	private Student booklender;

	public Book() {
	}
	
	public Book(String ISBN, String title, String author, int year, Student booklender) {
		this.ISBN = ISBN;
		this.title = title;
		Author = author;
		this.year = year;
		this.booklender = booklender;
	}

	// ADD ANOTHER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Student getBooklender() {
		return booklender;
	}

	public void setBooklender(Student booklender) {
		this.booklender = booklender;
	}
}