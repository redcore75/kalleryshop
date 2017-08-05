package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.redcore.domain.Tbl_prd_detail;
import kr.co.redcore.domain.Tbl_prd_mst;
import kr.co.redcore.domain.Tbl_prd_opt;
import kr.co.redcore.mapper.Tbl_prd_mstMapper;
import kr.co.redcore.mapper.Tbl_prd_optMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_prd_optMapperImpl implements Tbl_prd_optMapper {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List getTbl_prd_optLastListByPrd_mst_seq(long prd_mst_seq) throws SQLException {
		return sqlSession.selectList("Tbl_prd_opt.getTbl_prd_optLastListByPrd_mst_seq", prd_mst_seq);
	}
	
	public long insertTbl_prd_opt(Tbl_prd_opt tbl_prd_opt) throws SQLException {
		return sqlSession.insert("Tbl_prd_opt.insertTbl_prd_opt", tbl_prd_opt);		
	}
}
