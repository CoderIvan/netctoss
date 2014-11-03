package com.tarena.netctoss.manager.reportmanager;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.report.DurationTopThree;
import com.tarena.netctoss.manager.ReportManager;

public class FindDurationTopThreeTest extends BaseConfig {

	@Resource
	private ReportManager reportManager;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindDurationTopThree() throws Exception {
		Pager pager = reportManager.findDurationTopThree(new Pager(5));
		StringBuilder buf = new StringBuilder();
		for (DurationTopThree dtt : (List<DurationTopThree>) pager.getList()) {
			buf.append(dtt.getUnixHost()).append("\t");
			buf.append(dtt.getOsUsername()).append("\t");
			buf.append(dtt.getRealName()).append("\t");
			buf.append(dtt.getIdcardNo()).append("\t");
			buf.append(dtt.getDuration()).append("\n");
		}
		System.err.println(buf.toString());
	}
}
