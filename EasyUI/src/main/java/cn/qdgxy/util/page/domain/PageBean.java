package cn.qdgxy.util.page.domain;

import java.util.List;

/**
 * 分页bean
 * 
 * @author 李欣
 *
 * @param <T>
 */
public class PageBean<T> {

	private int pageNumber; // 当前页码
	private int pageSize; // 每页记录数
	private int totalRecord; // 总记录数
	private List<T> beanList; // 当前页的记录
	private String url; // url后的条件

	public PageBean() {
		super();
	}

	/**
	 * 计算总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		int totalPage = totalRecord / pageSize;
		return totalRecord % pageSize == 0 ? totalPage : totalPage + 1;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PageBean [pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", totalRecord=" + totalRecord + ", beanList=" + beanList
				+ ", url=" + url + "]";
	}

}
