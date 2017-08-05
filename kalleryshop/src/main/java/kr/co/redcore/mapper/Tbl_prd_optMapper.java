package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.redcore.domain.Tbl_prd_opt;

public interface Tbl_prd_optMapper {
	public List getTbl_prd_optLastListByPrd_mst_seq(long prd_mst_seq) throws SQLException;
	public long insertTbl_prd_opt(Tbl_prd_opt tbl_prd_opt) throws SQLException;
}
