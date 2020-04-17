package com.mvc.update.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JdbcDto {
	
	private int seq;
	private String writer;
	private String title;
	private String content; 
	private Date regdate;

}
