package com.mvc.update.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.update.model.dao.JdbcDao;
import com.mvc.update.model.dto.JdbcDto;

@Service
public class JdbcBizImpl implements JdbcBiz {

	@Autowired
	private JdbcDao dao;
	
	@Override
	public List<JdbcDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public JdbcDto selectOne(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(JdbcDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(JdbcDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
