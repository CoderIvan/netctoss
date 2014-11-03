<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="pages">
	<s:if test="accountPager.hasPrevPage">
		<a href="javascript:getPageAction(${accountPager.page-1})">上一页</a>
	</s:if>
	<s:else>
		<a>上一页</a>
	</s:else>
	<s:iterator begin="accountPager.beginPage" end="accountPager.endPage"
		var="p">
		<s:if test="#p==accountPager.page">
			<a href="javascript:getPageAction(${p})" class="current_page">${p}</a>
		</s:if>
		<s:else>
			<a href="javascript:getPageAction(${p})">${p}</a>
		</s:else>
	</s:iterator>

	<s:if test="accountPager.hasNextPage">
		<a href="javascript:getPageAction(${accountPager.page+1 })">下一页</a>
	</s:if>
	<s:else>
		<a>下一页</a>
	</s:else>
</div>