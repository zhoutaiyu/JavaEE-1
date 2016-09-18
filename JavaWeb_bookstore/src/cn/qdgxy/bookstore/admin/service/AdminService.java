package cn.qdgxy.bookstore.admin.service;

import cn.qdgxy.bookstore.admin.dao.AdminDao;
import cn.qdgxy.bookstore.admin.domain.Admin;
import cn.qdgxy.bookstore.admin.domain.AdminException;

public class AdminService {

	private AdminDao adminDao = new AdminDao();

	/**
	 * 管理员登录
	 * 
	 * @param admin
	 * @return
	 * @throws AdminException
	 */
	public Admin login(Admin admin) throws AdminException {
		Admin adm = adminDao.findByUsername(admin.getUsername());
		if (adm == null) {
			throw new AdminException("管理员不存在！");
		}
		if (!adm.getPassword().equals(admin.getPassword())) {
			throw new AdminException("密码输入错误！");
		}
		return adm;
	}

	/**
	 * 按用户名查找
	 * 
	 * @param username
	 * @return
	 */
	public Admin findByUsername(String username) {
		return adminDao.findByUsername(username);
	}

}
