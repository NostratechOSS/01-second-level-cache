package com.nostratech.academy.slc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostratech.academy.slc.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
