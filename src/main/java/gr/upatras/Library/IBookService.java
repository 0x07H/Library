package gr.upatras.Library;

import java.util.List;

public interface IBookService {
	/**
	 * @return all books
	 */
	List<Book> findAll();

	Book findByISBN(String ISBN);

	Book addBook(Book b);

	Void deleteBook(String ISBN);

	Book rentBook(Book b);

	Book returnBook(Book b);

}
