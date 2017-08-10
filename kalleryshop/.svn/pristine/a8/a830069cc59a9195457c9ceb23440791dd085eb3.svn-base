package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.redcore.domain.Tbl_banner;
import kr.co.redcore.domain.view.Vw_banner;
import kr.co.redcore.util.ParamMap;

public interface Tbl_bannerMapper {
	public Vw_banner getVw_bannerByBanner_seq(long banner_seq) throws SQLException;
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException;
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException;
	public int insertTbl_banner(Tbl_banner tbl_banner) throws SQLException;
	public int updateTbl_banner(Tbl_banner tbl_banner) throws SQLException;
}
