package kr.co.redcore.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Tbl_cate_mst extends BaseObject {
	private long cate_mst_seq;
	private long cate_mst_seq_up;
	
	@Size( min = 4,  max = 100)
	private String cate_name;
	
	private String regby;
	private String regdate;
	private String uptby;
	private String uptdate;

	public long getCate_mst_seq() {
		return cate_mst_seq;
	}

	public void setCate_mst_seq(long cate_mst_seq) {
		this.cate_mst_seq = cate_mst_seq;
	}

	public long getCate_mst_seq_up() {
		return cate_mst_seq_up;
	}

	public void setCate_mst_seq_up(long cate_mst_seq_up) {
		this.cate_mst_seq_up = cate_mst_seq_up;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
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
