package com.devrezaur.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devrezaur.main.model.Book;
import com.devrezaur.main.service.BookCatalogService;
import com.devrezaur.main.utility.InputValidator;

@Controller
public class BookCatalogController {

	private BookCatalogService bookCatalogService;
	private InputValidator inputValidator;

	public BookCatalogController(BookCatalogService bookCatalogService, InputValidator inputValidator) {
		this.bookCatalogService = bookCatalogService;
		this.inputValidator = inputValidator;
	}

	@GetMapping("/")
	public ModelAndView getAllBooks() {
		ModelAndView modelAndView = new ModelAndView("home-page");
		modelAndView.addObject("booklist", this.bookCatalogService.getAllBooks());

		return modelAndView;
	}

	@GetMapping("/book/{id}")
	public ModelAndView getBookById(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("home-page");
		modelAndView.addObject("book", this.bookCatalogService.getBookById(id));
		modelAndView.addObject("booklist", this.bookCatalogService.getAllBooks());

		return modelAndView;
	}

	@PostMapping("/book/add")
	public String addBook(@ModelAttribute Book book, Model model, RedirectAttributes ra) {
		try {
			if (inputValidator.isValid(book)) {
				String message = this.bookCatalogService.addBook(book);
				ra.addFlashAttribute("message", message);
				model.addAttribute("booklist", this.bookCatalogService.getAllBooks());
			}
		} catch (Exception ex) {
			String message = ex.getMessage();
			ra.addFlashAttribute("message", message);
			model.addAttribute("booklist", this.bookCatalogService.getAllBooks());
		}

		return "redirect:/";
	}

	@PostMapping("/book/update")
	public String updateBook(@ModelAttribute Book book, Model model, RedirectAttributes ra) {
		try {
			if (inputValidator.isValid(book)) {
				String message = this.bookCatalogService.updateBook(book);
				ra.addFlashAttribute("message", message);
				model.addAttribute("booklist", this.bookCatalogService.getAllBooks());
			}
		} catch (Exception ex) {
			String message = ex.getMessage();
			ra.addFlashAttribute("message", message);
			model.addAttribute("booklist", this.bookCatalogService.getAllBooks());
		}

		return "redirect:/";
	}

	@GetMapping("/book/delete/{id}")
	public String deleteBook(@PathVariable int id, Model model, RedirectAttributes ra) {
		String message = this.bookCatalogService.deleteBook(id);
		ra.addFlashAttribute("message", message);
		model.addAttribute("booklist", this.bookCatalogService.getAllBooks());

		return "redirect:/";
	}

}
