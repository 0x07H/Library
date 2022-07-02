package gr.upatras.Library;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String ISBN;
	private String title;
	private String Author;
    private int year;
	private int  quantity;
	private int  available;


	public Book() {
	}
	
	public Book(String iSBN, String title, String author, int year, int quantity) {
		ISBN = iSBN;
		this.title = title;
		Author = author;
		this.year = year;
		this.quantity = quantity;
		//Availability is the same as quantity on setup
		this.available = quantity;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}


	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}


	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}


	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return Author;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		Author = author;
	}
}