package com.mvc.ex01.model.biz;

import java.util.List;

import com.mvc.ex01.model.dto.boardDto;

public interface boardBiz {
	
	public List<boardDto> selectList();
	public boardDto selectOne(int myno);
	public int insert(boardDto dto);
	public int update(boardDto dto);
	public int delete(int myno);

}
