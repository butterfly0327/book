package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book.dto.Book;

public interface BookService {
	// 책 전체 조회
	public List<Book> selectAll() throws SQLException;
	
	// 책 상세 조회
	public Book findById(int id) throws SQLException;
	
	// 책 정보 추가
	public int insert(Book book) throws SQLException;
	
	// 책 정보 삭제
	public int deleteById(int id) throws SQLException;
}
