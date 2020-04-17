package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDto;
import com.mvc.upgrade.model.dto.PagingDto;

public interface BoardBiz {

	public List<BoardDto> selectList(int page);
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto); 
	public int update(BoardDto dto);
	public int delete(int myno);
	public PagingDto totalpage(int page);
	 
}
