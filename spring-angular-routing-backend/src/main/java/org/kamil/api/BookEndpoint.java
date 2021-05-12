package org.kamil.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.kamil.model.Book;
import org.kamil.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class BookEndpoint {

	private BookRepository bookRepo;

	@Autowired
	public BookEndpoint(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@GetMapping("/api/books")
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	@GetMapping("/api/books/{id}")
	public ResponseEntity<Optional<Book>> getById(@PathVariable Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return ResponseEntity.ok(book);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/api/books")
	public ResponseEntity<?> save(@RequestBody Book book) {
		if (book.getId() == null) {
			Book saved = bookRepo.save(book);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
					.toUri();

			return ResponseEntity.created(location).body(book);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
