package com.tarena.netctoss.manager.reportmanager;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.report.CustomerDuration;
import com.tarena.netctoss.manager.ReportManager;

public class FindCustomerDurationTest extends BaseConfig {
	
	@Resource
	private ReportManager reportManager;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindCustomerDuration() throws Exception {
		Pager pager = reportManager.findCustomerDuration(new Pager(5));
		
		StringBuilder buf = new StringBuilder();
		for(CustomerDuration cd : (List<CustomerDuration>) pager.getList()){
			buf.append(cd.getId()+"\t");
			buf.append(cd.getLoginName()+"\t");
			buf.append(cd.getRealName()+"\t");
			buf.append(cd.getIdcardNo()+"\t");
			buf.append(cd.getTelephone()+"\t");
			buf.append(cd.getMonth()+"\t");
			buf.append(cd.getDuration());
			buf.append("\n");
		}
		System.err.println(buf.toString());
		System.err.println(pager.getTotalCount());
	}

}
