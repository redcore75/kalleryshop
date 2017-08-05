package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_member_point;
import kr.co.redcore.mapper.Tbl_member_pointMapper;

@Repository
public class Tbl_member_pointMapperImpl implements Tbl_member_pointMapper {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
		
//	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException {
//		return sqlSession.selectOne("Tbl_member.getPageHelperCntByParamMap", paramMap);
//	}
//	
//	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException {
//		paramMap.put("start", (int)start);
//		paramMap.put("size", (int)size);
//		
//		return sqlSession.selectList("Tbl_member.getPageHelperListByParamMapEtc", paramMap);
//	}
	
	public int insertTbl_member_point(Tbl_member_point tbl_member_point) throws SQLException {
		return sqlSession.insert("Tbl_member_point.insertTbl_member_point", tbl_member_point);
	}
}
