<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
			$("#save").click(function(){
				var params = $("form").serializeArray();
				$.ajax({
					type : "POST",
					url : "${base}/user/updatePwd",
					data : params,
					dataType : "JSON",
					success : function(result){
						if(result.success){
							showResult("密码修改成功",true);
						}else{
							showResult("密码修改失败：原因:"+result.content,false);
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
	<%@include file="/WEB-INF/JSP/logo.jsp"%>
	<!--Logo区域结束-->
    <!--导航区域开始-->
    <div id="navi"><%@include file="/WEB-INF/JSP/navigate.jsp"%></div>
    <!--导航区域结束-->
    
	<div id="main">
		<div id="save_result_info" class="save_success"></div>
		<form class="main_form"> 
			<div class="text_info clearfix"><span>旧密码：</span></div>
			<div class="input_info">
				<input type="password" name="oldPassword" class="width200"/>
				<span class="required">*</span>
				<div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
				<div id="msg_old_password" class="error_msg" style="border:0px"></div>
			</div>
           
			<div class="text_info clearfix"><span>新密码：</span></div>
			<div class="input_info">
				<input type="password" name="newPassword" class="width200"/>
				<span class="required">*</span>
				<div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
				<div id="msg_new_password" class="error_msg" style="border:0px"></div>
			</div>
           
			<div class="text_info clearfix"><span>重复新密码：</span></div>
				<div class="input_info">
					<input type="password" name="re_new_password" class="width200"/>
					<span class="required">*</span>
					<div class="validate_msg_medium">两次新密码必须相同</div>
					<div id="msg_re_new_password" class="error_msg" style="border:0px"></div>
				</div>
				
			<div class="button_info clearfix">
				<input type="button" value="保存" class="btn_save" id="save"/>
				<input type="button" value="取消" class="btn_save" />
			</div>
		</form>  
	</div>
	
	<!--主要区域结束-->
    <div id="footer">
        <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
        <p>版权所有(C)加拿大达内IT培训集团公司 </p>
    </div>
</body>
</html>
