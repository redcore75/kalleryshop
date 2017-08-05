package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.redcore.domain.Tbl_cate_prd;
import kr.co.redcore.util.ParamMap;

public interface Tbl_cate_prdMapper {
	public List getTbl_cate_prdListByPrd_mst_seq(long prd_mst_seq) throws Exception;
	public int insertTbl_cate_prd(Tbl_cate_prd tbl_cate_prd) throws SQLException;
	public int deleteTbl_cate_prdByCate_mst_seq(long cate_mst_seq) throws SQLException;
	public int deleteTbl_cate_prdByPrd_mst_seq(long prd_mst_seq) throws SQLException;
}
