package kr.co.redcore.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Tbl_shop_env extends BaseObject {
	@NotBlank
	private String shop_id;
	private String shop_name;
	private String shop_title;
	private String shop_lic_num;
	private String cp_name;
	private String cp_biz_num;
	private String cp_ceo_name;
	private String cp_biz_type;
	private String cp_biz_part;
	
	@Email
	private String cp_ceo_email_addr;
	private String cp_zipcode;
	private String cp_address1;
	private String cp_address2;
	private String cp_phone_num;
	private String cp_fax_num;
	private String cp_intro_txt;
	private String cs_phone_num;
	private String cs_fax_num;
	
	@Email
	private String cs_email_addr;
	private String cs_oper_dtime;
	private String regby;
	private String regdate;
	private String uptby;
	private String uptdate;

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_title() {
		return shop_title;
	}

	public void setShop_title(String shop_title) {
		this.shop_title = shop_title;
	}

	public String getShop_lic_num() {
		return shop_lic_num;
	}

	public void setShop_lic_num(String shop_lic_num) {
		this.shop_lic_num = shop_lic_num;
	}

	public String getCp_name() {
		return cp_name;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public String getCp_biz_num() {
		return cp_biz_num;
	}

	public void setCp_biz_num(String cp_biz_num) {
		this.cp_biz_num = cp_biz_num;
	}

	public String getCp_ceo_name() {
		return cp_ceo_name;
	}

	public void setCp_ceo_name(String cp_ceo_name) {
		this.cp_ceo_name = cp_ceo_name;
	}

	public String getCp_biz_type() {
		return cp_biz_type;
	}

	public void setCp_biz_type(String cp_biz_type) {
		this.cp_biz_type = cp_biz_type;
	}

	public String getCp_biz_part() {
		return cp_biz_part;
	}

	public void setCp_biz_part(String cp_biz_part) {
		this.cp_biz_part = cp_biz_part;
	}

	public String getCp_ceo_email_addr() {
		return cp_ceo_email_addr;
	}

	public void setCp_ceo_email_addr(String cp_ceo_email_addr) {
		this.cp_ceo_email_addr = cp_ceo_email_addr;
	}

	public String getCp_zipcode() {
		return cp_zipcode;
	}

	public void setCp_zipcode(String cp_zipcode) {
		this.cp_zipcode = cp_zipcode;
	}

	public String getCp_address1() {
		return cp_address1;
	}

	public void setCp_address1(String cp_address1) {
		this.cp_address1 = cp_address1;
	}

	public String getCp_address2() {
		return cp_address2;
	}

	public void setCp_address2(String cp_address2) {
		this.cp_address2 = cp_address2;
	}

	public String getCp_phone_num() {
		return cp_phone_num;
	}

	public void setCp_phone_num(String cp_phone_num) {
		this.cp_phone_num = cp_phone_num;
	}

	public String getCp_fax_num() {
		return cp_fax_num;
	}

	public void setCp_fax_num(String cp_fax_num) {
		this.cp_fax_num = cp_fax_num;
	}

	public String getCp_intro_txt() {
		return cp_intro_txt;
	}

	public void setCp_intro_txt(String cp_intro_txt) {
		this.cp_intro_txt = cp_intro_txt;
	}

	public String getCs_phone_num() {
		return cs_phone_num;
	}

	public void setCs_phone_num(String cs_phone_num) {
		this.cs_phone_num = cs_phone_num;
	}

	public String getCs_fax_num() {
		return cs_fax_num;
	}

	public void setCs_fax_num(String cs_fax_num) {
		this.cs_fax_num = cs_fax_num;
	}

	public String getCs_email_addr() {
		return cs_email_addr;
	}

	public void setCs_email_addr(String cs_email_addr) {
		this.cs_email_addr = cs_email_addr;
	}

	public String getCs_oper_dtime() {
		return cs_oper_dtime;
	}

	public void setCs_oper_dtime(String cs_oper_dtime) {
		this.cs_oper_dtime = cs_oper_dtime;
	}

	public String getRegby() {
		return regby;
	}

	public void setRegby(String regby) {
		this.regby = regby;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUptby() {
		return uptby;
	}

	public void setUptby(String uptby) {
		this.uptby = uptby;
	}

	public String getUptdate() {
		return uptdate;
	}

	public void setUptdate(String uptdate) {
		this.uptdate = uptdate;
	}
}
