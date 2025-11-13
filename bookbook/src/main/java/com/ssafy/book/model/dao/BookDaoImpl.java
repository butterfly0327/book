package com.ssafy.book.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ssafy.book.dto.Book;
import com.ssafy.webmvc.SpringHomework1Application;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	private final DataSource ds;
	
	
	public BookDaoImpl(DataSource ds) {
		this.ds = ds;
		return;
	}
	
	// 책 전체 목록 조회
	@Override
	public List<Book> selectAll() throws SQLException {
		String sql = "select id, title, author, price from book";
		List<Book> books = new ArrayList<>();
		
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));

				books.add(book);
			}
			
		}		
		
		return books;

	}
	
	// 책 상세 조회
	@Override
	public Book findById(int id) throws SQLException {
		String sql = "select id, title, author, description, price from book where id = ?";
		
		try(	
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, id);
			
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					Book book = new Book();
					book.setId(id);
					book.setTitle(rs.getString("title"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getInt("price"));
					book.setDescription(rs.getString("description"));
					return book;
				}
				return null;
			}
		}
	}
	
	// 책 정보 추가
	@Override
	public int insert(Book book) throws SQLException {
		String sql = "insert into book (title, author, price, description) values (?, ?, ?, ?)";		
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
				pstmt.setString(1,  book.getTitle());
				pstmt.setString(2,  book.getAuthor());
				pstmt.setInt(3,  book.getPrice());
				pstmt.setString(4,  book.getDescription());

				return pstmt.executeUpdate();
			}
	}
	
	// 책 정보 삭제
	@Override
	public int deleteById(int id) throws SQLException {
		String sql = "delete from book where id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
				pstmt.setInt(1, id);
				
				return pstmt.executeUpdate();
		}
	}
}
