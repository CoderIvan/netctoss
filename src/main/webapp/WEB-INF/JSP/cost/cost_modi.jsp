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
	<script type="text/javascript" src="${base}/js/validation.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#type input:radio").change(function(){
				var costType = this.value;//套餐类型
				var $duration = $("#duration");//基本时长
				var $baseCost = $("#baseCost");//基本费用
				var $unitCost = $("#unitCost");//单位费用
				
				if(costType == 1){//包月
					$duration.attr("disabled",true);
					$baseCost.attr("disabled",false);
					$unitCost.attr("disabled",true);
				}else if(costType == 2){//套餐
					$duration.attr("disabled",false);
					$baseCost.attr("disabled",false);
					$unitCost.attr("disabled",false);
				}else if(costType == 3){//计时
					$duration.attr("disabled",true);
					$baseCost.attr("disabled",true);
					$unitCost.attr("disabled",false);
				}
			});
			init();
			$("#btn_cancel").click(function(){
				location = "${base}/cost/index";				
			});
			$("#update").click(function(){
				var param = $("form").serialize();
        		$.ajax({
     				type: "POST",
					url: "${base}/cost/update",
					data: param,
					dataType: "JSON",
					success: function(result){
						if(result.success){
							showResult("更新成功",true);
						}else{
							showResult("更新失败,"+result.content,false);
						}
					}
       			});
        	});
		});
		
		//填充数据
		function init(){
			var id = "${cost.id}";
			var name = "${cost.name}";
			var status = "${cost.status}";
			var type = "${cost.costType}";
			var duration = "${cost.baseDuration }";
			var baseCost = "${cost.baseCost }";
			var unitCost = "${cost.unitCost }";
			var descr = "${cost.descr }";
			$("#id").val(id);
			$("#name").val(name);
			$("#status"+status).attr("selected","selected");
			$("#type"+type).attr("checked","checked").change();
			$("#duration").val(duration);
			$("#baseCost").val(baseCost);
			$("#unitCost").val(unitCost);
			$("#descr").val(descr);
		}

		//修改成功的提示信息
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
	<!--主要区域开始-->
	<div id="main">
		<div id="save_result_info"></div>
		<form class="main_form">
			<input type="hidden" id="id" name="costId" class="readonly" readonly="readonly"/>

			<div class="text_info clearfix"><span>资费名称：</span></div>
			<div class="input_info">
				<input type="text" id="name" name="name"/>
				<span class="required">*</span>
				<div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
			</div>
			
			<div class="text_info clearfix"><span>资费类型：</span></div>
			<div class="input_info fee_type" id="type">
	        	<input type="radio" value="1" name="costType" id="type1"/><label for="type1">包月</label>
	        	<input type="radio" value="2" name="costType" id="type2"/><label for="type2">套餐</label>
	        	<input type="radio" value="3" name="costType" id="type3"/><label for="type3">计时</label>
	        </div>
			
			<div class="text_info clearfix"><span>基本时长：</span></div>
			<div class="input_info">
				<input id="duration" class="width100" name="duration"/>
				<span class="info">小时</span>
				<span class="required">*</span>
				<div class="validate_msg_long">
					1-600之间的整数
				</div>
			</div>
			
			<div class="text_info clearfix"><span>基本费用：</span></div>
			<div class="input_info">
				<input type="text" class="width100" id="baseCost" name="baseCost"/>
				<span class="info">元</span>
				<span class="required">*</span>
				<div class="validate_msg_long">0-99999.99之间的数值</div>
			</div>
			
			<div class="text_info clearfix"><span>单位费用：</span></div>
			<div class="input_info">
				<input id="unitCost" class="width100" name="unitCost"/>
				<span class="info">元/小时</span>
				<span class="required">*</span>
				<div class="validate_msg_long">0-99999.99之间的数值</div>
			</div>
			
			<div class="text_info clearfix"><span>资费说明：</span></div>
			<div class="input_info_high">
                <textarea class="width300 height70" id="descr" name="descr"></textarea>
				<div class="validate_msg_short">100长度的字母、数字、汉字和下划线的组合</div>
			</div>
			<div class="button_info clearfix">
				<input type="button" value="保存" class="btn_save" id="update"/>
				<input type="button" value="取消" class="btn_save" id="btn_cancel"  />
			</div>
		</form>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span><br />
		<span>版权所有(C)加拿大达内IT培训集团公司</span>
	</div>
</body>
</html>
