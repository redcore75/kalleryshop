package kr.co.redcore.domain.api;

import java.io.Serializable;
import org.json.JSONObject;

public class JsonResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private String result_code;
	private String result_msg;
	private Object result_data;

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getResult_msg() {
		return result_msg;
	}

	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}

	public Object getResult_data() {
		return result_data;
	}

	public void setResult_data(Object result_data) {
		this.result_data = result_data;
	}
}
