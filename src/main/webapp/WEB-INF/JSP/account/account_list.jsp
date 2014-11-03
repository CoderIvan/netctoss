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
	<script language="javascript" type="text/javascript">
		$(function(){
         	//暂停账号
			$("body").on("click",".btn_pause",function(){
				if(window.confirm("确定要暂停此账务账号吗？")){
					var $input = $(this); 
					var id = $input.parents("tr").children(":first").html();
					$.ajax({
						type: "GET",
			            url: "${base}/account/pause",
			            data: {"id":id},
			            contentType: "application/json; charset=utf-8",
			            dataType: "json",
			            success: function (result) {
			            	if(result.success){
								$input.parents("tr").children().get(4).innerHTML = "暂停";
								$input.attr("class","btn_start").val("开通");
								showResult("暂停成功",true);
							}else{
								showResult("暂停失败,"+result.content,false);
							}
			            },
					});
				}
			});
			//开通账号
			$("body").on("click",".btn_start",function(){
				if(window.confirm("确定要开通此账务账号吗？")){
					var $input = $(this); 
					var id = $input.parents("tr").children(":first").html();
					$.ajax({
						type: "GET",
			            url: "${base}/account/open",
			            data: {"id":id},
			            contentType: "application/json; charset=utf-8",
			            dataType: "json",
			            success: function (result) {
			            	if(result.success){
								$input.parents("tr").children().get(4).innerHTML = "开通";
								$input.attr("class","btn_pause").val("暂停");
								showResult("开通成功",true);
							}else{
								showResult("开通失败,"+result.content,false);
							}
			            },
					});
				}
			});
			//删除账号
			$(".btn_delete").click(function(){
				if(window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。")){
					var $input = $(this); 
					var id = $input.parents("tr").children(":first").html();
					$.ajax({
						type: "GET",
			            url: "${base}/account/delete",
			            data: {"id":id},
			            contentType: "application/json; charset=utf-8",
			            dataType: "json",
			            success: function (result) {
			            	if(result.success){
								$input.parents("tr").children().get(4).innerHTML = "删除";
								$input.parent().html("");
								showResult("删除成功",true);
							}else{
								showResult("删除失败,"+result.content,false);
							}
			            },
					});
				}	
			});	

			//修改账务账号页面
			$(".btn_modify").click(function(){
				var id = $(this).parents("tr").children(":first").html();
				location = "${base}/account/toUpdate?id="+id;					
			});	
			
			//改变换页操作
			$("#pages a[href]").click(function(){
				$("form").attr("action",this.href).submit();
				return false;
			});
			//增加账务账号页面
			$(".btn_add").click(function(){
				location = "${base}/account/toAdd";					
			});
			
			
		});
		//保存成功的提示信息
        function showResult(content,isSuccess) {
        	var msg_div = $('#operate_result_info');
        	msg_div.text(content);
        	if(isSuccess){
				msg_div.attr('class','operate_success');
        	}else{
        		msg_div.attr('class','operate_fail');
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
		<form action="${base}/account/index" method="post">
			<!--查询-->
			<div class="search_add">
				<div>身份证：<s:textfield name="idcardNo" cssClass="text_search"/></div>
				<div>姓名：<s:textfield name="realName" cssClass="width70 text_search"/></div>
                <div>登录名：<s:textfield name="loginName" cssClass="text_search"/> </div>
                <div>状态： <s:select list="#{'-1':'全部','0':'开通','1':'暂停','2':'删除' }" name="status" cssClass="select_search"/></div>
                <div><input type="submit" value="搜索" class="btn_search" /></div>
                <input type="button" value="增加" class="btn_add"/>
			</div>  
		</form>
		
		<!--删除等的操作提示-->
		<div id="operate_result_info" class="operate_success">
			<img src="${base}/images/close.png" onclick="this.parentNode.style.display='none';" />
		</div>   
		
		<!--数据区域：用表格展示数据-->     
		<div id="data">            
			<table id="datalist">
				<tr>
					<th>账号ID</th>
					<th>姓名</th>
 					<th class="width150">身份证</th>
					<th>登录名</th>
					<th>状态</th>
					<th class="width100">创建日期</th>
					<th class="width150">上次登录时间</th>                                                        
					<th class="width200"></th>
				</tr>
				<s:iterator value="accountPager.list">
				<tr>
					<td>${id}</td>
					<td><a href="${base}/account/detail?id=${id}">${realName }</a></td>
					<td>${idcardNo }</td>
					<td>${loginName }</td>
					<td class="status">
						<s:if test="status==0">开通</s:if>
						<s:elseif test="status==1">暂停</s:elseif>
						<s:elseif test="status==2">删除</s:elseif>
					</td>
					<td><s:date name="createDate" format="yyyy-MM-dd"/></td>
					<td><s:date name="lastLoginTime" format="yyyy-MM-dd hh:mm:ss"/></td>                            
					<td class="td_modi">
						<s:if test="status==0">
                      		<input type="button" value="暂停" class="btn_pause" />
                      		<input type="button" value="修改" class="btn_modify" />
							<input type="button" value="删除" class="btn_delete" />
                      	</s:if>
                      	<s:if test="status==1">
                      		<input type="button" value="开通" class="btn_start"  />
                      		<input type="button" value="修改" class="btn_modify" />
							<input type="button" value="删除" class="btn_delete" />
                      	</s:if>
					</td>
				</tr>
				</s:iterator>
			</table>
            <p>业务说明：<br />
            1、创建则开通，记载创建时间；<br />
            2、暂停后，记载暂停时间；<br />
            3、重新开通后，删除暂停时间；<br />
            4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
            5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
            6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
            7、删除账务账号，同时删除下属的所有业务账号。</p>
		</div>                   
			
		<!--分页-->
		<pager:pager pager="${accountPager}" />
	</div>
    <!--主要区域结束-->
    <div id="footer">
        <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
        <p>版权所有(C)加拿大达内IT培训集团公司 </p>
    </div>
</body>
</html>
