package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.domain.Tbl_prd_mst;
import kr.co.redcore.domain.view.Vw_prd_mst;
import kr.co.redcore.mapper.Tbl_prd_mstMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_prd_mstMapperImpl implements Tbl_prd_mstMapper {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Vw_prd_mst getVw_prd_mstByPrd_mst_seq(long prd_mst_seq) throws SQLException {
		return sqlSession.selectOne("Tbl_prd_mst.getVw_prd_mstByPrd_mst_seq", prd_mst_seq);
	}
	
	public List getVw_prd_mstLastListByCate_mst_seq(long cate_mst_seq) throws SQLException {	
		return sqlSession.selectList("Tbl_prd_mst.getVw_prd_mstLastListByCate_mst_seq", cate_mst_seq);
	}
	
	public List getVw_prd_mstLastListExtMinusByCate_mst_seqEtc(long cate_mst_seq, String prd_name) throws SQLException {
		HashMap param = new HashMap();
		param.put("cate_mst_seq", cate_mst_seq);
		param.put("prd_name", prd_name);
		
		return sqlSession.selectList("Tbl_prd_mst.getVw_prd_mstLastListExtMinusByCate_mst_seqEtc", param);
	}
	
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException {
		return sqlSession.selectOne("Tbl_prd_mst.getPageHelperCntByParamMap", paramMap);
	}
	
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException {
		paramMap.put("start", (int)start);
		paramMap.put("size", (int)size);
		
		return sqlSession.selectList("Tbl_prd_mst.getPageHelperListByParamMapEtc", paramMap);
	}
	
	public long insertTbl_prd_mst(Tbl_prd_mst tbl_prd_mst) throws SQLException {
		sqlSession.insert("Tbl_prd_mst.insertTbl_prd_mst", tbl_prd_mst);
		
		return tbl_prd_mst.getPrd_mst_seq();
	}
	
	public long updateTbl_prd_mst(Tbl_prd_mst tbl_prd_mst) throws SQLException {
		return sqlSession.update("Tbl_prd_mst.updateTbl_prd_mst", tbl_prd_mst);
	}
}
