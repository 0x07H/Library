package gr.upatras.Library;

import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(required = false, hidden = true)
	private int id;
	
	private String ISBN;
	private String title;
	private String Author;
    private int year;
	private int  quantity;
	private int  available;
	private int booked;
	
	@ManyToOne
	private Student booklender;


	public Book() {
	}
	
	public Book(String iSBN, String title, String author, int year, int quantity, int booked) {
		ISBN = iSBN;
		this.title = title;
		Author = author;
		this.year = year;
		this.quantity = quantity;
		//Availability is the same as quantity on setup
		this.booked = booked;
		this.available = quantity - booked;
	}

	
}