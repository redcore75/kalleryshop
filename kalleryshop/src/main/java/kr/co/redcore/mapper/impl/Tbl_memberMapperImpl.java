package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.mapper.Tbl_memberMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_memberMapperImpl implements Tbl_memberMapper {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public long getTbl_memberCntByMember_id(String member_id) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Tbl_member.getTbl_memberCntByMember_id", member_id);
	}
	
	@Override
	public long getTbl_memberCntByMember_nick_name(String member_nick_name) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Tbl_member.getTbl_memberCntByMember_nick_name", member_nick_name);
	}	
	
	public long getTbl_memberCntByMember_idEtc(String member_id, String member_type) throws SQLException {
		HashMap param = new HashMap();
		param.put("member_id", member_id);
		param.put("member_type", member_type);
		
		return sqlSession.selectOne("Tbl_member.getTbl_memberCntByMember_idEtc", param);
	}
	
	
	public Tbl_member getTbl_memberByMember_id(String member_id) throws SQLException {
		return sqlSession.selectOne("Tbl_member.getTbl_memberByMember_id", member_id);
	}
	
	@Override
	public Tbl_member getTbl_memberByMember_idEtc(String member_id, String password) throws SQLException {
		// TODO Auto-generated method stub
		HashMap param = new HashMap();
		param.put("member_id", member_id);
		param.put("password", password);
		
		return sqlSession.selectOne("Tbl_member.getTbl_memberByMember_idEtc", param);
	}
	
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException {
		return sqlSession.selectOne("Tbl_member.getPageHelperCntByParamMap", paramMap);
	}
	
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException {
		paramMap.put("start", (int)start);
		paramMap.put("size", (int)size);
		
		return sqlSession.selectList("Tbl_member.getPageHelperListByParamMapEtc", paramMap);
	}
	
	public int insertTbl_member(Tbl_member tbl_member) throws SQLException {
		return sqlSession.insert("Tbl_member.insertTbl_member", tbl_member);
	}
	
	public int updateTbl_member(Tbl_member tbl_member) throws SQLException {
		return sqlSession.update("Tbl_member.updateTbl_member", tbl_member);
	}
	
	public int updateTbl_memberForInfo(Tbl_member tbl_member) throws SQLException {
		return sqlSession.update("Tbl_member.updateTbl_memberForInfo", tbl_member);
	}
	
	public int updateTbl_memberForPassword(String member_id, String password) throws SQLException {
		HashMap param = new HashMap();
		param.put("member_id", member_id);
		param.put("password", password);
		param.put("uptby", member_id);
		
		return sqlSession.update("Tbl_member.updateTbl_memberForPassword", param);
	}
	
	public int updateTbl_memberForCurr_point(String member_id, long curr_point) throws SQLException {
		HashMap param = new HashMap();
		param.put("member_id", member_id);
		param.put("curr_point", curr_point);
		param.put("uptby", member_id);
		
		return sqlSession.update("Tbl_member.updateTbl_memberForCurr_point", param);
	}	
}
