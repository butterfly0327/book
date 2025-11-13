package com.ssafy.book.dto;

import org.springframework.boot.autoconfigure.AutoConfiguration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Book {
	private int id;
	private String title;
	private String author;
	private String description;
	private int price;

	
	
}
