package gr.upatras.Library;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{

// creating an object of ArrayList
	List<Book> books = new ArrayList<Book>();

	/**
	 * adding products to the List
	 */
	public BookService() {
		super();
		books.add(new Book("adsfdsfa1", "title1", "author1", 20, 6, 6));
		books.add(new Book("adsfdsfa2", "title2", "author1", 30, 3, 6));
		books.add(new Book("adsfdsfa3", "title3", "author1", 40, 7, 6));
		books.add(new Book("adsfdsfa4", "title4", "author1", 50, 1, 6));
		books.add(new Book("adsfdsfa5", "title5", "author1", 60, 5, 6));
		books.add(new Book("adsfdsfa6", "title6", "author1", 70, 4, 6));
	}

	/**
	 * returns a list of product
	 */
	@Override
	public List<Book> findAll() {
		return books;
	}

	@Override
	public Book findByISBN(String ISBN) {
		for (Book b : books) {
			if (b.getISBN() == ISBN) {
				return b;
			}
		}
		return null;
	}

	@Override
	public Book addBook(Book b) {
		books.add(b);
		return b;
	}

	@Override
	public Book rentBook(Book b) {
		Book rentBook = findByISBN(b.getISBN());
		int remaining = rentBook.getAvailable();
		if (rentBook.getAvailable() != 0) {
			rentBook.setAvailable(remaining-1);
			return rentBook;
		}
		return null;
	}
	
	@Override
	public Book returnBook(Book b) {
		Book returnBook= findByISBN(b.getISBN());
		int max = returnBook.getQuantity();
		int remaining = returnBook.getAvailable();
		if (remaining +1 <= max) {
			returnBook.setAvailable(remaining+1);
			return returnBook;
		}
		return null;
	}

	@Override
	public Void deleteBook(String isbn) {
		for (Book b : books) {
			if (b.getISBN() == isbn) {
				books.remove(b);
				break;
			}
		}
		return null;
	}
}