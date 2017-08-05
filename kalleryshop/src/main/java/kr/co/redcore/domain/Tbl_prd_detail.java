package kr.co.redcore.domain;

public class Tbl_prd_detail extends BaseObject {
	private long prd_detail_seq;
	private long prd_mst_seq;
	private float prd_in_price;
	private float prd_mk_price;
	private float prd_sl_price;
	private String regby;
	private String regdate;

	public long getPrd_detail_seq() {
		return prd_detail_seq;
	}

	public void setPrd_detail_seq(long prd_detail_seq) {
		this.prd_detail_seq = prd_detail_seq;
	}

	public long getPrd_mst_seq() {
		return prd_mst_seq;
	}

	public void setPrd_mst_seq(long prd_mst_seq) {
		this.prd_mst_seq = prd_mst_seq;
	}

	public float getPrd_in_price() {
		return prd_in_price;
	}

	public void setPrd_in_price(float prd_in_price) {
		this.prd_in_price = prd_in_price;
	}

	public float getPrd_mk_price() {
		return prd_mk_price;
	}

	public void setPrd_mk_price(float prd_mk_price) {
		this.prd_mk_price = prd_mk_price;
	}

	public float getPrd_sl_price() {
		return prd_sl_price;
	}

	public void setPrd_sl_price(float prd_sl_price) {
		this.prd_sl_price = prd_sl_price;
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
