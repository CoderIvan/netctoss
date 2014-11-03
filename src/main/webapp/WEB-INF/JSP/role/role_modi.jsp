<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
        <script type="text/javascript" src="../js/navigate.js"></script>
        <script type="text/javascript" src="../js/validation.js"></script>
        <script language="javascript" type="text/javascript">
            $(function(){
        		var flag = '${updateFlag}';
        		var $target = $('#save_result_info');
        		if(flag=='true'){
        			$target.text('更新成功！');
        			$target.attr('class','save_success');
        			showResult();
        		}else if(flag=='false'){
        			$target.text('更新失败');
        			$target.attr('class','save_fail');
        			showResult();
        		}
        	});
        	
            //保存成功的提示消息
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
            //表单验证
			function validataForm(){
				var b1 = $("#roleName").required("不能为空",$("#msg_roleName"));
				if(b1){
					$("#roleName").chineseRange(0,20,"20长度的字母、数字和汉字的组合",$("#msg_roleName"));
				}
				
				var b2 = $(":checkbox:checked").length>0;
				if(b2){
					$("#msg_privilege").text("");
				}else{
					$("#msg_privilege").text("至少选择一个权限");
				}
				
				return b1&&b2;
			}
            
            $(function(){
            	$("#save").click(function(){
            		var falg = validataForm();
            		if(falg){
            			$("#modifyRole_update").submit();
            		}
            	});
            });
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        	<%@include file="../logo.jsp" %>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <%@include file="../navigate.jsp" %>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">           
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="modifyRole_update.action" method="post" class="main_form" id="modifyRole_update">
                <s:hidden name="roleInfo.id"/>
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <s:textfield name="roleInfo.name" id="roleName" cssClass="width200"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium">
                    	不能为空，且为20长度的字母、数字和汉字的组合
                    </div>
                    <div id="msg_roleName" class="error_msg" style="border:0px">
						<s:fielderror name="roleName"/>
					</div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                        	<s:iterator value="privileges">
                        		<li>
                        			<s:if test="id in roleInfo.rolePrivileges.{privilegeId} or id in privilegeId">
                        				<input type="checkbox" value="${id}" name="privilegeId" checked="checked"/>
                        			</s:if>
                        			<s:else>
                        				<input type="checkbox" value="${id}" name="privilegeId"/>
                        			</s:else>
                        				${moduleName}
								</li>
                        	</s:iterator>
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
                	<div id="msg_privilege" class="error_msg clearfix" style="border:0px">
						<s:fielderror name="privilegeId"/>
					</div>
                </div>
                <div class="button_info clearfix" style="padding-top:10px;">
                    <input type="button" value="保存" class="btn_save" id="save"/>
                    <input type="button" value="取消" class="btn_save" onclick="location='roleList.action';"/>
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
