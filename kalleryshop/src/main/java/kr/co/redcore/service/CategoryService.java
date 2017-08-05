package kr.co.redcore.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.redcore.domain.Tbl_cate_mst;
import kr.co.redcore.domain.Tbl_cate_prd;
import kr.co.redcore.mapper.Tbl_cate_mstMapper;
import kr.co.redcore.mapper.Tbl_cate_prdMapper;

@Service
public class CategoryService {
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private Tbl_cate_mstMapper tbl_cate_mstMapper;

	@Autowired
	private Tbl_cate_prdMapper tbl_cate_prdMapper;	
	
	public List getJsTreeTypeListByAll() throws Exception {
		return tbl_cate_mstMapper.getJsTreeTypeListByAll();
	}		
	
	public List getTbl_cate_mstListByAll() throws Exception {
		return tbl_cate_mstMapper.getTbl_cate_mstListByAll();
	}
	
	public List getVw_cate_mstListByPrd_mst_seq(long prd_mst_seq) throws Exception {
		return tbl_cate_mstMapper.getVw_cate_mstListByPrd_mst_seq(prd_mst_seq);
	}
	
	public List getTbl_cate_prdListByPrd_mst_seq(long prd_mst_seq) throws Exception {
		return tbl_cate_prdMapper.getTbl_cate_prdListByPrd_mst_seq(prd_mst_seq);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int insertTbl_cate_mst(Tbl_cate_mst tbl_cate_mst) throws Exception {
		return tbl_cate_mstMapper.insertTbl_cate_mst(tbl_cate_mst);		
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateTbl_cate_mstForCate_name(long cate_mst_seq, String cate_name) throws Exception {
		return tbl_cate_mstMapper.updateTbl_cate_mstForCate_name(cate_mst_seq, cate_name);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int updateTbl_cate_prd(long cate_mst_seq, ArrayList prdList) throws Exception {
		int retVal = tbl_cate_prdMapper.deleteTbl_cate_prdByCate_mst_seq(cate_mst_seq);
		
		for(int i = 0; i < prdList.size(); i++) {
			Tbl_cate_prd tbl_cate_prd = (Tbl_cate_prd)prdList.get(i);
			retVal = tbl_cate_prdMapper.insertTbl_cate_prd(tbl_cate_prd);
		}
		
		return retVal;
	}
}
