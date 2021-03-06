package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.redcore.domain.Tbl_banner;
import kr.co.redcore.domain.Tbl_banner_mgr;
import kr.co.redcore.domain.view.Vw_banner;
import kr.co.redcore.mapper.Tbl_bannerMapper;
import kr.co.redcore.mapper.Tbl_banner_mgrMapper;
import kr.co.redcore.util.ParamMap;

@Repository
public class Tbl_bannerMapperImpl implements Tbl_bannerMapper {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Vw_banner getVw_bannerByBanner_seq(long banner_seq) throws SQLException {
		return sqlSession.selectOne("Tbl_banner.getVw_bannerByBanner_seq", banner_seq);
	}
	
	public List getVw_bannerListByBanner_mgr_seq(long banner_mgr_seq) throws SQLException {
		return sqlSession.selectList("Tbl_banner.getVw_bannerListByBanner_mgr_seq", banner_mgr_seq);
	}
	
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException {
		return sqlSession.selectOne("Tbl_banner.getPageHelperCntByParamMap", paramMap);
	}
	
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException {
		paramMap.put("start", (int)start);
		paramMap.put("size", (int)size);
		
		return sqlSession.selectList("Tbl_banner.getPageHelperListByParamMapEtc", paramMap);
	}

	@Override
	public int insertTbl_banner(Tbl_banner tbl_banner) throws SQLException {
		return sqlSession.insert("Tbl_banner.insertTbl_banner", tbl_banner);
	}

	@Override
	public int updateTbl_banner(Tbl_banner tbl_banner) throws SQLException {
		return sqlSession.update("Tbl_banner.updateTbl_banner", tbl_banner);
	}
}
