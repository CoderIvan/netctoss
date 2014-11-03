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
        <script language="javascript" type="text/javascript">
            $(function(){
            	//更新资费
            	$(".btn_save").click(function(){
            		var params = $("form").serialize();
            		$.ajax({
         				type: "POST",
    					url: "${base}/service/update",
    					data: params,
    					dataType: "JSON",
    					success: function(result){
    						if(result.success){
    							showResult("资费修改成功，下个月生效",true);
    						}else{
    							showResult(result.content,false);
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
        <div id="navi">                        
            <%@include file="/WEB-INF/JSP/navigate.jsp" %>           
        </div>
        <!--导航区域结束-->
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_fail">资费修改失败！数据并发错误。</div>
            <form action="${base}/service/update" method="post" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix">
                	<span>业务账号ID：</span>
                </div>
                <div class="input_info">
                	<input type="text" name="serviceId" value="${service.id }" readonly="readonly" class="readonly"/>
                </div>
                <div class="text_info clearfix"
                	><span>OS 账号：</span>
                </div>
                <div class="input_info">
                	<input type="text" value="${service.host.name }" readonly="readonly" class="readonly"/>
                </div>
                <div class="text_info clearfix">
                	<span>服务器 IP：</span>
                </div>
                <div class="input_info">
                	<input type="text" value="${service.host.id }" readonly="readonly" class="readonly"/>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <s:select list="costs" name="costId" value="service.cost.id" listKey="id" listValue="name" cssClass="width150"/>
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" onclick="location.href='${base}/service/index'"/>
                </div>
                <p>业务说明：<br />
                1、修改资费后，点击保存，并未真正修改数据库中的数据；<br />
                2、提交操作到消息队列；<br />
                3、每月月底由程序自动完成业务所关联的资费；</p>
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
