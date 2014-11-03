<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/mytaglib" prefix="pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>达内－NetCTOSS</title>
	<link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css" />
	<link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css" />
	<script type="text/javascript" src="${base}/js/jquery.js"></script>
	<script type="text/javascript" src="${base}/js/validation.js"></script>
	<script type="text/javascript">
		$(function(){
			//根据服务器返回的sortMap属性设置排序按钮的状态
			if('${sortKey}' != ""){
				$('#${sortKey}').removeClass().addClass('sort_${sortValue}');
			}
			//根据排序值，提交给服务器
			$('#sortBtn input').click(function(){
				if($(this).hasClass('sort_asc')){
					$(this).removeClass().addClass('sort_desc');
					$('#sortValue').val('desc');
				}else{
					$(this).removeClass().addClass('sort_asc');
					$('#sortValue').val('asc');
				}
				$('#sortKey').val($(this).attr('name'));
				$('#sortForm').submit();
			});
			//开通资费
			$(".btn_start").click(function() {
				var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
				if(r){
					var $td = $(this).parent();
					var id = $td.siblings().get(0).innerText;
					$.ajax({
						type: "GET",
			            url: "${base}/cost/open",
			            data: {"id":id},
			            contentType: "application/json; charset=utf-8",
			            dataType: "json",
			            success: function (result) {
			            	if(result.success){
			            		$td.siblings().get(7).innerText = "开通";
			            		$td.html("");
								showResult("开通成功",true);
							}else{
								showResult("开通失败,"+result.content,false);
							}
			            },
					});
				}
			});
			//删除资费
			$(".btn_delete").click(function(){
				var r = window.confirm("确定要删除此资费吗？");
				if(r){
					var $td = $(this).parent();
					var id = $td.siblings().get(0).innerText;
					$.ajax({
						type: "GET",
			            url: "${base}/cost/delete",
			            data: {"id":id},
			            contentType: "application/json; charset=utf-8",
			            dataType: "json",
			            success: function (result) {
			            	if(result.success){
			            		$td.siblings().get(7).innerText = "删除";
			            		$td.html("");
								showResult("删除成功",true);
							}else{
								showResult("删除失败,"+result.content,false);
							}
			            },
					});
				}
			});
			//更新资费
			$(".btn_modify").click(function(){
				var id = $(this).parent().siblings().get(0).innerText;
				location = "${base}/cost/toUpdate?id="+id;
			});
			//查看资费详情
			$("#datalist tr td a").click(function(){
				var id = $(this).parent().siblings().get(0).innerText;
				location = "${base}/cost/detail?id="+id;
			});
		});
		//保存成功的提示信息
        function showResult(content,isSuccess) {
        	var msg_div = $('#operate_result_info');
        	msg_div.text(content);
        	if(isSuccess){
				msg_div.attr('class','operate_success');
        	}else{
        		msg_div.attr('class','operate_fail');
        	}
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            var $divResult = $("#operate_result_info");
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
		<!--排序-->
		<form id="sortForm" action="${base}/cost/index" method="post">
			<div class="search_add">
				<div id="sortBtn">
					<input type="hidden" name="sortKey" id="sortKey" />
					<input type="hidden" name="sortValue" id="sortValue" />
					<input type="button" name="baseDuration" value="时长" class="sort_asc" id="baseDuration" />
					<input type="button" name="baseCost" value="费用" class="sort_asc" id="baseCost" />
					<input type="button" name="unitCost" value="单价" class="sort_asc" id="unitCost" />
				</div>
				<input type="button" value="增加" class="btn_add" onclick="location='${base}/cost/toAdd';" />
			</div>
		</form>
		<!--启用操作的操作提示-->
		<div id="operate_result_info">
			<img src="${base}/images/close.png" onclick="this.parentNode.style.display='none';" />
		</div>
		<!--数据区域：用表格展示数据-->
		<div id="data">
			<table id="datalist">
				<tr>
					<th>资费ID</th>
					<th class="width100">资费名称</th>
					<th>基本时长</th>
					<th>基本费用</th>
					<th>单位费用</th>
					<th>创建时间</th>
					<th>开通时间</th>
					<th class="width50">状态</th>
					<th class="width200"></th>
				</tr>
				<s:iterator value="costPager.list">
				<tr>
					<td>${id }</td>
					<td><a href="javascript:;">${name }</a></td>
					<td>${baseDuration } 小时</td>
					<td>${baseCost } 元</td>
					<td>${unitCost } 元/小时</td>
					<td><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
					<td><s:date name="startTime" format="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<s:if test="status == 0">开通</s:if>
						<s:elseif test="status == 1">暂停</s:elseif>
						<s:elseif test="status == 2">删除</s:elseif>
					</td>
					<td>
						<s:if test="status != 0 && status != 2">
							<input type="button" value="启用" class="btn_start"/>
							<input type="button" value="修改" class="btn_modify"/>
							<input type="button" value="删除" class="btn_delete"/>
						</s:if>
					</td>
				</tr>
				</s:iterator>
			</table>
			<p>
				业务说明：<br />
				1、创建资费时，状态为暂停，记载创建时间；<br />
				2、暂停状态下，可修改，可删除；<br />
				3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
				4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
			</p>
		</div>
		<!--分页-->
		<pager:pager pager="${costPager}"/>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
		<p>版权所有(C)加拿大达内IT培训集团公司</p>
	</div>
</body>
</html>