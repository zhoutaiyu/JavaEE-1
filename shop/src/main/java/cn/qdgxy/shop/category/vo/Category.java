package cn.qdgxy.shop.category.vo;

import java.util.HashSet;
import java.util.Set;

import cn.qdgxy.shop.categorysecond.vo.CategorySecond;

public class Category {

	private Integer cid; // 分类ID
	private String cname; // 分类名
	private String ctime; // 分类时间
	private Integer is_del; // 是否删除

	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>(); // 二级分类集合

	public Category() {
		super();
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public Integer getIs_del() {
		return is_del;
	}

	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}

	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", ctime=" + ctime
				+ ", is_del=" + is_del + ", categorySeconds=" + categorySeconds
				+ "]";
	}

}
