package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession; 
	 
	@Override 
	public List<BoardDto> selectList(int start, int end) {
		 
		List<BoardDto> list = new ArrayList<BoardDto>(); 
		
		Map<String , Integer> map = new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("end", end);
		
		// 변수를 여러가지 보내야 하므로 Map 으로 관리
		list = sqlSession.selectList(NAMESPACE + "selectList", map);
		
		return list;
	}

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

	@Override
	public int totalpage() {
		
		return sqlSession.selectOne(NAMESPACE + "total");
		
	}

}




