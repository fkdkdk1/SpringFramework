package com.mvc.ex01.model.dto;

import java.util.Date;

import lombok.Data;


@Data
public class boardDto {
	
	private int myno;
	private String myname; 
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
}