package kr.co.redcore.domain;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class Tbl_banner_mgr extends BaseObject {
	private long banner_mgr_seq;

	@NotBlank
	private String banner_name;

	@NotBlank
	private String banner_type;

	@Size(min = 0, max = 200)
	private int wait_time;

	private String is_valid;
	private String regby;
	private String regdate;
	private String uptby;
	private String uptdate;

	public long getBanner_mgr_seq() {
		return banner_mgr_seq;
	}

	public void setBanner_mgr_seq(long banner_mgr_seq) {
		this.banner_mgr_seq = banner_mgr_seq;
	}

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}

	public String getBanner_type() {
		return banner_type;
	}

	public void setBanner_type(String banner_type) {
		this.banner_type = banner_type;
	}

	public int getWait_time() {
		return wait_time;
	}

	public void setWait_time(int wait_time) {
		this.wait_time = wait_time;
	}

	public String getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
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
