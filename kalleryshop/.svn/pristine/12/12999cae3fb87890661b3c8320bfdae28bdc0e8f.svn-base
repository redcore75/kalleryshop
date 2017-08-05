package kr.co.redcore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.redcore.domain.Tbl_shop_env;
import kr.co.redcore.mapper.Tbl_shop_envMapper;

@Service
public class ShopEnvService {
	private static final Logger logger = LoggerFactory.getLogger(ShopEnvService.class);

	@Autowired
	private Tbl_shop_envMapper tbl_shop_envMapper;
		
	public long getTbl_shop_envCntByShop_id(String shop_id) throws Exception {
		return tbl_shop_envMapper.getTbl_shop_envCntByShop_id(shop_id);
	}
	
	public Tbl_shop_env getTbl_shop_envByShop_id(String shop_id) throws Exception {
		return tbl_shop_envMapper.getTbl_shop_envByShop_id(shop_id);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public long updateTbl_shop_env(Tbl_shop_env tbl_shop_env) throws Exception {
		long shopCnt = tbl_shop_envMapper.getTbl_shop_envCntByShop_id(tbl_shop_env.getShop_id());
		if(shopCnt <= 0) {
			// 아이디가 없을 경우
			return tbl_shop_envMapper.insertTbl_shop_env(tbl_shop_env);
		} else {
			return tbl_shop_envMapper.updateTbl_shop_env(tbl_shop_env);
		}
	}
}
