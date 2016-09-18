package cn.qdgxy.cstm.dao;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.qdgxy.cstm.domain.Customer;

public class CustomerTest {

	/**
	 * 生成测试数据
	 * 
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		CustomerDao dao = new CustomerDao();
		
		for (int i = 1; i <= 300; i++) {
			Customer c = new Customer();
			
			c.setCid(CommonUtils.uuid());
			c.setCname("cstm_" + i);
			c.setBirthday("2014-07-13");
			c.setGender(i%2==0?"男":"女");
			c.setCellphone("139" + i);
			c.setEmail("cstm_" + i + "@qq.com");
			c.setDescription("我是客户" + c.getCname());
			
			dao.add(c);
		}
	}

}
