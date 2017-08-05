package kr.co.redcore.mapper;

import java.sql.SQLException;
import kr.co.redcore.domain.Tbl_prd_detail;

public interface Tbl_prd_detailMapper {
	public Tbl_prd_detail getTbl_prd_detailLastByPrd_mst_seq(long prd_mst_seq) throws SQLException;
	public int insertTbl_prd_detail(Tbl_prd_detail tbl_prd_detail) throws SQLException;	
}
