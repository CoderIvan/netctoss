<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>达内－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css" />
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/navigate.js"></script>
    <script type="text/javascript" src="${base}/js/validation.js"></script>
    <script language="javascript" type="text/javascript">
     	$(function(){
     		init();
     		
	     	//根据身份证(idcardNo) 生成生日(birthdate)
			$('#idcardNo').change(function(){
     			var year = this.value.substring(6,10);
				var month = this.value.substring(10,12);
				var day = this.value.substring(12,14);
				var birthdate = year+"-"+month+"-"+day;
				$('#birthdate').val(birthdate);
     		}).change();
	     	
     		//根据推荐人身份证号(recommendeIdcardNo)
			$('#recommenderIdcardNo').change(function(){
				$.ajax({
					type:"POST",
					url:"${base}/account/getRecommenderId",
					data:"idcardNo="+this.value,
					async:false,
					success: function(data){
						$('#recommenderId').val(data);
					}
				});
			});
     		
     		//取消操作
    		$("#cancel").click(function(){
    			location.href='${base}/account/index';
    		});
     		
    		//提交表达
   			$("#save").click(function(){
    			this.disabled = false;
    			var action = $('form').attr("action");
    			var param = $('form').serializeArray();
    			$.ajax({
    				type:"POST",
    				url:action,
    				data:param,
    				async:false,
    				success : function(data){
    					if(data == "true"){
							$("#save_result_info").text("修改成功！").attr("class","save_success");
						}else{
							$("#save_result_info").text("修改失败").attr("class","save_fail");
						}
						showResultDiv(true);
						window.setTimeout("showResultDiv(false);", 3000);
    				},
    				error:function(){
    					alert("系统异常，请稍后");
    				}
    			});
    		});
     	});

         //显示修改密码的信息项
		function showPwd(chkObj) {
			if (chkObj.checked){
				$("#divPwds").css("display","block");
				$("#isUpdatePassword").val("true");
			}else{
				$("#divPwds").css("display","none");
				$("#isUpdatePassword").val("false");
			}
		}
         
        //载入数据
		function init(){
			$("#id").val("${account.id }");
			$("#realName").val("${account.realName}");
			$("#idcardNo").val("${account.idcardNo}");
			$("#loginName").val("${account.loginName}");
			$("#telephone").val("${account.telephone}");
			$("#recommenderIdcardNo").val("${recommenderIdcardNo}");
			$("#recommenderId").val("${account.recommenderId}");
			$("#birthdate").val("${account.birthdate}");
			$("#email").val("${account.email}");
			$("#occupation").val("${account.occupation }");
			$("#gender"+"${account.gender}").attr("checked","checked");
			$("#mailaddress").val("${account.mailaddress}");
			$("#zipcode").val("${account.zipcode}");
			$("#qq").val("${account.qq}");
		}
         
		//保存成功的提示消息
		function showResult() {
			showResultDiv(true);
			window.setTimeout("showResultDiv(false);", 3000);
		}
		function showResultDiv(flag) {
			var divResult = document.getElementById("save_result_info");
			if (flag){
				divResult.style.display = "block";
			}else{
				divResult.style.display = "none";
			}
		}

		//表单验证
		function validataForm(){
			var b1 = $("#realName").required("姓名不能为空",$("#msg_realName"));
			if(b1){
				b1 = $("#realName").chineseRange(0,20,"20长度的字母、数字和汉字的组合",$("#msg_realName"));
			}
			var b6 = $("#telephone").required("电话不能为空",$("#msg_telephone"));
			if(b6){
				b6 = $("#telephone").isTelephone("电话格式有误",$("#msg_telephone"));
			}
			var b7 = true;
		 	if($("#recommenderIdcardNo").val() != ""){
		 		b7 = $("#recommenderIdcardNo").isIdcardNo("身份证号码格式错误",$("#msg_recommenderIdcardNo"));
		 	}
 			var b8 = true;
			if($("#email").val() != ""){
				b8 = $("#email").isEmail("50长度以内，合法的 Email 格式",$("#msg_email"));
			}
			var b9 = true;
			if($("#mailaddress").val() != ""){
				b8 = $("#mailaddress").chineseRange(0,50,"50长度以内",$("#msg_mailaddress"));
			}
			var b11 = true;
			if($("#qq").val() != ""){
				b11 = $("#qq").isQQ("5到13位数字",$("#msg_qq"));
			}
            //---------改密码-----------//
            var b12 = true;
            var flag = $("#chkModiPwd").attr("checked");
            if(flag==true){
				var c1 = $("#loginPassword").range(1,30,"30长度以内的字母、数字和下划线的组合",$("#msg_loginPassword"));
            	var c2 = $("#new_loginPassword").range(1,30,"30长度以内的字母、数字和下划线的组合",$("#msg_new_loginPassword"));
            	var c3 = $("#re_loginPassword").val() == $("#new_loginPassword").val();
            	if(c3){
            		$("#msg_re_loginPassword").text("");
            	}else{
            		$("#msg_re_loginPassword").text("两次密码必须相同");
            	}
            	b12 = c1&&c2&&c3;
            }
			return b1&&b6&&b7&&b8&&b9&&b11&&b12;
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
        <!--保存成功或者失败的提示消息-->
        <div id="save_result_info" class="save_fail">保存失败，旧密码错误！</div>
        <form action="${base}/account/modify" method="post" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info">
                	<input id="id" name="id" readonly="readonly" class="readonly"/>
                </div>

                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input name="realName" id="realName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">20长度以内的汉字、字母和数字的组合</div>
                    <div id="msg_realName" class="error_msg" style="border:0px"></div>
                </div>
                
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                	<input id="idcardNo" name="idcardNo" readonly="readonly" class="readonly" id="idcardNo" />
                </div>
                
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input id="loginName" name="loginName" readonly="readonly" class="readonly"/>                   
                    <div class="change_pwd">
                        <input type="checkbox" id="chkModiPwd" onclick="javascript:showPwd(this);"/>
                        <label for="chkModiPwd">修改密码</label>
                        <input type="hidden" name="isUpdatePassword" id="isUpdatePassword" value="false"/>
                    </div>
                </div>
                <!--修改密码部分 start-->
                <div id="divPwds">
                    <div class="text_info clearfix"><span>旧密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="loginPassword" id="loginPassword"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                        <div id="msg_loginPassword" class="error_msg" style="border:0px"></div>
                    </div>
                    <div class="text_info clearfix"><span>新密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="new_loginPassword" id="new_loginPassword"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                        <div id="msg_new_loginPassword" class="error_msg" style="border:0px"></div>
                    </div>
                    <div class="text_info clearfix"><span>重复新密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="re_loginPassword" id="re_loginPassword"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long">两次密码必须相同</div>
                        <div id="msg_re_loginPassword" class="error_msg" style="border:0px"></div>
                    </div>  
                </div>
                <!--修改密码部分 end-->
                
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input name="telephone" id="telephone" class="width200"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium">正确的电话号码格式：手机或固话</div>
                    <div id="msg_telephone" class="error_msg" style="border:0px"></div>
                </div>
                
                <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                <div class="input_info">
                    <input id="recommenderIdcardNo"/>
                    <input type="hidden" name="recommenderId" id="recommenderId"/>
                    <div class="validate_msg_long error_msgs">正确的身份证号码格式</div>
                    <div id="msg_recommenderIdcardNo" class="error_msg" style="border:0px"></div>
                </div>
                
                <div class="text_info clearfix"><span>生日：</span></div>
                <div class="input_info">
                    <input id="birthdate" name="birthdate" readonly="readonly" class="readonly"/>
                </div>
                
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input id="email" name="email" class="width200"/>
                    <div class="validate_msg_medium">50长度以内，合法的 Email 格式</div>
                    <div id="msg_email" class="error_msg" style="border:0px"></div>
                </div>
                
                <div class="text_info clearfix"><span>职业：</span></div>
                <div class="input_info">
                	<select id="occupation" disabled="disabled">
			    		<option value="干部">干部</option>
			    		<option value="学生">学生</option>
			    		<option value="技术人员">技术人员</option>
			    		<option value="其他">其他</option>
			    	</select>
                </div>
                
                <div class="text_info clearfix"><span>性别：</span></div>
                <div class="input_info fee_type">
					<input type="radio" name="gender" id="gender0" disabled="disabled" checked="checked"/><label for="account_gender0">男</label>
					<input type="radio" name="gender" id="gender1" disabled="disabled"/><label for="account_gender1">女</label>
                </div>
                
                <div class="text_info clearfix"><span>通信地址：</span></div>
                <div class="input_info">
                    <input id="mailaddress" name="mailaddress" class="width350"/>
                    <div class="validate_msg_tiny">50长度以内</div>
                    <div id="msg_mailaddress" class="error_msg" style="border:0px"></div>
                </div> 
                
                <div class="text_info clearfix"><span>邮编：</span></div>
                <div class="input_info">
                    <input id="zipcode" name="zipcode"/>
                    <div class="validate_msg_long">6位数字</div>
                    <div id="msg_zipcode" class="error_msg" style="border:0px"></div>
                </div> 
                
                <div class="text_info clearfix"><span>QQ：</span></div>
                <div class="input_info">
					<input id="qq" name="qq"/>
                    <div class="validate_msg_long">5到13位数字</div>
                    <div id="msg_qq" class="error_msg" style="border:0px"></div>
                </div>                
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="save"/>
                    <input type="button" value="取消" class="btn_save" id="cancel"/>
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
