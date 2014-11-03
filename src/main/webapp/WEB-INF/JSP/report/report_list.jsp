<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/mytaglib" prefix="pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>达内－NetCTOSS</title>
	<link type="text/css" rel="stylesheet" media="all" href="${path }/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="${path }/styles/global_color.css" /> 
    <script type="text/javascript" src="${path }/js/jquery.js"></script>
	<script language="javascript" type="text/javascript">
		$(function(){
			tab_on();
			//分页--换页时携带查询的参数
        	$("#pages a[href]").click(function(){
        		$("form").attr("action",this.href);
        		$("form").submit();
        		return false;
        	});
		});
		function selectTable(num){
			$("form input").val(num);
			$("form").attr("action","${base}/report/index").submit();
		}
		function tab_on(){
			var $obj = $(".tabs ul a");
			var flag = '${flag}';
			if(flag == '02'){
				$obj.get(1).className = "tab_on";
			}else if(flag == '03'){
				$obj.get(2).className = "tab_on";
			}else{
				$obj.get(0).className = "tab_on";
			}
		}
	</script>
</head>
<body>
	<!--Logo区域开始--><%@include file="/WEB-INF/JSP/logo.jsp" %><!--Logo区域结束-->
    <!--导航区域开始--><div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp" %></div><!--导航区域结束-->
    
	<!--主要区域开始-->        
	<div id="report_main">
		<form method="post"><input type="hidden" name="flag" value="${flag}"/></form>
		<div class="tabs">
			<ul>
				<li><a href="javascript:selectTable('01');" class="tab_out" title="每位客户每月的累计时长">客户使用时长</a></li>
				<li><a href="javascript:selectTable('02');" class="tab_out" title="每台服务器上累计时长最高的前三名客户">时长排行榜</a></li>
				<li><a href="javascript:selectTable('03');" class="tab_out" title="每台服务器每种资费标准的使用次数">资费使用率</a></li>
			</ul>
		</div>            
		<div class="report_box">
			<!--数据区域：用表格展示数据-->
			<div id="report_data">
				<s:if test="flag==02"><%@include file="/WEB-INF/JSP/report/report_list_tab02.jsp" %></s:if>
				<s:elseif test="flag=='03'"><%@include file="/WEB-INF/JSP/report/report_list_tab03.jsp" %></s:elseif>
				<s:else><%@include file="/WEB-INF/JSP/report/report_list_tab01.jsp" %></s:else>
			</div>
		<!--分页-->
		<pager:pager pager="${pager}"/>
        </div>
    </div>
	<!--主要区域结束-->
	<div id="footer">
        <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
        <p>版权所有(C)加拿大达内IT培训集团公司 </p>
    </div>
    </body>
</html>
