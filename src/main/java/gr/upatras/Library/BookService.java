package gr.upatras.Library;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService{// implements IBookService{

// creating an object of ArrayList
//	List<Book> books = new ArrayList<Book>();
	
	@Autowired
	private BookRepo bookrepo;

	
	
	
	/**
	 * adding books to the List
	 */
//	public BookService(BookRepo bookrepo) {
//		super();
//		this.bookrepo = bookrepo;
//		bookrepo.save(new Book("Adsfdsfa1", "Title1", "Author1", 2001, 6));
		/*
		bookrepo.save(new Book("Adsfdsfa2", "Title2", "Author1", 2002, 3));
		bookrepo.save(new Book("Adsfdsfa3", "Title3", "Author1", 2003, 7));
		bookrepo.save(new Book("Adsfdsfa4", "Title4", "Author1", 2004, 1));
		bookrepo.save(new Book("Adsfdsfa5", "Title5", "Author1", 2005, 5));
		bookrepo.save(new Book("Adsfdsfa6", "Title6", "Author1", 2006, 4));
*/
	}
	
//	/**
//	 * returns a list of books
//	 */
//	@Override
//	public List<Book> findAll() {
//		return books;
//	}
//
//	@Override
//	public Book findByISBN(String ISBN) {
//		for (Book b : books) {
//			if (b.getISBN() == ISBN) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public Book addBook(Book b) {
//		books.add(b);
//		return b;
//	}
//
//	@Override
//	public Book rentBook(Book b) {
//		Book rentBook = findByISBN(b.getISBN());
//		int remaining = rentBook.getAvailable();
//		if (rentBook.getAvailable() != 0) {
//			rentBook.setAvailable(remaining-1);
//			return rentBook;
//		}
//		return null;
//	}
//	
//	@Override
//	public Book returnBook(Book b) {
//		Book returnBook= findByISBN(b.getISBN());
//		int max = returnBook.getQuantity();
//		int remaining = returnBook.getAvailable();
//		if (remaining +1 <= max) {
//			returnBook.setAvailable(remaining+1);
//			return returnBook;
//		}
//		return null;
//	}
//
//	@Override
//	public Void deleteBook(String isbn) {
//		for (Book b : books) {
//			if (b.getISBN() == isbn) {
//				books.remove(b);
//				break;
//			}
//		}
//		return null;
//	}
}