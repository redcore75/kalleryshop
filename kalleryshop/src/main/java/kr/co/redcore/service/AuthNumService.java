package kr.co.redcore.service;

import java.util.Properties;

import kr.co.redcore.domain.Tbl_auth_num;
import kr.co.redcore.mapper.Tbl_auth_numMapper;
import kr.co.redcore.mapper.Tbl_member_access_logMapper;
import kr.co.redcore.util.UserRand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthNumService {
	private static final Logger logger = LoggerFactory.getLogger(AuthNumService.class);
	
	@Autowired
	private Tbl_auth_numMapper tbl_auth_numMapper;	
	
	@Autowired
	private Properties configProp;	
	
	public boolean checkAuthNum(String auth_type, String auth_key, String auth_num) throws Exception {
		Tbl_auth_num tbl_auth_num = tbl_auth_numMapper.getTbl_auth_numMaxByAuth_keyEtc(auth_key, auth_type);
		if(tbl_auth_num.getAuth_num().equals(auth_num)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getAuthNum(String auth_type, String auth_key) throws Exception {
		String auth_num = UserRand.randString(6, 32);
		
		Tbl_auth_num tbl_auth_num = new Tbl_auth_num();
		tbl_auth_num.setAuth_type(auth_type);
		tbl_auth_num.setAuth_key(auth_key);
		tbl_auth_num.setAuth_num(auth_num);
		tbl_auth_num.setRegby(auth_key);
		tbl_auth_numMapper.insertTbl_auth_num(tbl_auth_num);
		
		return auth_num;
	}
}
