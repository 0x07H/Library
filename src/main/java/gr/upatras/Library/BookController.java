package gr.upatras.Library;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	private IBookService bookService;
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
	public List<Book> getBook() {
		// finds all the products
		List<Book> books = bookService.findAll();
		// returns the product list
		return books;
	}

	@ApiOperation(value = "Retrieves a Book by ISBN", notes = "This operation retrieves a Book entry. ", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{isbn}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	public Book getProductById(
		@ApiParam(value = "Identifier of the Category", required = true) @PathVariable("isbn") String isbn) {
		log.info(String.format("Will return product with ISBN %s", isbn));
		Book product = bookService.findByISBN(isbn);
		return product;
	}

	@ApiOperation(value = "Deletes a Product by ISBN", notes = "This operation retrieves a Book entry. ", response = Book.class)
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

	@ApiOperation(value = "Creates a Book", notes = "This operation creates a Book entry.", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/product", produces = { "application/json;charset=utf-8" }, consumes = {
			"application/json;charset=utf-8" }, method = RequestMethod.POST)
	public ResponseEntity<Book> createProduct(
			@ApiParam(value = "The Book to be created", required = true) @RequestBody Book b) {
		log.info("Will add a new book");
		Book book = bookService.addBook(b);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@ApiOperation(value = "Updates partially a Book", nickname = "patchBook", notes = "This operation updates partially a Book entrty.", response = Book.class )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated", response = Book.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/book/{isbn}", produces = { "application/json;charset=utf-8" }, consumes = {
			"application/json;charset=utf-8" }, method = RequestMethod.PATCH)
	ResponseEntity<Book> patchProduct(
			@ApiParam(value = "The Book to be updated", required = true) @RequestBody Book body,
			@ApiParam(value = "Identifier of the Product", required = true) @PathVariable("isbn") String isbn) {
		Book book = bookService.rentBook(body);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
