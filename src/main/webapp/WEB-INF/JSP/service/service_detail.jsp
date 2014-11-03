<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
		<link type="text/css" rel="stylesheet" media="all" href="${path }/styles/global.css" />
		<link type="text/css" rel="stylesheet" media="all" href="${path }/styles/global_color.css" />
		<script type="text/javascript" src="${path }/js/jquery.js"></script>
    </head>
    <body>
       	<%@include file="/WEB-INF/JSP/logo.jsp" %>
        <div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp" %></div>
        <div id="main">            
	        <div class="text_info clearfix"><span>业务账号ID：</span></div>
	        <div class="input_info">
	        	<input type="text" value="${service.id}" readonly="readonly" class="readonly" />
	        </div>
	        <div class="text_info clearfix"><span>账务账号ID：</span></div>
	        <div class="input_info">
	        	<input type="text" value="${service.account.id }" readonly="readonly" class="readonly" />
	        </div>
	        <div class="text_info clearfix"><span>客户姓名：</span></div>
	        <div class="input_info">
	        	<input type="text"  value="${service.account.realName }" readonly="readonly" class="readonly" />
	        </div>
	        <div class="text_info clearfix"><span>身份证号码：</span></div>
	        <div class="input_info">
	        	<input type="text" value="${service.account.idcardNo }" readonly="readonly" class="readonly" />
	        </div>
	        <div class="text_info clearfix"><span>服务器 IP：</span></div>
	        <div class="input_info">
	        	<input type="text" value="${service.host.id }" readonly="readonly" class="readonly" />
	        </div>
	        <div class="text_info clearfix"><span>OS 账号：</span></div>
	        <div class="input_info">
	        	<input type="text" value="${service.osUsername }" readonly="readonly" class="readonly" />
	        </div>
	        <div class="text_info clearfix"><span>状态：</span></div>
	        <div class="input_info">
	        	<s:select list="#{'0':'开通','1':'暂停','2':'删除'}" name="service.status" disabled="true"/>
	        </div>
	        <div class="text_info clearfix">
	        	<span>
	        		<s:if test="service.status==0">开通时间：</s:if>
	        		<s:elseif test="service.status==1">暂停时间：</s:elseif>
	        		<s:elseif test="service.status==2">删除时间：</s:elseif>
	        	</span>
	        </div>
	        <div class="input_info">
	        	<s:if test="service.status==0">
	        		<input type="text" value="<s:date name="service.createDate" format="yyyy-MM-dd hh:mm:ss" />" readonly="readonly" class="readonly" />
	        	</s:if>
        		<s:elseif test="service.status==1">
        			<input type="text" value="<s:date name="service.pauseDate" format="yyyy-MM-dd hh:mm:ss" />" readonly="readonly" class="readonly" />
        		</s:elseif>
        		<s:elseif test="service.status==2">
        			<input type="text" value="<s:date name="service.closeDate" format="yyyy-MM-dd hh:mm:ss" />" readonly="readonly" class="readonly" />
        		</s:elseif>
	        </div>
	        <div class="text_info clearfix"><span>资费 ID：</span></div>
	        <div class="input_info">
	        	<input type="text" value="${service.cost.id }" class="readonly" readonly="readonly" />
	        </div>
	        <div class="text_info clearfix"><span>资费名称：</span></div>
	        <div class="input_info">
	        	<input type="text" value="${service.cost.name }" readonly="readonly" class="width200 readonly" />
	        </div>
	        <div class="text_info clearfix"><span>资费说明：</span></div>
	        <div class="input_info_high">
	            <textarea class="width300 height70 readonly" readonly="readonly" style="resize:none;">${service.cost.descr }</textarea>
	        </div>  
	        <!--操作按钮-->
	        <div class="button_info clearfix">
	            <input type="button" value="返回" class="btn_save" onclick="location.href='${base}/service/index.action';" />
	        </div>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span><br />
            <span>版权所有(C)加拿大达内IT培训集团公司 </span>
        </div>
    </body>
</html>
