package kr.co.redcore.mapper.impl;

import java.sql.SQLException;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.redcore.mapper.Tbl_opt_groupMapper;

@Repository
public class Tbl_opt_groupMapperImpl implements Tbl_opt_groupMapper {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List getTbl_opt_groupListByAll() throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Tbl_opt_group.getTbl_opt_groupListByAll");
	}
}
