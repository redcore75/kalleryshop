package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_prd_detail;
import kr.co.redcore.mapper.Tbl_prd_detailMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_prd_detailMapperImpl implements Tbl_prd_detailMapper {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Tbl_prd_detail getTbl_prd_detailLastByPrd_mst_seq(long prd_mst_seq) throws SQLException {
		return sqlSession.selectOne("Tbl_prd_detail.getTbl_prd_detailLastByPrd_mst_seq", prd_mst_seq);
	}
	
	public int insertTbl_prd_detail(Tbl_prd_detail tbl_prd_detail) throws SQLException {
		return sqlSession.insert("Tbl_prd_detail.insertTbl_prd_detail", tbl_prd_detail);
	}
}
