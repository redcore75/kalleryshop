package kr.co.redcore.domain;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Tbl_member_point extends BaseObject {
	private long member_point_seq;
	private long member_seq;
	private String use_type;
	private long use_point;
	private long prev_point;
	private long curr_point;
	private String regby;
	private String regdate;

	public long getMember_point_seq() {
		return member_point_seq;
	}

	public void setMember_point_seq(long member_point_seq) {
		this.member_point_seq = member_point_seq;
	}

	public long getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(long member_seq) {
		this.member_seq = member_seq;
	}

	public String getUse_type() {
		return use_type;
	}

	public void setUse_type(String use_type) {
		this.use_type = use_type;
	}

	public long getUse_point() {
		return use_point;
	}

	public void setUse_point(long use_point) {
		this.use_point = use_point;
	}

	public long getPrev_point() {
		return prev_point;
	}

	public void setPrev_point(long prev_point) {
		this.prev_point = prev_point;
	}

	public long getCurr_point() {
		return curr_point;
	}

	public void setCurr_point(long curr_point) {
		this.curr_point = curr_point;
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
