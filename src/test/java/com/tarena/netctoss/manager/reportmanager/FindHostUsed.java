package com.tarena.netctoss.manager.reportmanager;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.Host;
import com.tarena.netctoss.manager.ReportManager;

public class FindHostUsed extends BaseConfig {

	@Resource
	private ReportManager reportManager;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindHostUsed() throws Exception {
		Pager pager = reportManager.findHostUsed(new Pager(5));
		StringBuilder buf = new StringBuilder();
		for (Host host : (List<Host>) pager.getList()) {
			buf.append(host.getId()).append("\t");
			buf.append(host.getName()).append("\t");
			buf.append(host.getLocation()).append("\t");
			buf.append(host.getC1()).append("\t");
			buf.append(host.getC2()).append("\t");
			buf.append(host.getC3()).append("\n");
		}
		System.err.println(buf.toString());
	}
}
