package com.mvc.upgrade.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDto {

	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
}