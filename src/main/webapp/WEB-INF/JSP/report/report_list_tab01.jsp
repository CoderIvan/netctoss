<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/mytaglib" prefix="pager" %>         
<table id="datalist">
	<tr>                            
		<th>账号 ID</th>
		<th>账务帐号</th>
		<th>客户名称</th>
		<th class="width200">身份证号码</th>
		<th>电话</th>
		<th class="width150">月份</th>
		<th class="width150">累积时长</th>
	</tr>
	<s:iterator value="pager.list">   
	<tr>                            
		<td>${id}</td>
		<td>${loginName}</td>
		<td>${realName}</td>
		<td>${idcardNo}</td>
		<td>${telephone}</td>
		<td><s:property value="month.substring(0,4)+'年'+month.substring(4,6)+'月'"/></td>
		<td><s:property value="duration/3600+'小时'+duration%60/60+'分'+duration/3600 +'秒'"/></td>
	</tr>
	</s:iterator>
</table>