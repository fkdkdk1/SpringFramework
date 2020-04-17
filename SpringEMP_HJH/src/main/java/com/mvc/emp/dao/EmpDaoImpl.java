package com.mvc.emp.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.emp.dto.EmpDto;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<EmpDto> selectList() { 
		
		List<EmpDto> list = new ArrayList<EmpDto>();
		
		list = sqlSession.selectList(NAMESPACE + "selectList");
	
		return list; 
	}
}
 