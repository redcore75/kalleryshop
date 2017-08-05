package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_auth_num;
import kr.co.redcore.mapper.Tbl_auth_numMapper;

@Repository
public class Tbl_auth_numMapperImpl implements Tbl_auth_numMapper {	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Tbl_auth_num getTbl_auth_numMaxByAuth_keyEtc(String auth_key, String auth_type) throws SQLException {
		HashMap param = new HashMap();
		param.put("auth_key", auth_key);
		param.put("auth_type", auth_type);
		
		return sqlSession.selectOne("Tbl_auth_num.getTbl_auth_numMaxByAuth_keyEtc", param);
	}
	
	public int insertTbl_auth_num(Tbl_auth_num tbl_auth_num) throws SQLException {
		return sqlSession.insert("Tbl_auth_num.insertTbl_auth_num", tbl_auth_num);
	}
}
