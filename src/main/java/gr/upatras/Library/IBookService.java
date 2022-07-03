package gr.upatras.Library;

import java.util.List;

public interface IBookService {
	/**
	 * @return all books
	 */
	List<Book> getAllBooks();

	Book createBook(Book b);

	void deleteBook(int d);

	Book updateBookTitle(int id, String str);

	void updateBookISBN(int id, String str);

	void updateBookAuthor(int id, String str);

	void updateBookYear(int id, int year);

	void updateBookQuantity(int id, int qnt);
}
