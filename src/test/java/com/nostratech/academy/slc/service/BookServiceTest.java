package com.nostratech.academy.slc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import com.nostratech.academy.slc.dto.BookDTO;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	private BookService bookService;

	private BookDTO findBook(Long id) {
		log.info("Query Book ", id);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		BookDTO dto = bookService.findBookDetail(id);
		stopWatch.stop();
		log.info("find Book "+ stopWatch.getTotalTimeMillis()+" ms");

		return dto;
		
	}
	
	@Test
	@Order(1)
	@Transactional
	public void findBookTest() {
		log.info("---- start findBookTest()----");
		BookDTO dto = findBook(1L);
		assertEquals("Building a Second Brain", dto.title());
		log.info("---- finish findBookTest()----");

		
	}
	
	@Test
	@Order(2)
    @Transactional
    void testFindBook3Times() {
		log.info("start testFindBook3Times()");
		findBookTest();
		findBookTest();
		findBookTest();
		log.info("finish testFindBook3Times()");


    }
}
