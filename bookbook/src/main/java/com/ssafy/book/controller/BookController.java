package com.ssafy.book.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private final BookService bookService;
	public BookController(BookService bookService) {
		System.out.println("BookController 객체 생성");
		this.bookService = bookService;
	}
	
	
	// 전체조회
	@GetMapping("/list")
	public String list(Model model) throws SQLException{
		List<Book> list = bookService.selectAll();
		model.addAttribute("list", list);
		
		return "book/list";
	}
	
	// 등록화면 요청
	@PostMapping("/add")
	public String add(@ModelAttribute Book book) throws SQLException{
		System.out.println("파라미터 정보 : " + book);
		bookService.insert(book);
		return "redirect:/books/list";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "book/regist";
	}
	
	
	// 상세정보 조회
	@GetMapping("/detail")
	public String search(@RequestParam("id") int id, Model model) throws SQLException {
		Book book = bookService.findById(id);
		
		
		System.out.println(book);
		// 보내기
		model.addAttribute("book", book);
		
		return "book/detail";
	}
	
	
	// 정보 삭제
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id) throws SQLException {
		bookService.deleteById(id);
		
		return "redirect:/books/list";
	}
	
}
