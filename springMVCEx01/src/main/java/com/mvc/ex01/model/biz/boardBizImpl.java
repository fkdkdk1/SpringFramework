package com.mvc.ex01.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.ex01.model.dao.boardDao;
import com.mvc.ex01.model.dto.boardDto;

@Service
public class boardBizImpl implements boardDao {

	@Autowired
	boardDao dao; 
	
	@Override
	public List<boardDto> selectList() {
		
		return dao.selectList();
	}
 
	@Override
	public boardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return dao.selectOne(myno);
	}
 
	@Override
	public int insert(boardDto dto) {
		
		return dao.insert(dto);
	}
 
	@Override
	public int update(boardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		return dao.delete(myno);
	}

}
