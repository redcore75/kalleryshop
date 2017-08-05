package kr.co.redcore.domain;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class Tbl_banner extends BaseObject {
	private long banner_seq;

	@NotBlank
	private long banner_mgr_seq;

	private String url_addr;
	private String text_data;
	private String img_path;
	private String is_valid;
	private String regby;
	private String regdate;
	private String uptby;
	private String uptdate;

	public long getBanner_seq() {
		return banner_seq;
	}

	public void setBanner_seq(long banner_seq) {
		this.banner_seq = banner_seq;
	}

	public long getBanner_mgr_seq() {
		return banner_mgr_seq;
	}

	public void setBanner_mgr_seq(long banner_mgr_seq) {
		this.banner_mgr_seq = banner_mgr_seq;
	}

	public String getUrl_addr() {
		return url_addr;
	}

	public void setUrl_addr(String url_addr) {
		this.url_addr = url_addr;
	}

	public String getText_data() {
		return text_data;
	}

	public void setText_data(String text_data) {
		this.text_data = text_data;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
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
