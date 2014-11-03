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
		//显示角色详细信息
		function showDetail(flag, a) {
	        var detailDiv = a.parentNode.getElementsByTagName("div")[0];
	        if (flag) {
	            detailDiv.style.display = "block";
	        } else{
	            detailDiv.style.display = "none";
	        }
		}
        $(function(){
        	//分页--换页时携带查询的参数
        	$("#pages a[href]").click(function(){
        		$("form").attr("action",this.href);
        		$("form").submit();
        		return false;
        	});
        	//查看明细
   			$(".detail").click(function(){
   				location = '${base}/service/detail?id='+this.innerHTML;
   			});
        	//暂停业务
        	$(".btn_pause").click(function(){
        		var serviceId = $(this).parent().siblings().get(0).innerText;//获取对应的业务ID
        		$.ajax({
     				type: "POST",
					url: "${base}/service/pause",
					data: {"serviceId":serviceId},
					dataType: "JSON",
					success: function(result){
						if(result.success){
							alert("暂停成功");
							location.reload();
						}else{
							alert("暂停失败\n失败原因:"+result.content);
						}
					}
       			});
        	});
        	
        	//开通业务
        	$(".btn_start").click(function(){
        		var serviceId = $(this).parent().siblings().get(0).innerText;//获取对应的业务ID
        		$.ajax({
     				type: "POST",
					url: "${base}/service/open",
					data: {"serviceId":serviceId},
					dataType: "JSON",
					success: function(result){
						if(result.success){
							alert("开通成功");
							location.reload();
						}else{
							alert("开通失败\n失败原因:"+result.content);
						}
					}
       			});
        	});
        	
        	//暂停业务
        	$(".btn_delete").click(function(){
        		var serviceId = $(this).parent().siblings().get(0).innerText;//获取对应的业务ID
        		$.ajax({
     				type: "POST",
					url: "${base}/service/delete",
					data: {"serviceId":serviceId},
					dataType: "JSON",
					success: function(result){
						if(result.success){
							alert("删除成功");
							location.reload();
						}else{
							alert("删除失败\n失败原因:"+result.content);
						}
					}
       			});
        	});
        	
        	//修改业务
        	$(".btn_modify").click(function(){
        		var serviceId = $(this).parent().siblings().get(0).innerText;//获取对应的业务ID
        		location = '${base}/service/toUpdate?serviceId='+serviceId;
        	});
        });
    </script>
</head>
<body>
	<%@include file="/WEB-INF/JSP/logo.jsp" %>
	<div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp" %></div>
	<div id="main">
		<form action="${base}/service/index.action" method="post" id="serviceSearch">
            <div class="search_add">                        
				<div>OS 账号：<input type="text" name="osUsername" class="width100 text_search" value="${osUsername }"/></div>                            
				<div>服务器 IP：<input type="text" name="hostId" class="width100 text_search" value="${hostId }"/></div>
				<div>身份证：<input type="text" name="accountIdcardNo" class="text_search" value="${accountIdcardNo }"/></div>
				<div>状态：<s:select list="#{'-1':'全部','0':'开通','1':'暂停','2':'删除' }" name="status" cssClass="select_search"/></div>
                <div><input type="submit" value="搜索" class="btn_search" /></div>
                <input type="button" value="增加" class="btn_add" onclick="location.href='${base}/toAddService.action';" />
            </div>
        </form>
		<div id="operate_result_info" class="operate_success">
			<img src="${base}/images/close.png" onclick="this.parentNode.style.display='none';" />
		</div>   
		<div id="data">            
			<table id="datalist">
				<tr>
                   <th class="width50">业务ID</th>
                   <th class="width70">账务账号ID</th>
                   <th class="width150">身份证</th>
                   <th class="width70">姓名</th>
                   <th>OS 账号</th>
                   <th class="width50">状态</th>
                   <th class="width100">服务器 IP</th>
                   <th class="width100">资费</th>                                                        
                   <th class="width200"></th>
				</tr>
				<s:iterator value="servicePager.list">
				<tr>
					<td><a title="查看明细" href="javascript:;" class="detail">${id}</a></td>
					<td>${account.id}</td>
					<td>${account.idcardNo }</td>
					<td>${account.realName }</td>
					<td>${osUsername }</td>
					<td>
						<s:if test="status==0">开通</s:if>
						<s:elseif test="status==1">暂停</s:elseif>
						<s:elseif test="status==2">删除</s:elseif>
					</td>
					<td>${host.id}</td>
					<td>
						<a class="summary" onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${cost.name }</a>
						<div class="detail_info">${cost.descr}</div></td>
					<td class="td_modi">
						<s:if test="status==0">
						<input type="button" value="暂停" class="btn_pause"/>
                   		<input type="button" value="修改" class="btn_modify"/>
                      	<input type="button" value="删除" class="btn_delete"/>
						</s:if>
						<s:elseif test="status==1">
                   		<input type="button" value="开通" class="btn_start"/>
                   		<input type="button" value="修改" class="btn_modify"/>
                       	<input type="button" value="删除" class="btn_delete"/>
                  		</s:elseif>
					</td>
				</tr>
				</s:iterator>
            </table>                
            <p>业务说明：<br />
            1、创建即开通，记载创建时间；<br />
            2、暂停后，记载暂停时间；<br />
            3、重新开通后，删除暂停时间；<br />
            4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
            5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
            6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
		</div>                    
		<pager:pager pager="${servicePager}" />                     
    </div>
    <div id="footer">
        <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
        <p>版权所有(C)加拿大达内IT培训集团公司 </p>
    </div>
</body>
</html>
