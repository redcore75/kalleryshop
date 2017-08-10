package kr.co.redcore.domain.view;

import java.util.ArrayList;
import javax.validation.constraints.Min;
import kr.co.redcore.domain.Tbl_banner;
import kr.co.redcore.domain.Tbl_prd_mst;

public class Vw_banner extends Tbl_banner {
	private String banner_name;

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}
}