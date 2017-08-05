package kr.co.redcore.domain;

public class Tbl_prd_opt extends BaseObject {
	private long prd_opt_seq;
	private String prd_opt_group_id;
	private long prd_mst_seq;
	private String opt_group_id;
	private String prd_opt_id;
	private String prd_opt_name;
	private float prd_opt_in_price;
	private float prd_opt_sl_price;
	private int orderby;
	private String regby;
	private String regdate;

	public long getPrd_opt_seq() {
		return prd_opt_seq;
	}

	public void setPrd_opt_seq(long prd_opt_seq) {
		this.prd_opt_seq = prd_opt_seq;
	}

	public String getPrd_opt_group_id() {
		return prd_opt_group_id;
	}

	public void setPrd_opt_group_id(String prd_opt_group_id) {
		this.prd_opt_group_id = prd_opt_group_id;
	}

	public long getPrd_mst_seq() {
		return prd_mst_seq;
	}

	public void setPrd_mst_seq(long prd_mst_seq) {
		this.prd_mst_seq = prd_mst_seq;
	}

	public String getOpt_group_id() {
		return opt_group_id;
	}

	public void setOpt_group_id(String opt_group_id) {
		this.opt_group_id = opt_group_id;
	}

	public String getPrd_opt_id() {
		return prd_opt_id;
	}

	public void setPrd_opt_id(String prd_opt_id) {
		this.prd_opt_id = prd_opt_id;
	}

	public String getPrd_opt_name() {
		return prd_opt_name;
	}

	public void setPrd_opt_name(String prd_opt_name) {
		this.prd_opt_name = prd_opt_name;
	}

	public float getPrd_opt_in_price() {
		return prd_opt_in_price;
	}

	public void setPrd_opt_in_price(float prd_opt_in_price) {
		this.prd_opt_in_price = prd_opt_in_price;
	}

	public float getPrd_opt_sl_price() {
		return prd_opt_sl_price;
	}

	public void setPrd_opt_sl_price(float prd_opt_sl_price) {
		this.prd_opt_sl_price = prd_opt_sl_price;
	}

	public int getOrderby() {
		return orderby;
	}

	public void setOrderby(int orderby) {
		this.orderby = orderby;
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
