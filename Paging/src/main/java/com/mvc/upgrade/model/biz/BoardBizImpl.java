package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;
import com.mvc.upgrade.model.dto.PagingDto;

@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList(int page) { 
		
		PagingDto dto = new PagingDto();
		
		int start = dto.getRows() * (page - 1) + 1 ;
		int end = page * dto.getRows();
		
		return dao.selectList(start, end);
	}

	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	@Override
	public PagingDto totalpage(int page) {
		
		PagingDto dto = new PagingDto();
		
		// 페이지 그룹 구하기 -> 1 ~ 5 ( 1번그룹 ) , 6 ~ 10 (2번 그룹)
		int pagegroup = (int)Math.ceil((double)page / dto.getPagescale());
		dto.setPagegroup(pagegroup);

		
		// 페이지에 시작수 , 끝 수 , 총페이지 개수 구해주기
		dto.setStartpage(dto.getPagescale() * (pagegroup - 1) + 1);
		dto.setEndpage(dto.getPagescale() * pagegroup);
		dto.setTotalpage((int)Math.ceil((double)dao.totalpage() / dto.getRows()));
		
		return dto;
	}

}
