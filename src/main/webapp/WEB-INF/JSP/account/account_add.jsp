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
    	<script type="text/javascript">
    		$(function(){
	    		//提交表单
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
    							$("#save_result_info").text("保存成功").attr("class","save_success");
    						}else{
    							$("#save_result_info").text("添加失败").attr("class","save_fail");
    						}
  							showResultDiv(true);
  							window.setTimeout("showResultDiv(false);", 3000);
	    				},
	    				error:function(){
	    					alert("系统异常，请稍后");
	    				}
	    			});
	    		});
	    		
	    		//取消操作
	    		$("#cancel").click(function(){
	    			location.href='${base}/account/index';
	    		});
	    		
	    		//根据推荐人身份证号查找推荐人ID
				$('#recommenderIdcardNo').blur(function(){
					$.ajax({
						type:"POST",
						url:"${base}/account/getRecommenderId",
						data:"idcardNo="+this.value,
						async:false,
						success: function(data){
							alert(data);
							$('#recommenderId').val(data);
						}
					});
				});
	    		
				//根据身份证生成生日
				 $('#idcardNo').blur(function(){
					var year = this.value.substring(6,10);
					var month = this.value.substring(10,12);
					var day = this.value.substring(12,14);
					var birthdate = year+"-"+month+"-"+day;
					$('#birthdate').val(birthdate);
				});
    		});
    		
    		//提示信息
			function showResultDiv(flag) {
				var divResult = document.getElementById("save_result_info");
				if (flag){
					divResult.style.display = "block";
				}else{
					divResult.style.display = "none";
				}
			}
    		
    		//显示选填的信息项
			function showOptionalInfo(imgObj) {
				var div = document.getElementById("optionalInfo");
				if (div.className == "hide") {
				    div.className = "show";
				     imgObj.src = "${base}/images/hide.png";
				}else {
                    div.className = "hide";
                    imgObj.src = "${base}/images/show.png";
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
            <!--保存成功或者失败的提示消息-->    
             
            <div id="save_result_info" class="save_fail">保存失败，该身份证已经开通过账务账号！</div>
           
            <form action="${base}/account/add" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" id="realName" name="realName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">20长度以内的汉字、字母和数字的组合</div>
                </div>
                
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" id="idcardNo" name="idcardNo"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">正确的身份证号码格式</div>
                </div>
                
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
					<input type="text" id="loginName" name="loginName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">20长度以内的字母、数字和下划线的组合</div>
                </div>
                
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" id="loginPassword" name="loginPassword"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">8-12长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password" id="rePassword" name="rePassword"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">两次密码必须相同</div>
                </div>
                
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" id="telephone" name="telephone"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium">正确的电话号码格式：手机或固话</div>
                </div>
                
                <!--可选项-->
                <div class="text_info clearfix"><span>可选项：</span></div>
                <div class="input_info">
                    <img src="${base}/images/show.png" alt="展开" onclick="showOptionalInfo(this);" />
                </div>
                <div id="optionalInfo" class="hide">
                    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div class="input_info">
                        <input type="text" name="recommenderIdcardNo" id="recommenderIdcardNo"/>
                        <input type="hidden" name="recommenderId" id="recommenderId"/>
                        <div class="validate_msg_long">正确的身份证号码格式</div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                    	<input type="text" name="birthdate" id="birthdate" readonly="readonly" class="readonly"/>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width350" name="email" id="email"/>
                        <div class="validate_msg_tiny">50长度以内，合法的 Email 格式</div>
                    </div> 
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
                        <select name="occupation">
                            <option value="干部">干部</option>
                            <option value="学生">学生</option>
                            <option value="技术人员">技术人员</option>
                            <option value="其他">其他</option>
                        </select>                        
                    </div>
                    <div class="text_info clearfix"><span>性别：</span></div>
                    <div class="input_info fee_type">
                        <input type="radio" name="gender" id="gender0" checked="checked" value="0"/><label for="0">男</label>
						<input type="radio" name="gender" id="gender1" value="1"/><label for="gender1">女</label>
                    </div>
                    <div class="text_info clearfix"><span>通信地址：</span></div>
                    <div class="input_info">
                        <input type="text" class="width350" id="mailaddress" name="mailaddress"/>
                        <div class="validate_msg_tiny">50长度以内</div>
                        <div id="msg_mailaddress" class="error_msg" style="border:0px">
						</div>
                    </div> 
                    <div class="text_info clearfix"><span>邮编：</span></div>
                    <div class="input_info">
                        <input type="text" id="zipcode" name="zipcode"/>
                        <div class="validate_msg_long">6位数字</div>
                        <div id="msg_zipcode" class="error_msg" style="border:0px">
						</div>
                    </div> 
                    <div class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <input type="text" id="qq" name="qq"/>
                        <div class="validate_msg_long">5到13位数字</div>
                        <div id="msg_qq" class="error_msg" style="border:0px">
						</div>
                    </div>                
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
