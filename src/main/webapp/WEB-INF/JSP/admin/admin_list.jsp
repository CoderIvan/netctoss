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
			//重置管理员密码
			$("#reset").click(function(){
				var url = $(document.reset).attr("action");
				var params = $(document.reset).serializeArray();
				$.ajax({
					type : "POST",
					url : url,
					data : params,
					dataType : "JSON",
					success : function(result){
						if(result.success){
							showResult("重置成功",true);
						}else{
							showResult("重置失败：原因:"+result.content,false);
						}
					}
				});
			});
			//修改管理员信息
			$(".btn_modify").click(function(){
				var adminId = $(this).parent().parent().children().get(1).innerHTML;
				location = "${base}/admin/toUpdate?id="+adminId;
			});
			//修改管理员信息
			$(".btn_delete").click(function(){
				var td = $(this).parent().parent();
				var adminId = $(this).parent().parent().children().get(1).innerHTML;
				var params = $(document.reset).serializeArray();
				$.ajax({
					type : "POST",
					url : "${base}/admin/delete?id="+adminId,
					data : params,
					dataType : "JSON",
					success : function(result){
						if(result.success){
							showResult("删除成功",true);
							td.html("");
						}else{
							showResult("删除失败：原因:"+result.content,false);
						}
					}
				});
			});
		});
		//显示角色详细信息
	    function showDetail(flag, a) {
	        var detailDiv = a.parentNode.getElementsByTagName("div")[0];
	        if (flag) {
	            detailDiv.style.display = "block";
	        }else{
	            detailDiv.style.display = "none";
	       	}
	    }
		
		//保存成功的提示信息
	    function showResult(content,isSuccess) {
	    	var msg_div = $("#operate_result_info");
	    	$("#operate_result_info span").html(content);
	    	if(isSuccess){
				msg_div.attr("class","operate_success");
	    	}else{
	    		msg_div.attr("class","operate_fail");
	    	}
	        showResultDiv(true);
	        window.setTimeout("showResultDiv(false);", 3000);
	    }
	    function showResultDiv(flag) {
	        var $divResult = $("#operate_result_info");
	        if (flag){
	            $divResult.css("display","block");
	        }
	        else{
	        	$divResult.css("display","none");
	        }
	    }
	</script>
</head>
<body>
	<!--Logo区域开始-->
		<%@include file="/WEB-INF/JSP/logo.jsp" %>
	<!--Logo区域结束-->
	<!--导航区域开始-->
	<div id="navi">                        
		<%@include file="/WEB-INF/JSP/navigate.jsp" %>
	</div>
	<!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
		<form action="${base}/admin/index" method="post">
		<!--查询-->
			<div class="search_add">
				<div>
					权限：<s:select list="privileges" cssClass="select_search" listKey="id" listValue="moduleName" headerKey="-1" headerValue="全部" name="privilegeId"/>
				</div>
				<div>
					角色：<s:select list="roleInfos" cssClass="select_search" listKey="id" listValue="name" headerKey="-1" headerValue="全部" name="roleInfoId"/>
				</div>
				
				<div><input type="submit" value="搜索" class="btn_search"/></div>
                <input type="button" value="密码重置" class="btn_add" id="reset"/>
                <input type="button" value="增加" class="btn_add" onclick="location.href='${base}/admin/toAdd';" />
			</div>
		</form>
		
        <!--删除和密码重置的操作提示-->
		<div id="operate_result_info">
			<img src="${base }/images/close.png" onclick="this.parentNode.style.display='none';" />
			<span></span>
		</div>        
		 
		<!--数据区域：用表格展示数据-->     
		<form name="reset" action="${base}/admin/reset" method="post">  
			<div id="data">            
				<table id="datalist">
					<tr>
						<th class="th_select_all"><input type="checkbox"/><span>全选</span></th>
						<th>管理员ID</th>
						<th>姓名</th>
						<th>登录名</th>
						<th>电话</th>
						<th>电子邮件</th>
						<th>授权日期</th>    
						<th class="width100">拥有角色</th>
						<th></th>
					</tr>
					<s:iterator value="adminInfoPager.list">      
					<tr>
						<td><input type="checkbox" name="id" value="${id}"/></td>
						<td>${id }</td>
						<td>${name }</td>
						<td>${adminCode }</td>
						<td>${telephone }</td>
						<td>${email }</td>
						<td><s:date name="enrollDate" format="yyyy-MM-dd hh:mm:ss"/></td>
						<td>
							<s:iterator value="roleInfo">
								<a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${name }</a>
								<!--浮动的详细信息-->
							</s:iterator>
							<div class="detail_info"><s:iterator value="roleInfo">${name }<br/></s:iterator></div>
						</td>
						<td class="td_modi">
							<input type="button" value="修改" class="btn_modify"/>
							<input type="button" value="删除" class="btn_delete"/>
						</td>
					</tr>
					</s:iterator>
				</table>
			</div>
		</form>
		
		<!--分页-->
		<pager:pager pager="${adminInfoPager}"/>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
		<p>版权所有(C)加拿大达内IT培训集团公司 </p>
	</div>
</body>
</html>
