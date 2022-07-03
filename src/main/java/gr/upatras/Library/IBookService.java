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

	Book updateBookISBN(int id, String str);

	Book updateBookAuthor(int id, String str);

	Book updateBookYear(int id, int year);

	Book updateBookQuantity(int id, int qnt);
}
