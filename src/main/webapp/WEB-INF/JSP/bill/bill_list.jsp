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
	<script language="javascript" type="text/javascript">
     //写入下拉框中的年份和月份
     function initialYearAndMonth() {
         //写入最近3年
         var yearObj = document.mainForm.year;
         var year = (new Date()).getFullYear();
         for (var i = 0; i <= 2; i++) {
             var opObj = new Option(year - i, year - i);
             yearObj.options[i] = opObj;
         }
         //写入 12 月
         var monthObj = document.mainForm.month;
         var opObj = new Option("全部", "全部");
         monthObj.options[0] = opObj;
         for (var i = 1; i <= 12; i++) {
         	var k = i<10 ? "0"+i : i;
             var opObj = new Option(k, k);
             monthObj.options[i] = opObj;
         }
         
         var currYear = '${year}';
         if(currYear != null && currYear != ""){
        	 $(yearObj).val(currYear);
         }
         var currMonth = '${month}';
         if(currMonth != null && currMonth != ""){
        	 $(monthObj).val(currMonth);
         }
     }
	</script>
</head>
<body onload="initialYearAndMonth();">
	<!--Logo区域开始--><%@include file="/WEB-INF/JSP/logo.jsp" %><!--Logo区域结束-->
    <!--导航区域开始--><div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp" %></div><!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
		<form name="mainForm" method="post">
			<!--查询-->
			<div class="search_add">                        
				<div>身份证：<input name="idcardNo" value="${idcardNo}" class="text_search"/></div>
				<div>账务账号：<input name="loginName" value="${loginName}" class="width100 text_search"/></div>                            
				<div>姓名：<input name="realName" value="${realName}" class="width70 text_search"/></div>
				<div><select name="year" class="select_search"></select>年<select name="month" class="select_search"></select>月</div>
	    		<div><input type="submit" value="搜索" class="btn_search" /></div>
			</div>  
			<!--数据区域：用表格展示数据-->     
			<div id="data">            
			    <table id="datalist">
				    <tr>
				        <th class="width50">账单ID</th>
				        <th class="width70">姓名</th>
				        <th class="width150">身份证</th>
				        <th class="width150">账务账号</th>
				        <th>费用</th>
				        <th class="width100">月份</th>
				        <th class="width100">支付方式</th>
				        <th class="width100">支付状态</th>                                                        
				        <th class="width50"></th>
				    </tr>
				    <s:iterator value="billPager.list">
					<tr>
				    	<td>${id }</td>
						<td>${account.realName }</td>
						<td>${account.idcardNo }</td>
						<td>${account.loginName }</td>
						<td>${cost }元</td>
						<td><s:property value="billMonth.substring(0,4)+'年'+billMonth.substring(4,6)+'月'"/></td>
						<td>${paymentMode }</td>                            
						<td><s:if test="payState==0">未支付</s:if><s:else>已支付</s:else></td>
						<td><a href="${base}/bill/billItem?billId=${id}" title="账单明细">明细</a></td>
					</tr>
					</s:iterator>
				</table>
            <p>业务说明：<br />
            1、设计支付方式和支付状态，为用户自服务中的支付功能预留；<br />
            2、只查询近 3 年的账单，即当前年和前两年，如2013/2012/2011；<br />
            3、年和月的数据由 js 代码自动生成；<br />
            4、由数据库中的ｊｏｂ每月的月底定时计算账单数据。</p>
            </div>                    
			<!--分页-->
			<pager:pager pager="${billPager}"/>                      
		</form>
	</div>
    <!--主要区域结束-->
    <div id="footer">
        <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
        <p>版权所有(C)加拿大达内IT培训集团公司 </p>
    </div>
</body>
</html>
