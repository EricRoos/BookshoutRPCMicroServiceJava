package DBManagers;

import java.util.List;

public class PaginatedQueryResponse<K> {
	private List<K> data;
	private int numRecords;
	private int currentPage;
	private int pageSize;
	
	public PaginatedQueryResponse() {}
	public PaginatedQueryResponse(List<K> data, int numRecords, int currentPage, int pageSize) {
		super();
		this.data = data;
		this.numRecords = numRecords;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}


	public List<K> getData() {
		return data;
	}


	public void setData(List<K> data) {
		this.data = data;
	}


	public int getNumRecords() {
		return numRecords;
	}


	public void setNumRecords(int numRecords) {
		this.numRecords = numRecords;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
