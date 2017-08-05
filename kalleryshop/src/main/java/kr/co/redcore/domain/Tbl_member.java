package kr.co.redcore.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class Tbl_member extends BaseObject {
	private long member_seq;

	@Min(value = 0)
	private long member_level_seq;

	@Email
	@Size(min = 4, max = 30)
	private String member_id;

	@Size(min = 2, max = 50)
	private String member_name;

	@Size(min = 4, max = 50)
	private String member_nick_name;

	@Size(min = 4, max = 100)
	private String password;
	private String passrchk;

	@NotBlank
	private String member_type;

	@Email
	@Size(min = 0, max = 30)
	private String email_addr;

	private String mobile_num;

	@NotBlank
	private String birthday;

	private String profile_photo_path;
	private MultipartFile profile_photo_file;

	private long curr_point;// 현재포인트

	private String term_agree1;
	private String term_agree2;
	private String term_agree3;
	private String auth_num;

	private String is_valid;
	private String is_del;
	private String memo;
	private String mac_addr;// 맥어드래스

	private String regby;
	private String regdate;
	private String uptby;
	private String uptdate;

	public long getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(long member_seq) {
		this.member_seq = member_seq;
	}

	public long getMember_level_seq() {
		return member_level_seq;
	}

	public void setMember_level_seq(long member_level_seq) {
		this.member_level_seq = member_level_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_nick_name() {
		return member_nick_name;
	}

	public void setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassrchk() {
		return passrchk;
	}

	public void setPassrchk(String passrchk) {
		this.passrchk = passrchk;
	}

	public String getMember_type() {
		return member_type;
	}

	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	public String getEmail_addr() {
		return email_addr;
	}

	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}

	public String getMobile_num() {
		return mobile_num;
	}

	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getProfile_photo_path() {
		return profile_photo_path;
	}

	public void setProfile_photo_path(String profile_photo_path) {
		this.profile_photo_path = profile_photo_path;
	}

	public MultipartFile getProfile_photo_file() {
		return profile_photo_file;
	}

	public void setProfile_photo_file(MultipartFile profile_photo_file) {
		this.profile_photo_file = profile_photo_file;
	}

	public long getCurr_point() {
		return curr_point;
	}

	public void setCurr_point(long curr_point) {
		this.curr_point = curr_point;
	}

	public String getTerm_agree1() {
		return term_agree1;
	}

	public void setTerm_agree1(String term_agree1) {
		this.term_agree1 = term_agree1;
	}

	public String getTerm_agree2() {
		return term_agree2;
	}

	public void setTerm_agree2(String term_agree2) {
		this.term_agree2 = term_agree2;
	}

	public String getTerm_agree3() {
		return term_agree3;
	}

	public void setTerm_agree3(String term_agree3) {
		this.term_agree3 = term_agree3;
	}

	public String getAuth_num() {
		return auth_num;
	}

	public void setAuth_num(String auth_num) {
		this.auth_num = auth_num;
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

	public String getMac_addr() {
		return mac_addr;
	}

	public void setMac_addr(String mac_addr) {
		this.mac_addr = mac_addr;
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
