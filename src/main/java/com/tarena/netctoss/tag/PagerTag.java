package com.tarena.netctoss.tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.tarena.netctoss.bean.MyPager;

public class PagerTag extends SimpleTagSupport {
	private MyPager pager;

	@Override
	public void doTag() throws JspException, IOException {
		Writer out = getJspContext().getOut();

		// 设置分页DIV
		out.write("<div id='pages'>");

		// 设置“上一页”按钮
		if (pager.isHasPrevPage()) {
			out.write("<a href='"+pager.getUrl()+"?page="+(pager.getPage()-1)+"'>");
		} else {
			out.write("<a>");
		}
		out.write("上一页");
		out.write("</a>");

		// 设置中间页码
		for (int i = pager.getBeginPage(); i <= pager.getEndPage(); i++) {
			if (i == pager.getPage()) {
				out.write("<a href='"+pager.getUrl()+"?page="+i+"' class='current_page'>");
			} else {
				out.write("<a href='"+pager.getUrl()+"?page="+i+"'>");
			}
			out.write(i+"");
			out.write("</a>");
		}

		// 设置“下一页”按钮
		if (pager.isHasNextPage()) {
			out.write("<a href='"+pager.getUrl()+"?page="+(pager.getPage()+1)+"'>");
		} else {
			out.write("<a>");
		}
		out.write("下一页");
		out.write("</a>");

		// 分页结束
		out.write("</div>");
	}

	public void setPager(MyPager pager) {
		this.pager = pager;
	}

	public MyPager getPager() {
		return pager;
	}
}
