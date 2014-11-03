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
		
	</script>
</head>

<body>
	<!--Logo区域开始--><%@include file="/WEB-INF/JSP/logo.jsp" %><!--Logo区域结束-->
    <!--导航区域开始--><div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp" %></div><!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
		<div class="search_add">                        
			<div>账务账号： <span class="readonly width70">${bill.account.id }</span></div>                            
			<div>身份证：<span class="readonly width150">${bill.account.idcardNo }</span></div>
			<div>姓名：<span class="readonly width70">${bill.account.realName }</span></div>
			<div>计费时间：<span class="readonly width70"><s:property value="bill.billMonth.substring(0,4)+'年'+bill.billMonth.substring(4,6)+'月'"/></span></div>
			<div>总费用：<span class="readonly width70">${bill.cost }元</span></div>
			<input type="button" value="返回" class="btn_add" onclick="location='${base}/bill/index'"/>
		</div>  
                
		<!--数据区域：用表格展示数据-->     
		<div id="data">            
			<table id="datalist">
				<tr>
					<th class="width70">账单明细ID</th>
					<th class="width150">OS 账号</th>
					<th class="width150">服务器 IP</th>
					<th class="width70">账务账号ID</th>
					<th class="width150">时长</th>
					<th>费用</th>
					<th class="width150">资费</th>
					<th class="width50"></th>
				</tr>
				<s:iterator value="billItemPager.list">
				<tr>
					<td>${id}</td>
	                <td>${osUsername}</td>
	                <td>${hostId}</td>
	                <td>${accountId}</td>
	                <td>
	                	<s:property value="duration/3600"/>小时
	                	<s:property value="duration%60/60"/>分
	                	<s:property value="duration%3600"/>秒
	                </td>
	                <td>${cost}元</td>
	                <td>${costName}</td>
	                <td><a href="${base}/bill/serviceDetail?billItemId=${id}" title="业务详单">详单</a></td>
	            </tr>
				</s:iterator>
			</table>
		</div>
		<!--分页-->
		<pager:pager pager="${billItemPager}"/>
	</div>
    <!--主要区域结束-->
    <div id="footer">
        <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
        <p>版权所有(C)加拿大达内IT培训集团公司 </p>
    </div>
</body>
</html>
