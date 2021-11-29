package com.devrezaur.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

	private int bookId;
	private String bookTitle;
	private String authorName;
	private String category;

	@Override
	public String toString() {
		return "Book Id: " + bookId + " Title: " + bookTitle + " Author Name: " + authorName + " Category: " + category;
	}

}