package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.dao.BookDao;

@Service
public class BookServiceImpl implements BookService{
	private final BookDao bookdao;
	public BookServiceImpl(BookDao bookdao) {
		System.out.println("BookServiceImpl 객체 생성");
		this.bookdao = bookdao;
	}
	
	// 책 전체 목록 조회
	@Override
	public List<Book> selectAll() throws SQLException {
		return bookdao.selectAll();
	}
	
	// 책 상세 조회
	@Override
	public Book findById(int id) throws SQLException {
		return bookdao.findById(id);
	}
	
	// 책 정보 추가
	@Override
	public int insert(Book book) throws SQLException {
		return bookdao.insert(book);
	}
	
	// 책 정보 삭제
	@Override
	public int deleteById(int id) throws SQLException {
		return bookdao.deleteById(id);
	}
}


