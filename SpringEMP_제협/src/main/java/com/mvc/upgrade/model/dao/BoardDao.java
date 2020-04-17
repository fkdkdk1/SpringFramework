package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDto;
import com.mvc.upgrade.model.dto.PageDto;

public interface BoardDao {

	String NAMESPACE = "myboard.";
	
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
	public int countList();
	public List<BoardDto> selectList(PageDto dto);
	
}





