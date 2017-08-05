package kr.co.redcore.domain;

public class Tbl_auth_num extends BaseObject {
	private long auth_num_seq;
	private String auth_type;
	private String auth_key;
	private String auth_num;
	private String regby;
	private String regdate;

	public long getAuth_num_seq() {
		return auth_num_seq;
	}

	public void setAuth_num_seq(long auth_num_seq) {
		this.auth_num_seq = auth_num_seq;
	}

	public String getAuth_type() {
		return auth_type;
	}

	public void setAuth_type(String auth_type) {
		this.auth_type = auth_type;
	}

	public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}

	public String getAuth_num() {
		return auth_num;
	}

	public void setAuth_num(String auth_num) {
		this.auth_num = auth_num;
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
}
