package com.devrezaur.main.service;

import java.util.ArrayList;
import java.util.List;

import com.devrezaur.main.model.Book;

public class BookCatalogService {

	private List<Book> bookList = new ArrayList<Book>();

	public BookCatalogService() {
		super();
		this.bookList.add(new Book(1, "Book A", "Person A", "Category A"));
		this.bookList.add(new Book(2, "Book B", "Person B", "Category B"));
		this.bookList.add(new Book(3, "Book C", "Person C", "Category C"));
	}

	public Book getBookById(int bookId) {
		return this.bookList.stream().filter(book -> book.getBookId() == bookId).findFirst().orElse(null);
	}

	public List<Book> getAllBooks() {
		return this.bookList;
	}

	public String addBook(Book book) {
		try {
			book.setBookId(this.bookList.size() + 1);
			this.bookList.add(book);
		} catch (Exception ex) {
			return "Error adding new book";
		}

		return "Successfully added the new book";
	}

	public String updateBook(Book book) {
		try {
			this.bookList.set(book.getBookId() - 1, book);
		} catch (Exception ex) {
			return "Error updating book information";
		}

		return "Successfully updated book information";
	}

	public String deleteBook(int bookId) {
		try {
			this.bookList.remove(bookId - 1);
		} catch (Exception ex) {
			return "Error deleting book";
		}

		return "Successfully deleted book";
	}

}
