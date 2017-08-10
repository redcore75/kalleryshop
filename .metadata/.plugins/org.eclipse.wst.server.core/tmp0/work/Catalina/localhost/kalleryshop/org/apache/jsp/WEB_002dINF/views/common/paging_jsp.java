package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.apache.commons.logging.*;
import kr.co.redcore.util.*;

public final class paging_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t<ul>\r\n");

String pageLink = request.getParameter("pageLink");
String pageName = request.getParameter("pageName");
String pageValue = request.getParameter("pageValue");
PageHelper pageHelper = (PageHelper) request.getAttribute("pageHelper");

if (pageHelper.hasPrevBlock()) {
	//out.println("<span class=\"\"><span class=\"\"><a href=\"" + pageLink + "?" + pageName + "=1&" + pageValue + "\" class=\"btn first\">1page</a></span></span>");
	out.println("<span class=\"\"><span><a href=\"" + pageLink + "?" + pageName + "=" + (pageHelper.getStartPage() - 1) + "&" + pageValue + "\" class=\"btn\">◀ "); 
	
      out.write("<spring:message code=\"common.wd.이전\" />");

	out.println("</a></span></span>");
} else {
	//out.println("<a href=\"#\" class=\"btn prev\">이전페이지</a>");
}

for (long i = pageHelper.getStartPage(); i <= pageHelper.getEndPage(); i++) {
	if (i == pageHelper.getCurrPage()) {
		out.println("<a class=\"\"><strong>[" + i + "]</strong></a>");
	} else {
		out.println("<span><a href=\"" + pageLink + "?" + pageName + "=" + i + "&" + pageValue + "\">[" + i + "]</a></span>");
	}
}

if (pageHelper.hasNextBlock()) {
	out.println("<span class=\"\"><span><a href=\"" + pageLink + "?" + pageName + "=" + (pageHelper.getEndPage() + 1) + "&" + pageValue + "\" class=\"btn\">");
	
      out.write("<spring:message code=\"common.wd.이후\" />");

	out.println("▶</a></span></span>");
	//out.println("<a href=\"" + pageLink + "?" + pageName + "=" + (pageHelper.getTotalPage()) + "&" + pageValue + "\" class=\"btn last\">" + pageHelper.getTotalPage() + "page</a>");		
} else {
	//out.println("<a href=\"#\" class=\"btn next\">마지막페이지</a>");
}

      out.write("\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>");
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
}
