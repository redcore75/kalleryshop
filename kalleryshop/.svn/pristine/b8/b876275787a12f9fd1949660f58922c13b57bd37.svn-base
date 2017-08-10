package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.co.redcore.domain.Tbl_banner_mgr;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.util.ParamMap;

public interface Tbl_banner_mgrMapper {
	public Tbl_banner_mgr getTbl_banner_mgrByBanner_mgr_seq(long banner_mgr_seq) throws SQLException;
	public List getTbl_banner_mgrListByBanner_name(String banner_name) throws SQLException;	
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException;
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException;
	public int insertTbl_banner_mgr(Tbl_banner_mgr tbl_banner_mgr) throws SQLException;
	public int updateTbl_banner_mgr(Tbl_banner_mgr tbl_banner_mgr) throws SQLException;
}
