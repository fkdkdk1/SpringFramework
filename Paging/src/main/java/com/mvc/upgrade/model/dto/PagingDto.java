package com.mvc.upgrade.model.dto;

import lombok.Data;

@Data
public class PagingDto {
	
	private int rows = 5;		// 페이지당 보여줄 게시글의 수
	private int nowpage;		// 내가 현재 보고있는 페이지 번호
	private int startpage;  	// 페이지 시작 번호
	private int endpage; 		// 페이지 끝 번호
	private int pagescale = 5;	// 페이지 번호 개수
	private int pagegroup;  	// 1,2,3,4,5 -> 1번그룹
	private int totalpage;  	// 총 페이지 개수
	
}