package com.tarena.netctoss.bean;

import javax.servlet.http.HttpServletRequest;

public class MyPager extends Pager {

	private int beginPage;// 起始页码
	private int endPage;// 结束页码
	private int pageWith = 5;// 显示页码数
	private String url;
	private int totalPage; // 总页数

	public MyPager() {
		super();
	}

	public MyPager(int pageSize) {
		super(pageSize);
	}

	public MyPager(HttpServletRequest request, int pageSize) {
		this(pageSize);
		url = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getRequestURI();
		String pageStr = request.getParameter("page");
		if (pageStr != null) {
			try {
				setPage(Integer.parseInt(pageStr));
			} catch (Exception e) {
				System.out.println("页码异常");
				e.printStackTrace();
			}
		}
	}

	public boolean isHasPrevPage() {
		return getPage() > 1;
	}

	public boolean isHasNextPage() {
		return getPage() < totalPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	@Override
	public void setTotalCount(int totalCount) {
		super.setTotalCount(totalCount);

		totalPage = getTotalCount() / getPageSize();
		if (getTotalCount() % getPageSize() != 0) {
			totalPage++;
		}

		// 初始化当前页
		if (getPage() < 1) {
			setPage(1);
		} else if (getPage() > totalPage) {
			setPage(totalPage);
		}

		// 初始化页码池
		if (totalPage <= pageWith) {
			beginPage = 1;
			endPage = totalPage;
		} else {
			beginPage = getPage() - pageWith / 2;
			endPage = getPage() + pageWith / 2;
			if (beginPage < 1) {
				beginPage = 1;
				endPage = pageWith;
			} else if (endPage > totalPage) {
				beginPage = totalPage - pageWith + 1;
				endPage = totalPage;
			}
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
