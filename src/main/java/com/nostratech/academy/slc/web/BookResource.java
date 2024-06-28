package com.nostratech.academy.slc.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nostratech.academy.slc.dto.BookDTO;
import com.nostratech.academy.slc.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/book")
public class BookResource {

	private final BookService bookServiceWithCache;

	private final BookService bookServiceWithoutCache;

	public BookResource(@Qualifier("book-with-cache") BookService bookServiceWithCache,
			@Qualifier("book-without-cache") BookService bookServiceWithoutCache) {
		super();
		this.bookServiceWithCache = bookServiceWithCache;
		this.bookServiceWithoutCache = bookServiceWithoutCache;
	}

	@GetMapping("/without-cache/{id}")
	public ResponseEntity<BookDTO> findBookDetailWithoutCache(@PathVariable Long id) {
		BookDTO dto = bookServiceWithoutCache.findBookDetail(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/with-cache/{id}")
	public ResponseEntity<BookDTO> findBookDetailWithCache(@PathVariable Long id) {
		BookDTO dto = bookServiceWithCache.findBookDetail(id);
		return ResponseEntity.ok(dto);
	}

}
