/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.39
 * Generated at: 2017-02-20 23:59:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Map;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Test4_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script language=\"javascript\" src=\"https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//초기화 함수\r\n");
      out.write("function initTmap(){\r\n");
      out.write("    centerLL = new Tmap.LonLat(14145677.4, 4511257.6);\r\n");
      out.write("    map = new Tmap.Map({div:'map_div',\r\n");
      out.write("                        width:'100%', \r\n");
      out.write("                        height:'400px',\r\n");
      out.write("                        transitionEffect:\"resize\",\r\n");
      out.write("                        animation:true\r\n");
      out.write("                    }); \r\n");
      out.write("    searchRoute();\r\n");
      out.write("};\r\n");
      out.write("//경로 정보 로드\r\n");
      out.write("function searchRoute(){\r\n");
      out.write("    var routeFormat = new Tmap.Format.KML({extractStyles:true, extractAttributes:true});\r\n");
      out.write("    var startX = 14129105.461214;\r\n");
      out.write("    var startY = 4517042.1926406;\r\n");
      out.write("    var endX = 14136027.789587;\r\n");
      out.write("    var endY = 4517572.4745242;\r\n");
      out.write("    var urlStr = \"https://apis.skplanetx.com/tmap/routes?version=1&format=xml\";\r\n");
      out.write("    urlStr += \"&startX=\"+startX;\r\n");
      out.write("    urlStr += \"&startY=\"+startY;\r\n");
      out.write("    urlStr += \"&endX=\"+endX;\r\n");
      out.write("    urlStr += \"&endY=\"+endY;\r\n");
      out.write("    urlStr += \"&appKey=********-****-*********-************\";\r\n");
      out.write("    var prtcl = new Tmap.Protocol.HTTP({\r\n");
      out.write("                                        url: urlStr,\r\n");
      out.write("                                        format:routeFormat\r\n");
      out.write("                                        });\r\n");
      out.write("    var routeLayer = new Tmap.Layer.Vector(\"route\", {protocol:prtcl, strategies:[new Tmap.Strategy.Fixed()]});\r\n");
      out.write("    routeLayer.events.register(\"featuresadded\", routeLayer, onDrawnFeatures);\r\n");
      out.write("    map.addLayer(routeLayer);\r\n");
      out.write("}\r\n");
      out.write("//경로 그리기 후 해당영역으로 줌\r\n");
      out.write("function onDrawnFeatures(e){\r\n");
      out.write("    map.zoomToExtent(this.getDataExtent());\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"initTmap()\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"map_div\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
