/**
 * 
 */
package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repositories.AuthorRepository;

/**
 * @author dcividin
 *
 */
@Controller
public class AuthorController {
	private final AuthorRepository authorRepository;

	/**
	 * @param authorRepository
	 */
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors/list";
	}
}
