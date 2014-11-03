<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>达内－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css" />
	<link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css" />
	<script type="text/javascript" src="${base}/js/jquery.js"></script>
	<script type="text/javascript" src="${base}/js/navigate.js"></script>
    <script language="javascript" type="text/javascript">
	    $(function(){
			$("#save").click(function(){
				var params = $("form").serializeArray();
				$.ajax({
					type : "POST",
					url : "${base }/admin/update",
					data : params,
					dataType : "JSON",
					success : function(result){
						if(result.success){
							showResult("修改管理员成功",true);
						}else{
							showResult("修改失败：原因:"+result.content,false);
						}
					}
				});
			});
		});
  		//保存成功的提示信息
	    function showResult(content,isSuccess) {
	    	var msg_div = $('#save_result_info');
	    	msg_div.html(content);
	    	if(isSuccess){
				msg_div.attr('class','save_success');
	    	}else{
	    		msg_div.attr('class','save_fail');
	    	}
	        showResultDiv(true);
	        window.setTimeout("showResultDiv(false);", 3000);
	    }
    	function showResultDiv(flag) {
	        var $divResult = $("#save_result_info");
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
	<div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp" %></div>
	<!--导航区域结束-->
	
    <!--主要区域开始-->
	<div id="main">            
		<div id="save_result_info" class="save_success">保存成功！</div>
         
		<form action="${base }/admin/update" method="post" class="main_form">
			<div class="text_info clearfix"><span>姓名：</span></div>
			<div class="input_info">
				<input type="text" name="name" value="${adminInfo.name }" id="name"/>
				<span class="required">*</span>
				<div class="validate_msg_long">20长度以内的汉字、字母、数字的组合</div>
				<div class="error_msg" style="border:0px;" id="msg_name"></div>
			</div>
                
			<div class="text_info clearfix"><span>管理员账号：</span></div>
			<div class="input_info"><input type="text" name="id" value="${adminInfo.id }" readonly="readonly" class="readonly"/></div>
                
			<div class="text_info clearfix"><span>电话：</span></div>
			<div class="input_info">
				<input type="text" name="telephone" value="${adminInfo.telephone }" id="telephone"/>
                <span class="required">*</span>
                <div class="validate_msg_long">正确的电话号码格式：手机或固话</div>
                <div class="error_msg" style="border:0px;" id="msg_telephone"></div>
			</div>
			
			<div class="text_info clearfix"><span>Email：</span></div>
				<div class="input_info">
					<input type="text" name="email" value="${adminInfo.email }" class="width200" id="email"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium">50长度以内，正确的 email 格式</div>
                    <div class="error_msg" style="border:0px;" id="msg_email">
				</div>
			</div>
			
			<div class="text_info clearfix"><span>角色：</span></div>
				<div class="input_info_high">
					<div class="input_info_scroll">
						<ul><s:iterator value="roleInfos"><li>
							<s:if test="id in adminInfo.roleInfo.{id}">
								<input type="checkbox" value="${id }" name="roleInfoIds" checked="checked"/>
							</s:if>
							<s:else>
								<input type="checkbox" value="${id }" name="roleInfoIds"/>
							</s:else>
							${name}
						</li></s:iterator></ul>
                    </div>
				<span class="required">*</span>
				<div class="validate_msg_tiny">至少选择一个</div>
				<div id="msg_privilege" class="error_msg clearfix" style="border:0px"></div>
			</div>
                
			<div class="button_info clearfix" style="padding-top:10px;">
				<input type="button" value="保存" class="btn_save" id="save"/>
				<input type="button" value="取消" class="btn_save" onclick="location='${base}/admin/index';" />
			</div>
		</form>  
    </div>
    
    <!--主要区域结束-->
    <div id="footer">
        <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
        <br />
        <span>版权所有(C)加拿大达内IT培训集团公司 </span>
    </div>
</body>
</html>
