package test;

import org.junit.Test;

import cn.qdgxy.form.dao.ProductDao;
import cn.qdgxy.form.domain.Product;
import cn.qdgxy.util.page.domain.PageBean;

public class ProductDaoTest {

	private ProductDao productDao = new ProductDao();

	@Test
	public void testFindAll() throws Exception {
		PageBean<Product> pb = productDao.findAll(2, 2);
		System.out.println(pb);
	}

	@Test
	public void testAdd() throws Exception {
		Product product = new Product();
		product.setName("碳素笔");
		product.setPrice(1d);

		productDao.add(product);
	}

	@Test
	public void testUpdate() throws Exception {
		Product product = new Product();
		product.setPid(3);
		product.setName("碳素笔");
		product.setPrice(1.5d);

		productDao.edit(product);
	}

	@Test
	public void testDelete() throws Exception {
		productDao.delete(3);
	}

}
