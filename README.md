# Library
Simple SpringBoot Book Lending Library

Components:
- Book Class(String ISBN, String title, String author, int year, Student booklender)
- Student Class(String firstName, String lastName, int allowance)
- Respective BookService and StudentService Autowire CRUDRepositories that perform the necessary data addition and removal operations
- BookController and StudentController implemennt the REST API endponts

Finally, the lending and returning operations are performed via the StudentController, which adds the stuent instance in the booklender field of each book.

We assume each book as a unique entry in our database and there can be multiple instances of the same book.
