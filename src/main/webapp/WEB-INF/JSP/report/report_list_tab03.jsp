<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/mytaglib" prefix="pager" %>         
<table id="datalist">
	<tr>                            
	    <th class="width300">Unix 服务器IP</th>
	    <th>包月</th>
	    <th>套餐</th>
	    <th>计时</th>
	</tr>
	<s:iterator value="pager.list">                     
	<tr>
	    <td>${id }</td>
		<td>${c1 }</td>
		<td>${c2 }</td>
		<td>${c3 }</td>
	</tr>
	</s:iterator> 
</table>