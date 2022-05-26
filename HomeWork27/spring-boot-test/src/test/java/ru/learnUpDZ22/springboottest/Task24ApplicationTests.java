package ru.learnUpDZ22.springboottest;

import Dao.entity.Author;
import Dao.entityservice.AuthorService;
import Dao.entityservice.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;;

@SpringBootApplication
public class Task24ApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(Task24ApplicationTests.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Task24ApplicationTests.class, args);

		AuthorService authorService = context.getBean(AuthorService.class);
		BookService bookService = context.getBean(BookService.class);

		for (Author author : authorService.getAuthors()) {
			log.info("Author: {}\nBooks: {}", author, bookService.getAllBooksByAuthorsName(author.getAuthorName()));

		}
	}
}