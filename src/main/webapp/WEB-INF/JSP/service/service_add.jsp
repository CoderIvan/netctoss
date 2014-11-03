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
<script type="text/javascript" src="${path }/js/validation.js"></script>
<script language="javascript" type="text/javascript">
	//保存成功的提示信息
	function showResult() {
		showResultDiv(true);
		window.setTimeout("showResultDiv(false);", 3000);
	}
	function showResultDiv(flag) {
		var divResult = document.getElementById("save_result_info");
		if (flag)
			divResult.style.display = "block";
		else
			divResult.style.display = "none";
	}
	//根据添加操作结果，显示提示信息
	function showMessage() {
		var flag = '${addFlag}';
		var msg_div = document.getElementById("save_result_info");
		if (flag == 'true') {
			//提示成功
			msg_div.innerHTML = "保存业务账号成功";
			msg_div.className = "save_success";
			showResult();
		} else if (flag == 'false') {
			//提示失败
			msg_div.innerHTML = "保存业务账号失败";
			msg_div.className = "save_fail";
			showResult();
		}
	}

	//自动查询账务账号
	function searchAccounts(txtObj) {
		//document.getElementById("a1").innerHTML = txtObj.value;
	}
	//根据身份证查询账务账号
	function getAccountByIdcardNo(idcardNo) {
		var idcardNo = $('#idcardNo').val();
		$.ajax({
			type : "POST",
			url : "findAccount.action",
			data : "idcardNo="+idcardNo,
			datatype : "json",
			success : function(msg) {
				if(msg == null){
					$('#accountId').val('');
					$('#loginName').val('');
					$('#msg_idcardNo').text("没有此身份证");
				}else{
					var id = msg.id;
					var loginName = msg.loginName;
					$('#accountId').val(id);
					$('#loginName').val(loginName);
				}
			}
		});
	}
	
	//表单验证
	function validataForm(){
		var b1 = $("#idcardNo").required("身份证不能为空",$("#msg_idcardNo"));
		if(b1){
			b1 = $("#idcardNo").isIdcardNo("身份证号码格式错误",$("#msg_idcardNo"));
		}
		
		var b2 = $("#loginName").required("账务账号不能为空",$("#msg_loginName"));

		var b2a = $("#unixHost").required("服务器 IP不能为空",$("#msg_unixHost"));
		
		var b3 = $("#osUsername").required("符合IP的地址规范",$("#msg_osUsername"));
		
		var b4 = $("#loginPasswd").required("密码不能为空",$("#msg_loginPasswd"));
		if(b4){
			b4 = $("#loginPasswd").range(8,12,"8-12长度以内的字母、数字和下划线的组合",$("#msg_loginPasswd"));
		}
		
		var b5 = $("#rePassword").required("密码不能为空",$("#msg_rePassword"));
		if(b5){
			b5 = $("#rePassword").val() == $("#loginPasswd").val();
			if(b5){
				$("#msg_rePassword").text("");
			}else{
				$("#msg_rePassword").text("两次密码必须相同");
			}
		}
		
		return b1&&b2&&b2a&&b3&&b4&&b5;
	}
	
	 //提交表达
	$(function(){
		$('#save').click(function(){
	 	var falg = validataForm();
	 	if(falg){
			$('#form').submit();
		}
		});
	});
</script>
</head>
<body onload="showMessage();">
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
		<!--保存操作的提示信息-->
		<div id="save_result_info" class="save_fail">
			保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。
		</div>
		<form action="/netctoss/service/addService.action" method="post" class="main_form" id="form">
			<!--内容项-->
			<div class="text_info clearfix">
				<span>身份证：</span>
			</div>
			<div class="input_info">
				<input type="text" value="" class="width180" id="idcardNo" />
				<input type="button" value="查询账务账号" class="btn_search_large" onclick="getAccountByIdcardNo(this);" />
				<input type="hidden" name="service.account.id" id="accountId"/>
				<span class="required">*</span>
				<div class="validate_msg_short">没有此身份证号，请重新录入。</div>
				<div id="msg_idcardNo" class="error_msg" style="border:0px">
				</div>
			</div>
			
			<div class="text_info clearfix">
				<span>账务账号：</span>
			</div>
			<div class="input_info">
				<input onkeyup="searchAccounts(this);" id="loginName"/>
				<span class="required">*</span>
				<div class="validate_msg_long">必需填写</div>
				<div id="msg_loginName" class="error_msg" style="border:0px">
					<s:fielderror fieldName="service.account.id"/>
				</div>
			</div>
			
			<div class="text_info clearfix">
				<span>资费类型：</span>
			</div>
			<div class="input_info">
				<s:select list="costs" name="service.cost.id" listKey="id" listValue="feeName" />
			</div>
			<div class="text_info clearfix">
				<span>服务器 IP：</span>
			</div>
			<div class="input_info">
				<s:textfield name="service.unixHost" id="unixHost"/>
				<span class="required">*</span>
				<div class="validate_msg_long">15 长度，符合IP的地址规范</div>
				<div id="msg_unixHost" class="error_msg" style="border:0px">
					<s:fielderror fieldName="service.unixHost"/>
				</div>
			</div>
			
			<div class="text_info clearfix">
				<span>登录 OS 账号：</span>
			</div>
			<div class="input_info">
				<s:textfield name="service.osUsername" id="osUsername"/>
				<span class="required">*</span>
				<div class="validate_msg_long">8长度以内的字母、数字和下划线的组合</div>
				<div id="msg_osUsername" class="error_msg" style="border:0px">
					<s:fielderror fieldName="service.osUsername"/>
				</div>
			</div>
			
			<div class="text_info clearfix">
				<span>密码：</span>
			</div>
			<div class="input_info">
				<s:password name="service.loginPasswd" id="loginPasswd"/>
				<span class="required">*</span>
				<div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
				<div id="msg_loginPasswd" class="error_msg" style="border:0px">
					<s:fielderror fieldName="service.loginPasswd"/>
				</div>
			</div>
			
			<div class="text_info clearfix">
				<span>重复密码：</span>
			</div>
			<div class="input_info">
				<s:password name="rePassword" id="rePassword"/>
				<span class="required">*</span>
				<div class="validate_msg_long">两次密码必须相同</div>
				<div id="msg_rePassword" class="error_msg" style="border:0px">
					<s:fielderror fieldName="rePassword"/>
				</div>
			</div>
			<!--操作按钮-->
			<div class="button_info clearfix">
				<input type="button" value="保存" class="btn_save" id="save"/>
				<input type="button" value="取消" class="btn_save"
					onclick="location.href='toServiceList.action'" />
			</div>
		</form>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span> <br /> <span>版权所有(C)加拿大达内IT培训集团公司
		</span>
	</div>
</body>
</html>
