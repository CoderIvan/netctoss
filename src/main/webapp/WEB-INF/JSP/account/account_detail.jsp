<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>达内－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="${path }/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="${path }/styles/global_color.css" />
	<script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${path }/js/navigate.js"></script>
    <script type="text/javascript">
    	$(function(){
    		//返回主页面
			$("#return").click(function(){
				location = "${base}/account/index";
			});
    		//载入数据
    		initDate();
    	});
    	//数据载入
    	function initDate(){
    		$("#id").val("${account.id}");
    		$("#realName").val("${account.realName}");
    		$("#idcardNo").val("${account.idcardNo }");
    		$("#loginName").val("${account.loginName }");
    		$("#telephone").val("${account.telephone }");
    
    		var recommenderId = "${account.recommenderId }";
    		$("#recommenderId").val(recommenderId);
    		if(recommenderId!=""){
	    		$.ajax({
	    			url:"${base}/account/getRecommenderIdcardNo",
	    			data : {"id":recommenderId},
	    			dataType : "json",
	    			success : function(data){
			    		$("#recommenderIdcardNo").val(data);
	    			}
	    		});
    		}
    		
    		var status = "${account.status}";
    		$("#status").val(status);
			if(status=="0"){
     			$("#statusText").text("开通时间：");
	    		$("#statusDate").val("${account.createDate}");
			}else if (status=="1"){
				$("#statusText").text("暂停时间：");
	    		$("#statusDate").val("${account.pauseDate}");
			}else if(status=="2"){
				$("#statusText").text("删除时间：");
	    		$("#statusDate").val("${account.closeDate}");
			}
			
			$("#lastLoginTime").val("${account.lastLoginTime}");
			$("#lastLoginIp").val("${account.lastLoginIp}");
			$("#birthdate").val("${account.birthdate}");
			$("#email").val("${account.email }");
			$("#occupation").val("${account.occupation }");
			$("#gender"+"${account.gender}").attr("checked","checked");
			$("#mailaddress").val("${account.mailaddress}");
			$("#zipcode").val("${account.zipcode }");
			$("#qq").val("${account.qq }");
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
	    <!--必填项-->
	    <div class="text_info clearfix"><span>账务账号ID：</span></div>
	    <div class="input_info"><input type="text" id="id" readonly="readonly" class="readonly" /></div>
	    
	    <div class="text_info clearfix"><span>姓名：</span></div>
	    <div class="input_info"><input type="text" id="realName" readonly="readonly" class="readonly" /></div>
	    
	    <div class="text_info clearfix"><span>身份证：</span></div>
	    <div class="input_info"><input type="text" id="idcardNo" readonly="readonly" class="readonly" /></div>
	    
	    <div class="text_info clearfix"><span>登录账号：</span></div>
	    <div class="input_info"><input type="text" id="loginName" readonly="readonly" class="readonly" /></div>             
	          
	    <div class="text_info clearfix"><span>电话：</span></div>
	    <div class="input_info"><input type="text" id="telephone" readonly="readonly" class="width200 readonly" /></div>
	    
	    <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
	    <div class="input_info"><input type="text" id="recommenderId" readonly="readonly" class="readonly" /></div>
	    
	    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
	    <div class="input_info"><input type="text" id="recommenderIdcardNo" readonly="readonly" class="readonly" /></div>
	    
	    <div class="text_info clearfix"><span>状态：</span></div>
	    <div class="input_info">
	    	<select id="status" disabled="disabled">
	    		<option value="0">开通</option>
	    		<option value="1">暂停</option>
	    		<option value="2">删除</option>
	    	</select>
	    </div>
	    
	    <div class="text_info clearfix"><span id="statusText"></span></div>
	    <div class="input_info"><input type="text" id="statusDate" readonly="readonly" class="readonly"/></div>
	
	    <div class="text_info clearfix"><span>上次登录时间：</span></div>
	    <div class="input_info"><input type="text" id="lastLoginTime" readonly="readonly" class="readonly"/></div>
	    
	    <div class="text_info clearfix"><span>上次登录IP：</span></div>
	    <div class="input_info"><input type="text" id="lastLoginIp" readonly="readonly" class="readonly" /> </div>
	    
	    <div class="text_info clearfix"><span>生日：</span></div>
	    <div class="input_info"><input type="text" id="birthdate" readonly="readonly" class="readonly"/></div>
	    
	    <div class="text_info clearfix"><span>Email：</span></div>
	    <div class="input_info"> <input type="text" id="email" readonly="readonly" class="width350 readonly"/></div> 
	    
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
	    <div class="input_info"><input type="text" id="mailaddress" class="width350 readonly" readonly="readonly" /></div> 
	    
	    <div class="text_info clearfix"><span>邮编：</span></div>
	    <div class="input_info"><input type="text" id="zipcode" class="readonly" readonly="readonly" /></div>
	    
	    <div class="text_info clearfix"><span>QQ：</span></div>
	    <div class="input_info"><input type="text" id="qq" class="readonly" readonly="readonly" /></div>
	
	    <!--操作按钮-->
	    <div class="button_info clearfix">
	        <input type="button" value="返回" class="btn_save" id="return" />
	    </div>
    </div>
    <!--主要区域结束-->
    <div id="footer">
        <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
        <br />
        <span>版权所有(C)加拿大达内IT培训集团公司 </span>
    </div>
</body>
</html>
