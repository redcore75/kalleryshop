package kr.co.redcore.domain;

import org.hibernate.validator.constraints.NotBlank;

public class Tbl_common_code_group extends BaseObject {
	@NotBlank
	private String code_group_id;

	private String lang_code;

	@NotBlank
	private String code_group_name;

	@NotBlank
	private String is_valid;
	private String is_del;
	private String memo;
	private String regby;
	private String regdate;
	private String uptby;
	private String uptdate;

	public String getCode_group_id() {
		return code_group_id;
	}

	public void setCode_group_id(String code_group_id) {
		this.code_group_id = code_group_id;
	}

	public String getLang_code() {
		return lang_code;
	}

	public void setLang_code(String lang_code) {
		this.lang_code = lang_code;
	}

	public String getCode_group_name() {
		return code_group_name;
	}

	public void setCode_group_name(String code_group_name) {
		this.code_group_name = code_group_name;
	}

	public String getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}

	public String getIs_del() {
		return is_del;
	}

	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
