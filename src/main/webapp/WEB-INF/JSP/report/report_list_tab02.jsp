<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/mytaglib" prefix="pager" %>         
<table id="datalist">
	<tr>                            
		<th class="width300">Unix 服务器IP</th>
	    <th>账务帐号</th>
	    <th>客户名称</th>
	    <th class="width200">身份证号码</th>
	    <th class="width150">累积时长</th>
	</tr>
	<s:iterator value="pager.list">                    
	<tr>
		<td>${unixHost}</td>
		<td>${osUsername}</td>
		<td>${realName}</td>
		<td>${idcardNo}</td>
		<td><s:property value="duration/3600+'小时'+duration%60/60+'分'+duration/3600 +'秒'"/></td>
	</tr>
	</s:iterator>
</table>