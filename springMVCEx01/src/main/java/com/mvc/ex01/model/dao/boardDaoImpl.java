package com.mvc.ex01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.ex01.model.dto.boardDto;

@Repository
public class boardDaoImpl implements boardDao {
	
	
	@Inject
	SqlSessionTemplate sqlSessionTemplate;
	
	private int res;
	
	@Override
	public List<boardDto> selectList() { 
		
		return sqlSessionTemplate.selectList(NAMESPACE + "listAll");
	}

	@Override
	public boardDto selectOne(int myno) {
		
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectOne", myno);
	}

	@Override
	public int insert(boardDto dto) {
		
		res = sqlSessionTemplate.insert(NAMESPACE + "insert", dto);
		
		return res;
	}

	@Override
	public int update(boardDto dto) {
		
		res = sqlSessionTemplate.update(NAMESPACE + "update", dto);
		
		return res;
	}

	@Override
	public int delete(int myno) {
		
		res = sqlSessionTemplate.delete(NAMESPACE + "delete", myno);
		
		return res; 
	}


}
