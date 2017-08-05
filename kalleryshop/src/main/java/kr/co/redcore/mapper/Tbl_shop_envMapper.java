package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;
import kr.co.redcore.domain.Tbl_prd_opt;
import kr.co.redcore.domain.Tbl_shop_env;

public interface Tbl_shop_envMapper {
	public long getTbl_shop_envCntByShop_id(String shop_id) throws SQLException;
	public Tbl_shop_env getTbl_shop_envByShop_id(String shop_id) throws SQLException;
	public long insertTbl_shop_env(Tbl_shop_env tbl_shop_env) throws SQLException;
	public long updateTbl_shop_env(Tbl_shop_env tbl_shop_env) throws SQLException;
}
