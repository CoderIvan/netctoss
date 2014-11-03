<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/mytaglib" prefix="pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>达内－NetCTOSS</title>
	<link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css" />
	<link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css" />
	<script type="text/javascript" src="${base}/js/jquery.js"></script>
	<script type="text/javascript" src="${base}/js/validation.js"></script>
	<script type="text/javascript">
		$(function(){
			//分页--换页时携带查询的参数
			$("#pages a[href]").click(function(){
				this.href += "&billItemId=${billItem.id}";
			});
		});
	</script>
</head>

<body>
	<!--Logo区域开始-->
	<%@include file="/WEB-INF/JSP/logo.jsp" %>
	<!--Logo区域结束-->
	<!--导航区域开始-->
	<div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp" %></div>
	<!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
		<!--查询-->
		<div class="search_add">                        
			<div>账务账号：<span class="readonly width70">${bill.account.loginName }</span></div>
			<div>OS 账号：<span class="readonly width100">${billItem.osUsername }</span></div>
			<div>服务器 IP：<span class="readonly width100">${billItem.hostId }</span></div>
			<div>计费时间：<span class="readonly width70"><s:property value="bill.billMonth.substring(0,4)+'年'+bill.billMonth.substring(4,6)+'月'"/></span></div>
			<div>费用：<span class="readonly width70">${billItem.cost }</span></div>
			<input type="button" value="返回" class="btn_add" onclick="location='${base}/bill/billItem?billId=${bill.id}';" />
		</div>  
		<!--数据区域：用表格展示数据-->
		<div id="data">            
			<table id="datalist">
		        <tr>
		            <th class="width150">客户登录 IP</th>
		            <th class="width150">登入时刻</th>
		            <th class="width150">登出时刻</th>
		            <th class="width100">时长（秒）</th>
		            <th class="width150">费用</th>
		            <th>资费</th>
		        </tr>
		        <s:iterator value="serviceDetailPager.list">
				<tr>
					<td><s:property value="clientHost"/></td>
					<td><s:date name="loginTime" format="yyyy/MM/dd hh:mm:ss"/></td>
					<td><s:date name="logoutTime" format="yyyy/MM/dd hh:mm:ss"/></td>
					<td>
						<s:property value="duration/3600"/>小时
						<s:property value="duration%60/60"/>分
						<s:property value="duration%3600"/>秒
					</td>
					<td><s:property value="cost"/>元</td>
					<td><s:property value="costName"/></td>
				</tr>
				</s:iterator>
			</table>
		</div>
		<!--分页-->
		<pager:pager pager="${serviceDetailPager}"/>
    </div>
    <!--主要区域结束-->
    <div id="footer">
        <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
        <p>版权所有(C)加拿大达内IT培训集团公司 </p>
    </div>
</body>
</html>
