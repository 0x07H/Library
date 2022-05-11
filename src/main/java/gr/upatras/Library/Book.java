package gr.upatras.Library;


public class Book {

	private String ISBN;
	private String title;
	private String Author;
    private int year;
	private int  quantity;


	public Book(String ISBN, String title, String Author, int year, int quantity) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.Author = Author;
		this.year = year;
		this.quantity = quantity;
		}


	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return Author;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.Author = author;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//Setters-Getters
	
	
}
	