package com.devrezaur.main.utility;

import com.devrezaur.main.model.Book;

public class InputValidator {

	public boolean isValid(Book book) throws Exception {
		if (book.getBookTitle() == null || book.getBookTitle().equals("")) {
			throw new Exception("Book Title Cannot Be Empty");
		} else if (book.getAuthorName() == null || book.getAuthorName().equals("")) {
			throw new Exception("Author Name Cannot Be Empty");
		} else if (book.getCategory() == null || book.getCategory().equals("")) {
			throw new Exception("Category Type Cannot Be Empty");
		}
		return true;
	}
}
