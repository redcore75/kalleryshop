package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_cate_mst;
import kr.co.redcore.domain.Tbl_cate_prd;
import kr.co.redcore.mapper.Tbl_cate_mstMapper;
import kr.co.redcore.mapper.Tbl_cate_prdMapper;

@Repository
public class Tbl_cate_prdMapperImpl implements Tbl_cate_prdMapper {	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List getTbl_cate_prdListByPrd_mst_seq(long prd_mst_seq) throws Exception {
		return sqlSession.selectList("Tbl_cate_prd.getTbl_cate_prdListByPrd_mst_seq", prd_mst_seq);
	}
	
	@Override
	public int insertTbl_cate_prd(Tbl_cate_prd tbl_cate_prd) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.insert("Tbl_cate_prd.insertTbl_cate_prd", tbl_cate_prd);
	}

	@Override
	public int deleteTbl_cate_prdByPrd_mst_seq(long prd_mst_seq) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.delete("Tbl_cate_prd.deleteTbl_cate_prdByPrd_mst_seq", prd_mst_seq);
	}
	
	public int deleteTbl_cate_prdByCate_mst_seq(long cate_mst_seq) throws SQLException {
		return sqlSession.delete("Tbl_cate_prd.deleteTbl_cate_prdByCate_mst_seq", cate_mst_seq);
	}
}
