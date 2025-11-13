package com.ssafy.book.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book.dto.Book;

public interface BookDao {
	// 책 전체 목록 조회
	List<Book> selectAll() throws SQLException;
	
	// 책 상세 조회
	Book findById(int id) throws SQLException;
	
	// 책 정보 추가
	int insert(Book book) throws SQLException;
	
	// 책 정보 삭제
	int deleteById(int id) throws SQLException;
}
