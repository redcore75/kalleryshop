package org.apache.jsp.WEB_002dINF.views.decorators.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.slf4j.*;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.domain.*;
import kr.co.redcore.domain.view.*;
import kr.co.redcore.service.*;
import kr.co.redcore.util.*;
import kr.co.redcore.util.string.*;

public final class mainLayer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(2);
    _jspx_dependants.add("/WEB-INF/views/common/common.jsp");
    _jspx_dependants.add("/WEB-INF/tld/redcore-tags.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody.release();
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.release();
    _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


	pageContext.setAttribute("newline", "\n");

      if (_jspx_meth_spring_005fhtmlEscape_005f0(_jspx_page_context))
        return;

// 모바일에서 접근중인지 체크
int isMobile = 0;
String userAgent = request.getHeader("USER-AGENT");
String[] mobileOsType = {"iPhone", "iPod", "Android", "BlackBerry", "Windows CE", "Nokia", "Webos", "Opera Mini", "SonyEricsson", "Opera Mobi", "IEMobile"};

for (int i = 0, j = -1; i < mobileOsType.length; i++) {
	if (userAgent.indexOf(mobileOsType[i]) > -1) {
		// 모바일로 접근했을 때
		request.setAttribute("isMobile", isMobile);
		break;
	}
}


response.setContentType("text/html; charset=UTF-8"); 
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\r\n");
      out.write("\t<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\"/>\r\n");
      out.write("\t<meta http-equiv=Cache-Control content=No-Cache>\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css\" />\t\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/css/bootstrap.min.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/css/AdminLTE.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/css/skins/_all-skins.min.css\"/>\t\r\n");
      out.write("\t<!-- <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/css/bootstrap-theme.min.css\"/>  -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/plugins/datepicker/datepicker3.css\"/>\t\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/css/common.css\"/>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("\t<script src=\"https://code.jquery.com/ui/1.11.4/jquery-ui.min.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js\"></script>\r\n");
      out.write("\t<script src=\"http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.js\"></script>\t\r\n");
      out.write("\t<script src=\"http://cdn.rawgit.com/placemarker/jQuery-MD5/master/jquery.md5.js\"></script>\t\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/plugins/datepicker/bootstrap-datepicker.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/plugins/datepicker/locales/bootstrap-datepicker.kr.js\"></script>    \r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/admin/js/common.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t// readonly 에서 백스페이스 무시.\r\n");
      out.write("\t\t\t$(\"input[readonly]\").keydown(function(event) {\r\n");
      out.write("\t\t\t\tif ( event.keyCode === 8 ) {\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\".datepicker\").datepicker({\r\n");
      out.write("\t\t\t\tlanguage: \"kr\",\r\n");
      out.write("\t\t\t\tformat: \"yyyymmdd\",\r\n");
      out.write("\t\t\t\tautoclose: true\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      if (_jspx_meth_decorator_005fhead_005f0(_jspx_page_context))
        return;
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- START:TOP Area -->\r\n");
      out.write("\t");
      if (_jspx_meth_page_005fapplyDecorator_005f0(_jspx_page_context))
        return;
      out.write("<!-- END:TOP Area -->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- START:MAIN Area -->\r\n");
      out.write("\t");
      if (_jspx_meth_decorator_005fbody_005f0(_jspx_page_context))
        return;
      out.write("<!-- END:MAIN Area -->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- START:BOTTOM Area -->\r\n");
      out.write("\t");
      if (_jspx_meth_page_005fapplyDecorator_005f1(_jspx_page_context))
        return;
      out.write("<!-- END:BOTTOM Area -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_005fhtmlEscape_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:htmlEscape
    org.springframework.web.servlet.tags.HtmlEscapeTag _jspx_th_spring_005fhtmlEscape_005f0 = (org.springframework.web.servlet.tags.HtmlEscapeTag) _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody.get(org.springframework.web.servlet.tags.HtmlEscapeTag.class);
    _jspx_th_spring_005fhtmlEscape_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fhtmlEscape_005f0.setParent(null);
    // /WEB-INF/views/common/common.jsp(23,0) name = defaultHtmlEscape type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fhtmlEscape_005f0.setDefaultHtmlEscape("true");
    int[] _jspx_push_body_count_spring_005fhtmlEscape_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fhtmlEscape_005f0 = _jspx_th_spring_005fhtmlEscape_005f0.doStartTag();
      if (_jspx_th_spring_005fhtmlEscape_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fhtmlEscape_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fhtmlEscape_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fhtmlEscape_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fhtmlEscape_0026_005fdefaultHtmlEscape_005fnobody.reuse(_jspx_th_spring_005fhtmlEscape_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_decorator_005fhead_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  decorator:head
    com.opensymphony.module.sitemesh.taglib.decorator.HeadTag _jspx_th_decorator_005fhead_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.HeadTag) _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.HeadTag.class);
    _jspx_th_decorator_005fhead_005f0.setPageContext(_jspx_page_context);
    _jspx_th_decorator_005fhead_005f0.setParent(null);
    int _jspx_eval_decorator_005fhead_005f0 = _jspx_th_decorator_005fhead_005f0.doStartTag();
    if (_jspx_th_decorator_005fhead_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.reuse(_jspx_th_decorator_005fhead_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.reuse(_jspx_th_decorator_005fhead_005f0);
    return false;
  }

  private boolean _jspx_meth_page_005fapplyDecorator_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  page:applyDecorator
    com.opensymphony.module.sitemesh.taglib.page.ApplyDecoratorTag _jspx_th_page_005fapplyDecorator_005f0 = (com.opensymphony.module.sitemesh.taglib.page.ApplyDecoratorTag) _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody.get(com.opensymphony.module.sitemesh.taglib.page.ApplyDecoratorTag.class);
    _jspx_th_page_005fapplyDecorator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_page_005fapplyDecorator_005f0.setParent(null);
    // /WEB-INF/views/decorators/admin/mainLayer.jsp(59,1) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_page_005fapplyDecorator_005f0.setName("admin_top");
    int _jspx_eval_page_005fapplyDecorator_005f0 = _jspx_th_page_005fapplyDecorator_005f0.doStartTag();
    if (_jspx_th_page_005fapplyDecorator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody.reuse(_jspx_th_page_005fapplyDecorator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody.reuse(_jspx_th_page_005fapplyDecorator_005f0);
    return false;
  }

  private boolean _jspx_meth_decorator_005fbody_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  decorator:body
    com.opensymphony.module.sitemesh.taglib.decorator.BodyTag _jspx_th_decorator_005fbody_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.BodyTag) _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.BodyTag.class);
    _jspx_th_decorator_005fbody_005f0.setPageContext(_jspx_page_context);
    _jspx_th_decorator_005fbody_005f0.setParent(null);
    int _jspx_eval_decorator_005fbody_005f0 = _jspx_th_decorator_005fbody_005f0.doStartTag();
    if (_jspx_th_decorator_005fbody_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.reuse(_jspx_th_decorator_005fbody_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.reuse(_jspx_th_decorator_005fbody_005f0);
    return false;
  }

  private boolean _jspx_meth_page_005fapplyDecorator_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  page:applyDecorator
    com.opensymphony.module.sitemesh.taglib.page.ApplyDecoratorTag _jspx_th_page_005fapplyDecorator_005f1 = (com.opensymphony.module.sitemesh.taglib.page.ApplyDecoratorTag) _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody.get(com.opensymphony.module.sitemesh.taglib.page.ApplyDecoratorTag.class);
    _jspx_th_page_005fapplyDecorator_005f1.setPageContext(_jspx_page_context);
    _jspx_th_page_005fapplyDecorator_005f1.setParent(null);
    // /WEB-INF/views/decorators/admin/mainLayer.jsp(67,1) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_page_005fapplyDecorator_005f1.setName("admin_bottom");
    int _jspx_eval_page_005fapplyDecorator_005f1 = _jspx_th_page_005fapplyDecorator_005f1.doStartTag();
    if (_jspx_th_page_005fapplyDecorator_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody.reuse(_jspx_th_page_005fapplyDecorator_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fpage_005fapplyDecorator_0026_005fname_005fnobody.reuse(_jspx_th_page_005fapplyDecorator_005f1);
    return false;
  }
}
