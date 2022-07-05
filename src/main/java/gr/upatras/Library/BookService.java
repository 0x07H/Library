package gr.upatras.Library;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookrepository.findAll().forEach(books::add);
		return books;
	}

	public Book getBook(int id) {
		return (Book) this.bookrepository.findById(id);
	}

	public Book createBook(Book b) {
		this.bookrepository.save(b);
		// we need to return a Book
		return b;
	}

	public void updateBook(Book b) {
		this.bookrepository.save(b);
	}

	public void deleteBook(int id) {
		this.bookrepository.deleteById(id);
	}

	// UPDATE
	public Book updateBookTitle(int id, String str) {
		Book book = this.bookrepository.findById(id);
		book.setTitle(str);
		this.bookrepository.save(book);
		return book;
	}

	public Book updateBookAuthor(int id, String str) {
		Book book = this.bookrepository.findById(id);
		book.setAuthor(str);
		this.bookrepository.save(book);
		return book;
	}

	public Book updateBookISBN(int id, String str) {
		Book book = this.bookrepository.findById(id);
		book.setISBN(str);
		this.bookrepository.save(book);
		return book;
	}

	public Book updateBookYear(int id, int year) {
		Book book = this.bookrepository.findById(id);
		book.setYear(year);
		this.bookrepository.save(book);
		return book;
	}

	public Book updateBookQuantity(int id, int qnt) {
		Book book = this.bookrepository.findById(id);
		book.setYear(qnt);
		this.bookrepository.save(book);
		return book;
	}
}