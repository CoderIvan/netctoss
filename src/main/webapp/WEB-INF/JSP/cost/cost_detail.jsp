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
		<script type="text/javascript" src="${base}/js/navigate.js"></script>
		<script type="text/javascript">
			$(function(){
				//返回资费主页
				$(".btn_save").click(function(){
					location='${base}/cost/index';
				});
				//填充数据
				var id = "${cost.id}";
				var feeName = "${cost.name}";
				var status = "${cost.status}";
				var type = "${cost.costType}";
				var duration = "${cost.baseDuration }";
				var baseCost = "${cost.baseCost }";
				var unitCost = "${cost.unitCost }";
				var createTime = "<s:date name='cost.createTime' format='yyyy/MM/dd hh:mm:ss' />";
				var startTime = "<s:date name='cost.startTime' format='yyyy/MM/dd hh:mm:ss' />";
				var descr = "${cost.descr }";
				$("#id").val(id);
				$("#feeName").val(feeName);
				$("#status"+status).attr("selected","selected");
				$("#type"+type).attr("checked","checked");
				$("#duration").val(duration);
				$("#baseCost").val(baseCost);
				$("#unitCost").val(unitCost);
				$("#createTime").val(createTime);
				$("#startTime").val(startTime);
				$("#descr").val(descr);
			});
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
		<!--主要区域开始-->
    	<!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
	        <div class="text_info clearfix"><span>资费ID：</span></div>
	        <div class="input_info"><input type="text" class="readonly" readonly="readonly" id="id"/></div>
	        
	        <div class="text_info clearfix"><span>资费名称：</span></div>
	        <div class="input_info"><input type="text" class="readonly" readonly="readonly" id="feeName"/></div>
	        
	        <div class="text_info clearfix"><span>资费状态：</span></div>
	        <div class="input_info">
	        	<select class="readonly" disabled="disabled" id="status">
					<option value="0" id="status0">开通</option>
					<option value="1" id="status1">暂停</option>
					<option value="2" id="status2">删除</option>
	          	</select>
	        </div>
	        
	        <div class="text_info clearfix"><span>资费类型：</span></div>
	        <div class="input_info fee_type" id="type">
	        	<input type="radio" disabled="disabled" value="1" id="type1"/><label for="type1">包月</label>
	        	<input type="radio" disabled="disabled" value="2" id="type2"/><label for="type2">套餐</label>
	        	<input type="radio" disabled="disabled" value="3" id="type3"/><label for="type3">计时</label>
	        </div>
	        
	        <div class="text_info clearfix"><span>基本时长：</span></div>
	        <div class="input_info"><input type="text" class="readonly" readonly="readonly" id="duration" /><span>小时</span></div>
	        
	        <div class="text_info clearfix"><span>基本费用：</span></div>
	        <div class="input_info"><input type="text" class="readonly" readonly="readonly" id="baseCost" /><span>元</span></div>
	        
	        <div class="text_info clearfix"><span>单位费用：</span></div>
	        <div class="input_info"><input type="text" class="readonly" readonly="readonly" id="unitCost" /><span>元/小时</span></div>
	        
	        <div class="text_info clearfix"><span>创建时间：</span></div>
	        <div class="input_info"><input type="text"  class="readonly" readonly="readonly" id="createTime"/></div>      
	        
	        <div class="text_info clearfix"><span>启动时间：</span></div>
	        <div class="input_info"><input type="text"  class="readonly" readonly="readonly" id="startTime"/></div>
	        
	        <div class="text_info clearfix"><span>资费说明：</span></div>
	        <div class="input_info_high"><textarea style="resize:none" readonly="readonly" class="width300 height70 readonly" id="descr"></textarea></div>            
	                
	        <div class="button_info clearfix"><input type="button" value="返回" class="btn_save"/></div>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)加拿大达内IT培训集团公司 </span>
        </div>
    </body>
</html>
