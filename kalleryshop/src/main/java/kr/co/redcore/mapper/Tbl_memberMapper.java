package kr.co.redcore.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.util.ParamMap;

public interface Tbl_memberMapper {
	public long getTbl_memberCntByMember_id(String member_id) throws SQLException;
	public long getTbl_memberCntByMember_nick_name(String member_nick_name) throws SQLException;
	public long getTbl_memberCntByMember_idEtc(String member_id, String member_type) throws SQLException;
	public Tbl_member getTbl_memberByMember_id(String member_id) throws SQLException;
	public Tbl_member getTbl_memberByMember_idEtc(String member_id, String password) throws SQLException;
	public long getPageHelperCntByParamMap(ParamMap paramMap) throws SQLException;
	public List getPageHelperListByParamMapEtc(long start, long size, ParamMap paramMap) throws SQLException;
	public int insertTbl_member(Tbl_member tbl_member) throws SQLException;
	public int updateTbl_member(Tbl_member tbl_member) throws SQLException;
	public int updateTbl_memberForInfo(Tbl_member tbl_member) throws SQLException;
	public int updateTbl_memberForPassword(String member_id, String password) throws SQLException;
	public int updateTbl_memberForCurr_point(String member_id, long curr_point) throws SQLException;
}
