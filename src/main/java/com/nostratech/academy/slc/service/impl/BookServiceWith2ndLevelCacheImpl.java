package com.nostratech.academy.slc.service.impl;

import org.springframework.stereotype.Service;

import com.nostratech.academy.slc.domain.Book;
import com.nostratech.academy.slc.dto.BookDTO;
import com.nostratech.academy.slc.exception.ResourceNotFoundException;
import com.nostratech.academy.slc.repository.BookRepository;
import com.nostratech.academy.slc.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("book-with-cache")
public class BookServiceWith2ndLevelCacheImpl implements BookService {

	private final BookRepository bookRepository;

	@org.springframework.cache.annotation.Cacheable(value = "book", key = "#id")
	@Override
	public BookDTO findBookDetail(Long id) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("order.not.found"));

		BookDTO dto = new BookDTO(book.getId(), book.getTitle(), book.getDescription());

		return dto;
	}

}
