package kr.co.redcore.controller.api;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.redcore.GlobalConstants;
import kr.co.redcore.controller.BaseController;
import kr.co.redcore.domain.Tbl_cate_mst;
import kr.co.redcore.domain.Tbl_cate_prd;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.domain.api.JsonView;
import kr.co.redcore.domain.api.JsonResult;
import kr.co.redcore.service.CategoryService;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.util.string.ConvertUtil;

@Controller
public class InternalApiController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(InternalApiController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/api/internal/regCategory.do")
	public View regCategory(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, ModelMap modelMap, @RequestBody String body) throws Exception {
		JsonResult jsonResult = new JsonResult();

		try {
			logger.debug(">>>> body : " + URLDecoder.decode(body));

			JsonObject root = new JsonParser().parse(URLDecoder.decode(body)).getAsJsonObject();
			String cate_root_flag = root.get("cate_root_flag").getAsString();
			String cate_mst_seq_up = root.get("cate_mst_seq_up").getAsString();
			String cate_mst_seq = root.get("cate_mst_seq").getAsString();
			String cate_name = root.get("cate_name").getAsString();

			Tbl_member tbl_member = loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY);
			if (tbl_member != null) {
				// admin계정으로 login상태일경우에만 카테고리를 등록할 수 있다.
				// 그외 경우에는 실패한다.
				logger.debug(">>>> admin login status is true...!!!! ");

				Tbl_cate_mst tbl_cate_mst = new Tbl_cate_mst();
				if (cate_root_flag.equals("true")) {
					// root 카테고리에 추가
					tbl_cate_mst.setCate_mst_seq_up(0);
					tbl_cate_mst.setCate_name(cate_name);
					tbl_cate_mst.setRegby(tbl_member.getMember_id());
					tbl_cate_mst.setUptby(tbl_member.getMember_id());
				} else {
					// 현재 카테고리에 추가
					tbl_cate_mst.setCate_mst_seq_up(Long.parseLong(cate_mst_seq));
					tbl_cate_mst.setCate_name(cate_name);
					tbl_cate_mst.setRegby(tbl_member.getMember_id());
					tbl_cate_mst.setUptby(tbl_member.getMember_id());
				}

				categoryService.insertTbl_cate_mst(tbl_cate_mst);
				jsonResult.setResult_code(GlobalConstants.API_RESULT_SUCCESS);
			} else {
				jsonResult.setResult_code(GlobalConstants.API_RESULT_FAIL);
			}
		} catch (Exception ex) {
			jsonResult.setResult_code(GlobalConstants.API_RESULT_FAIL);
		} finally {
			modelMap.put(GlobalConstants.API_FORMAT_JSON, ConvertUtil.generateJson(jsonResult));
		}

		return new JsonView();
	}

	@RequestMapping(value = "/api/internal/uptCategory.do")
	public View uptCategory(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, ModelMap modelMap, @RequestBody String body) throws Exception {
		JsonResult jsonResult = new JsonResult();

		try {
			logger.debug(">>>> body : " + URLDecoder.decode(body));

			JsonObject root = new JsonParser().parse(URLDecoder.decode(body)).getAsJsonObject();
			String cate_root_flag = root.get("cate_root_flag").getAsString();
			String cate_mst_seq_up = root.get("cate_mst_seq_up").getAsString();
			String cate_mst_seq = root.get("cate_mst_seq").getAsString();
			String cate_name = root.get("cate_name").getAsString();

			Tbl_member tbl_member = loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY);
			if (tbl_member != null) {
				// admin계정으로 login상태일경우에만 카테고리를 수정할 수 있다.
				// 그외 경우에는 실패한다.
				logger.debug(">>>> admin login status is true...!!!! ");

				categoryService.updateTbl_cate_mstForCate_name(Long.parseLong(cate_mst_seq), cate_name);
				jsonResult.setResult_code(GlobalConstants.API_RESULT_SUCCESS);
			} else {
				jsonResult.setResult_code(GlobalConstants.API_RESULT_FAIL);
			}
		} catch (Exception ex) {
			jsonResult.setResult_code(GlobalConstants.API_RESULT_FAIL);
		} finally {
			modelMap.put(GlobalConstants.API_FORMAT_JSON, ConvertUtil.generateJson(jsonResult));
		}

		return new JsonView();
	}

	@RequestMapping(value = "/api/internal/uptCatePrd.do")
	public View uptCatePrd(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, ModelMap modelMap, @RequestBody String body) throws Exception {
		JsonResult jsonResult = new JsonResult();

		try {
			logger.debug(">>>> body : " + URLDecoder.decode(body));

			ArrayList prdList = new ArrayList();

			JsonObject root = new JsonParser().parse(URLDecoder.decode(body)).getAsJsonObject();
			Long cate_mst_seq = root.get("cate_mst_seq").getAsLong();
			JsonArray jsonPrdList = root.get("prdList").getAsJsonArray();
			for (int i = 0; i < jsonPrdList.size(); i++) {
				JsonObject jsonPrdRow = jsonPrdList.get(i).getAsJsonObject();

				Tbl_cate_prd tbl_cate_prd = new Tbl_cate_prd();
				tbl_cate_prd.setCate_mst_seq(cate_mst_seq);
				tbl_cate_prd.setPrd_mst_seq(jsonPrdRow.get("prd_mst_seq").getAsLong());

				prdList.add(tbl_cate_prd);

				logger.debug(tbl_cate_prd.toString());
			}

			Tbl_member tbl_member = loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY);
			if (tbl_member != null) {
				categoryService.updateTbl_cate_prd(cate_mst_seq, prdList);
				jsonResult.setResult_code(GlobalConstants.API_RESULT_SUCCESS);
			} else {
				jsonResult.setResult_code(GlobalConstants.API_RESULT_FAIL);
			}
		} catch (Exception ex) {
			jsonResult.setResult_code(GlobalConstants.API_RESULT_FAIL);
		} finally {
			modelMap.put(GlobalConstants.API_FORMAT_JSON, ConvertUtil.generateJson(jsonResult));
		}

		return new JsonView();
	}
}
