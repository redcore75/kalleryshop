package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.redcore.domain.Tbl_cate_mst;
import kr.co.redcore.util.ParamMap;

public interface Tbl_cate_mstMapper {
	public Tbl_cate_mst getTbl_cate_mstByCate_mst_seq(long cate_mst_seq)throws SQLException;	
	public List getJsTreeTypeListByAll() throws SQLException;
	public List getTbl_cate_mstListByTop()  throws SQLException;
	public List getTbl_cate_mstListByAll() throws SQLException;	
	public List getVw_cate_mstListByPrd_mst_seq(long prd_mst_seq) throws SQLException;
	public int insertTbl_cate_mst(Tbl_cate_mst tbl_cate_mst) throws SQLException;
	public int updateTbl_cate_mstForCate_name(long cate_mst_seq, String cate_name) throws SQLException;
}
