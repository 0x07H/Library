package gr.upatras.Library;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class BookController {
    @Autowired
	private BookService bookService;
	
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@ApiOperation(value = "Retrieves all Books", notes = "This operation retrieves all Book entries. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/", produces = { "application/json;charset=utf-8" }, method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		log.info("Will return all Books");
		List<Book> books = bookService.getAllBooks();
		return books;
	}
	
	@ApiOperation(value = "Creates a Book", notes = "This operation creates a Book entry.", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book", produces = { "application/json;charset=utf-8" }, consumes = {
			"application/json;charset=utf-8" }, method = RequestMethod.POST)
	public ResponseEntity<Book> createBook(
			@ApiParam(value = "The Book to be created", required = true) @RequestBody Book b) {
		log.info("Will add a new book");
		Book book = bookService.createBook(b);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@ApiOperation(value = "Retrieves a Book by id", notes = "This operation retrieves a Book entry. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	public Book getBookbyID(
		@ApiParam(value = "Identifier of the Book", required = true) @PathVariable("id") int id) {
		log.info(String.format("Will return Book with id %d", id));
		Book book = bookService.getBook(id);
		return book;
	}
	
	@ApiOperation(value = "Update Book Title by id", notes = "This operation updates a Book title. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{id}/{title}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	public Book updateBookTitle(
		@ApiParam(value = "Identifier of the Book", required = true) @PathVariable("id") int id,
		@ApiParam(value = "Updated title of the Book", required = true) @PathVariable("title") String str){
		log.info(String.format("Will update Book Title with id %d", id));
		Book book = bookService.updateBookTitle(id, str);
		return book;
	}

	@ApiOperation(value = "Update Book Author by id", notes = "This operation updates a Book author. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{id}/{author}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	public Book updateBookAuthor(
		@ApiParam(value = "Identifier of the Book", required = true) @PathVariable("id") int id,
		@ApiParam(value = "Updated author of the Book", required = true) @PathVariable("author") String str){
		log.info(String.format("Will update Book Author with id %d", id));
		Book book = bookService.updateBookAuthor(id, str);
		return book;
	}

	@ApiOperation(value = "Update Book ISBN by id", notes = "This operation updates a Book isbn. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{id}/{isbn}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	public Book updateBookISBN(
		@ApiParam(value = "Identifier of the Book", required = true) @PathVariable("id") int id,
		@ApiParam(value = "Updated isbn of the Book", required = true) @PathVariable("isbn") String str){
		log.info(String.format("Will update Book ISBN with id %d", id));
		Book book = bookService.updateBookISBN(id, str);
		return book;
	}
	
	@ApiOperation(value = "Update Book Year by id", notes = "This operation updates a Book year. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{id}/{year}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	public Book updateBookYear(
		@ApiParam(value = "Identifier of the Book", required = true) @PathVariable("id") int id,
		@ApiParam(value = "Updated year of the Book", required = true) @PathVariable("year") int year){
		log.info(String.format("Will update Book Year with id %d", id));
		Book book = bookService.updateBookYear(id, year);
		return book;
	}
	
	@ApiOperation(value = "Update Book Quantity by id", notes = "This operation updates a Book quantity. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{id}/{quantity}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	public Book updateBookQuantity(
		@ApiParam(value = "Identifier of the Book", required = true) @PathVariable("id") int id,
		@ApiParam(value = "Updated quantity of the Book", required = true) @PathVariable("quantity") int quantity){
		log.info(String.format("Will update Book quantity with id %d", id));
		Book book = bookService.updateBookQuantity(id, quantity);
		return book;
	}
}
	
	



/*
	@ApiOperation(value = "Deletes a Book by ISBN", notes = "This operation retrieves a Book entry. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{isbn}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletetById(
			@ApiParam(value = "Identifier of the Category", required = true) @PathVariable("isbn") String isbn) {
		try {
			log.info(String.format("Will delete object with ISBN %s", isbn));
			return new ResponseEntity<Void>(bookService.deleteBook(isbn), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/


/*
	@ApiOperation(value = "Updates partially a Book", nickname = "patchBook", notes = "This operation updates partially a Book entrty.", response = Book.class )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{isbn}", produces = { "application/json;charset=utf-8" }, consumes = {
			"application/json;charset=utf-8" }, method = RequestMethod.PATCH)
	ResponseEntity<Book> patchBook(
			@ApiParam(value = "The Book to be updated", required = true) @RequestBody Book body,
			@ApiParam(value = "Identifier of the Book", required = true) @PathVariable("isbn") String isbn) {
		Book book = bookService.rentBook(body);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		
	}*/
