package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;
import com.mvc.upgrade.model.dto.PageDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] : select one");
		}
		
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] : insert");
		}
		
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] : delete");
		}
		
		return res;
	}
	
	@Override
	public int update(BoardDto dto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] : update");
		}
		
		return res;
	}
	
	// 전체 글 수 가져오기
	@Override
	public int countList() {
		return sqlSession.selectOne(NAMESPACE+ "countList");
	}
	
	// Paging 처리한 List 가져오기
	@Override
	public List<BoardDto> selectList(PageDto dto) {
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		list = sqlSession.selectList(NAMESPACE + "selectList" , dto);
		
		
		return list;
	}

}




