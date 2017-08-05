package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.redcore.domain.Tbl_prd_mst;
import kr.co.redcore.domain.view.Vw_prd_mst;
import kr.co.redcore.util.ParamMap;

public interface Tbl_prd_mstMapper {
	public Vw_prd_mst getVw_prd_mstByPrd_mst_seq(long prd_mst_seq) throws SQLException;
	public List getVw_prd_mstLastListByCate_mst_seq(long cate_mst_seq) throws SQLException;
	public List getVw_prd_mstLastListExtMinusByCate_mst_seqEtc(long cate_mst_seq, String prd_name) throws SQLException;
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException;
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException;
	public long insertTbl_prd_mst(Tbl_prd_mst tbl_prd_mst) throws SQLException;
	public long updateTbl_prd_mst(Tbl_prd_mst tbl_prd_mst) throws SQLException;
}
