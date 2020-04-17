package com.mvc.ex01.model.dao;

import java.util.List;

import com.mvc.ex01.model.dto.boardDto;

public interface boardDao {
	
	String NAMESPACE = "board.";
	
	public List<boardDto> selectList();
	public boardDto selectOne(int myno);
	public int insert(boardDto dto); 
	public int update(boardDto dto);
	public int delete(int myno);

}
 