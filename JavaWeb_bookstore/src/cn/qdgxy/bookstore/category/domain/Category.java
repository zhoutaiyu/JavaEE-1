package cn.qdgxy.bookstore.category.domain;

/**
 * 图书分类
 * 
 * @author li119
 *
 */
public class Category {

	private String cid; // 分类ID
	private String cname; // 分类名

	public Category() {
		super();
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

}
